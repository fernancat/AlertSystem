package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class MainControllerRestData {

    @GetMapping("/alerts/stream", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    public fun getAlertsStreamData(){

    }

}