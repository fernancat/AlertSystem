package com.miumg.edu.gt.nimbusguard.nimbusguardwebapplication.Controller.domain.model.user

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter


@AllArgsConstructor
@NoArgsConstructor
public class User(
    var uid:String,
     var name:String,
     var lastname:String,
     var email:String,
     var password:String,
     var cui:String,
     var number:String,
     var Department:String,
     var municipality:String,


) {

}