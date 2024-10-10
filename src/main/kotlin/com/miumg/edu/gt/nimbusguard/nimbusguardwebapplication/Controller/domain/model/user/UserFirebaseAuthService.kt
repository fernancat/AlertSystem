package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user

import com.google.firebase.auth.FirebaseAuth
import org.springframework.stereotype.Service


@Service
public class UserFirebaseAuthService(
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
) {
}