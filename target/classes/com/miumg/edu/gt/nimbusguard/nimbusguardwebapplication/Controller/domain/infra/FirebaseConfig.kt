package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.infra

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration
import java.io.InputStream


@Configuration
class FirebaseConfig {
    @PostConstruct
    public fun postConstruct() {
       val fileDataConnection:InputStream = javaClass.classLoader.getResourceAsStream("nimbusguard-ab7d9-firebase-adminsdk-8c07z-d9d42c8961.json")!!

        val firebaseOptions: FirebaseOptions = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(fileDataConnection))
            .setDatabaseUrl("https://nimbusguard-ab7d9-default-rtdb.firebaseio.com")
            .build();

        FirebaseApp.initializeApp(firebaseOptions)

    }

}