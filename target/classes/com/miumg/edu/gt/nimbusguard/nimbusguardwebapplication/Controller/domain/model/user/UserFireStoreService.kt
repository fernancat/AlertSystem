package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.DocumentSnapshot
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Service
class UserFireStoreService {
    private val fireStoreInstance = FirestoreClient.getFirestore()

    public fun obtenerUsuarioPorUID(uid:String): User {
        val refUser = fireStoreInstance.collection("users").document(uid)
        val future:ApiFuture<DocumentSnapshot> = refUser.get()
        val document:DocumentSnapshot = future.get()
        var user = User()

        if (document.exists()) {
            user = document.toObject(User::class.java)!!
            return user
        }


        return user







    }
}