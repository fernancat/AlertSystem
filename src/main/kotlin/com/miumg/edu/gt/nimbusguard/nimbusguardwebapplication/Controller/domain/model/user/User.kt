package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User(
    private val name:String,
    private val lastname:String,
    private val email:String,
    private val password:String,
    private val cui:String,
    private val number:String,
    private val Department:String,
    private val municipality:String,


) {
}