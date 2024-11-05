package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.alert

import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.database.ChildEventListener
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user.User
import reactor.core.publisher.Sinks

data class Alert (
    var typeAlert:String = "",
    var id:String = "",
    var detail: String = "",
    var idButton: String = "",
    var idAlert:String ="",
    var state:String="",
    val user: User = User(),
    val userId:String="",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val date:String = ""

)