package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.alert

import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.database.ChildEventListener
import reactor.core.publisher.Sinks

class Alert {
    private val instanciaFirestore = FirestoreClient.getFirestore();

    public fun CrearAlertas(){
        val chucho = hashMapOf(
            "name" to "perro",
            "estatura" to "1 metro",
            "estado" to "jiotoso",
        )
        instanciaFirestore.collection("animales").document("animal 2")
            .set(chucho as Map<String, Any>)

       
    }

}