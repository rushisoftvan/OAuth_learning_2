package com.second.Oauthserver.controller;

import com.second.Oauthserver.dto.request.UserRegisterRequest;
import com.second.Oauthserver.dto.response.ApiResponse;
import com.second.Oauthserver.entity.UserOneEntity;
import com.second.Oauthserver.service.UserOneService;
import com.second.Oauthserver.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

 private final UserOneService userOneService;

    private final UserService userService;

    @PostMapping("/users")
    public ApiResponse<Integer> registerUser(@RequestBody UserRegisterRequest userRegisterRequest){
        Integer savedDataId = this.userService.registerUser(userRegisterRequest);
        ApiResponse.ApiResponseBuilder<Integer> builder = ApiResponse.builder();
        return builder.data( savedDataId).statusCode(HttpStatus.OK.value()).build();
    }

    @GetMapping("/test1")
    public String getTest(){
      return "test1";
    }

    @PostMapping("/data")
    public void getData(@RequestBody UserRegisterRequest userRegisterRequest){
       log.info(userRegisterRequest.getEmail());
       log.info(userRegisterRequest.getFirstname());
       log.info(String.valueOf(userRegisterRequest.getRoleId()));
    }

    @PostMapping("/userone")
    public void saveUserOne(@RequestBody UserOneEntity userOneEntity){
       this.userOneService.saveUserOne(userOneEntity);
    }

}
