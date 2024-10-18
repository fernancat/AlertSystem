package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.alert

import com.google.cloud.firestore.DocumentChange
import com.google.firebase.cloud.FirestoreClient
import io.grpc.internal.MessageFramer
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks

@Service
class AlertService {
    private val sink:Sinks.Many<Alert> = Sinks.many().multicast().directAllOrNothing()
    private val alertsRef = FirestoreClient.getFirestore().collection("alerts")

    public fun addAlert(alert: Alert) {
        val alertRef = alertsRef.add(alert).get()
        val alertId = alertRef.id // Obtiene el ID del nuevo documento


        // println("Alerta añadida con ID: $alertId")
        //sink.tryEmitNext(alert)
    }

    public fun listenForAlerts() {

        alertsRef.addSnapshotListener { snapshots, error ->
            if (error != null) {
                println("Error al escuchar cambios: ${error.message}")
                return@addSnapshotListener
            }
            if (snapshots != null) {
                for (doc in snapshots.documentChanges) {
                    when (doc.type) {
                        DocumentChange.Type.ADDED -> {
                            val alert = doc.document.toObject(Alert::class.java)
                            val alertId = doc.document.id
                            sink.tryEmitNext(alert)
                            println("Alerta añadida: $alert")
                        }
                        DocumentChange.Type.MODIFIED -> {
                            val updatedAlert = doc.document.toObject(Alert::class.java)
                            val alertId = doc.document.id
                            println("La alerta con ID: $alertId cambió sus datos a: $updatedAlert")
                            sink.tryEmitNext(updatedAlert)
                        }
                        DocumentChange.Type.REMOVED -> {

                        }
                    }


                }
            }
        }


    }
    public fun getAlertStream(): Flux<Alert> {
        return sink.asFlux()
    }
}