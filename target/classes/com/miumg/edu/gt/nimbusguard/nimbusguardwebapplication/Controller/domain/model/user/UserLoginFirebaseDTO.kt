package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserLoginFirebaseDTO(
    @JsonProperty("email")  val email: String,
    @JsonProperty("localId")  val uid: String


)