package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller

import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.alert.Alert
import com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.alert.AlertService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class MainControllerRestData(
    private val alertService: AlertService,

) {
    init {
        alertService.listenForAlerts()
    }

    @GetMapping("/alerts/stream", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    public fun getAlertsStreamData(): Flux<Alert> {
        return alertService.getAlertStream()
    }

}