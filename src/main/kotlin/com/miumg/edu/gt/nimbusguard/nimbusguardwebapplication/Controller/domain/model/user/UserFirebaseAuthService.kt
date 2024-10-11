package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord.CreateRequest
import com.google.firebase.database.FirebaseDatabase
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


@Service
public class UserFirebaseAuthService(
    private val webClient: WebClient
) {
    private final val apikey: String = "AIzaSyC_5c3tI7QaTo_YLHbMiJS9zkgVLDO3oPw"
    private final val  baseURL:String = "accounts:signInWithPassword?key=$apikey"

    fun loginUser(email: String, password: String): Mono<UserLoginFirebaseDTO> {
        return webClient.post()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/accounts:signInWithPassword")
                    .queryParam("key", apikey)
                    .build()
            }
            .bodyValue(mapOf(
                "email" to email,
                "password" to password,
                "returnSecureToken" to true
            ))
            .retrieve()
            .bodyToMono(UserLoginFirebaseDTO::class.java)
    }

    fun registerUser(email: String, password: String): Mono<UserLoginFirebaseDTO> {
        return webClient.post()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/accounts:signUp")
                    .queryParam("key", apikey)
                    .build()
            }
            .bodyValue(mapOf(
                "email" to email,
                "password" to password,
                "returnSecureToken" to true
            ))
            .retrieve()
            .bodyToMono(UserLoginFirebaseDTO::class.java)
    }








}