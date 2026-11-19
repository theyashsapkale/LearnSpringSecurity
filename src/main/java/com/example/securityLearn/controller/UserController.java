package com.example.securityLearn.controller;

import com.example.securityLearn.Dto.UserRegisterRequestDto;
import com.example.securityLearn.Dto.UserRegisterResponseDto;
import com.example.securityLearn.Servisec.AuthServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class UserController {

    private AuthServices authServices;

    public UserController (AuthServices authServices){
      this.authServices = authServices;
    }

    @GetMapping()
    public String  hello(){
        return "Hello";
    }

    @PostMapping("/Register")
    public ResponseEntity<UserRegisterResponseDto> register(
            @RequestBody UserRegisterRequestDto userRegisterRequestDto){

        UserRegisterResponseDto userRegisterResponseDto =
                authServices.register(userRegisterRequestDto);

        return ResponseEntity.ok(userRegisterResponseDto);


    }

}
