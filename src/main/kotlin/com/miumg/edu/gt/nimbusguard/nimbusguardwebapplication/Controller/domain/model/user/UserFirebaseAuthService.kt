package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord.CreateRequest
import org.springframework.stereotype.Service


@Service
public class UserFirebaseAuthService(
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    public fun loginUser(user : User): Boolean {
        val userEmail:String = user.email
        val userPassword:String = user.password
        val userUid:String = user.uid
        if (userEmail == null || userPassword == null) {
            return false;
        }else{

            return true;
        }
    }


    public fun registerUser(user : User): Boolean {
        val userEmail: String = user.email
        val userPassword: String = user.password
        val userPhoneNumber:String = user.number;

        if (userEmail == null || userPassword == null) {
            return false;
        }else{
            val userCreateRequest:CreateRequest = CreateRequest()
                .setEmail(userEmail)
                .setPassword(userPassword)
                .setPhoneNumber(userPhoneNumber)

            firebaseAuth.createUser(userCreateRequest)
            return true;
        }
    }
}