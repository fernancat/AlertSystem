package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller

import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.alert.Alert
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.alert.AlertService
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user.User
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user.UserFireStoreService
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user.UserFirebaseAuthService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.WebSession


import reactor.core.publisher.Mono
import java.util.stream.Collectors

@Controller
class MainController(

    private val authService: UserFirebaseAuthService,
    private val userFireStoreService: UserFireStoreService,
    private val alertService: AlertService
) {

    @GetMapping("/")
    public fun login(model: Model): String {
        model.addAttribute("user",User() )

        return "LoginInicio"
    }


    @PostMapping("/login")
    fun loginUser(
        @ModelAttribute user: User,
        model: Model,
        session:WebSession
    ): Mono<String> {
        println(user.email + user.password)
        return authService.loginUser(user.email, user.password)
            .flatMap { response ->
                model.addAttribute("response", response)

                val user =  userFireStoreService.getUserByUID(response.uid)

                session.attributes.put("user",user)
                session.save()

                Mono.just("redirect:/dashboard") // Redirige a "dashboard" si el login es exitoso
            }
            .onErrorResume { e ->
                println(e.message)
                model.addAttribute("error", "Authentication failed: ${e.message}")
                Mono.just("redirect:/")
            }
    }

    @GetMapping("/register")
    public fun register(model: Model, user:User): String {
        model.addAttribute("user",user)
        return "register"
    }

    @PostMapping("/register")
    public fun registerUser(
        model: Model,
        @ModelAttribute user:User,
        session:WebSession
    ): Mono<String>{
        println(user.email)
        return authService.registerUser(user.email, user.password)
            .flatMap { response ->
                model.addAttribute("response", response)

                user.uid = response.uid
                user.rol = "socorrista"
                userFireStoreService.registerUserInFireStore(user)
                session.attributes.put("user",user)
                session.save()

                Mono.just("redirect:/dashboard") // Redirige a "dashboard" si el register es exitoso
            }
            .onErrorResume { e ->
                println(e.message)
                model.addAttribute("error", "Authentication failed: ${e.message}")
                Mono.just("redirect:/register")
            }

    }

    @GetMapping("/dashboard")
    public fun dashboard(
        model: Model,
        session:WebSession
    ):String{
        val user = session.getAttribute<User>("user")
        if (user?.rol != "socorrista" || user.rol.equals("")){
            return  "redirect:/"
        }
        model.addAttribute("user",user)
        model.addAttribute("totalAlerts",alertService.getAllAlerts().count())
        model.addAttribute("SolveAlert",alertService.getAllAlerts().stream()
            .filter({a -> a.state == "Resuelto"})
            .toList().count())
        return "dashboard"
    }

    @GetMapping("/AlertManagment")
    public fun getAlert(model:Model):String{
        model.addAttribute("alerts", alertService.getAllAlerts())

        return "AlertManagment"
    }


    @GetMapping("/alert-details/{uid}")
    public fun alertDetails(
       @PathVariable("uid") uid: String,
        model: Model,
        session:WebSession
    ): String {

        val user = session.getAttribute<User>("user")

        if (user?.rol != "socorrista" || user.rol.equals("")){
            return  "redirect:/"
        }

        val alert = alertService.getAlertByUID(uid)


        model.addAttribute("alert", alert   )


        model.addAttribute("user",user)










        return "alert-details"
    }
    @PostMapping("/alert-details")
    public fun alertDetails(@ModelAttribute alert:Alert,
                            session:WebSession):String{

        val user = session.getAttribute<User>("user")
        println("este es el nuevo id alert" +alert.idAlert)
        if (user?.rol != "socorrista" || user.rol.equals("")){
            return  "redirect:/"
        }else {
            if (alert.idAlert.isNotBlank()) {
                println("este es el estado" + alert.state)
                alertService.updateStateAlert(alert)
                return "redirect:/AlertManagment"

            }
        }
        return "redirect:/AlertManagment"
    }


}