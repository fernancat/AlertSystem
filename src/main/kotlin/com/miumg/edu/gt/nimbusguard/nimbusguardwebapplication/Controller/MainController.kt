package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MainController {

    @GetMapping("/")
    public fun login(Model: Model): String {
        return "LoginInicio"
    }

    @PostMapping("/login")
    public fun auth(Model: Model): String {
        return "redirect:/"
    }

    @GetMapping("/register")
    public fun register(Model: Model): String {
        return "register"
    }

    @PostMapping("/register")
    public fun registerUser(Model: Model): String{

        return "redirect:/"
    }
}