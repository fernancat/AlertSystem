package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller

import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.alert.Alert
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user.User
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user.UserFireStoreService
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user.UserFirebaseAuthService
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


import reactor.core.publisher.Mono

@Controller
class MainController(

    private val authService:UserFirebaseAuthService,
    private val userFireStoreService: UserFireStoreService
) {

    @GetMapping("/")
    public fun login(model: Model): String {
        model.addAttribute("user",User() )

        val alert = Alert()
        alert.CrearAlertas()
        return "LoginInicio"
    }
    @GetMapping("/alert-details")
    fun alertDetails(Model: Model) :String {
        return "alert-details"
    }

    @PostMapping("/login")
    fun loginUser(
        @ModelAttribute user: User,
        model: Model,
        session:HttpSession
    ): Mono<String> {
        println(user.email + user.password)
        return authService.loginUser(user.email, user.password)
            .flatMap { response ->
                model.addAttribute("response", response)

                val user =  userFireStoreService.obtenerUsuarioPorUID(response.uid)
                println(user.name + user.department)
                session.setAttribute("user",user)

                Mono.just("dashboard") // Redirige a "dashboard" si el login es exitoso
            }
            .onErrorResume { e ->
                println(e.message)
                model.addAttribute("error", "Authentication failed: ${e.message}")
                Mono.just("redirect:/")
            }
    }

    @GetMapping("/register")
    public fun register(Model: Model): String {
        return "register"
    }

    @PostMapping("/register")
    public fun registerUser(Model: Model, @ModelAttribute user:User): String{
        
        return "redirect:/"
    }
}