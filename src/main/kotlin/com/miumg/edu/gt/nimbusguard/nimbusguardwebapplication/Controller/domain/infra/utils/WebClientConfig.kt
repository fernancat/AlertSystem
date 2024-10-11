package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.infra.utils

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean
    fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl("https://identitytoolkit.googleapis.com/v1") // Asegúrate de que la base URL sea correcta
            .build()
    }
}
