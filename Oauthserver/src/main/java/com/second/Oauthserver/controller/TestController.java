package com.second.Oauthserver.controller;

import com.second.Oauthserver.dto.request.UserRegisterRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //@PreAuthorize("")
    @GetMapping("/name")
    public  String getName(){
      return "name";
    }

//    @PostMapping("/save")
//    public void saveUser(UserRegisterRequest userRegisterRequest){
//     System.out.println(userRegisterRequest.getPassword());
//     System.out.println(userRegisterRequest.getUsername());
//    }



    //@PreAuthorize("permitAll()")
    @GetMapping("/m1")
    public String m1(){
      return "m1";
    }


    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping("/check")
    public String check(){
       return "check";
    }



}
