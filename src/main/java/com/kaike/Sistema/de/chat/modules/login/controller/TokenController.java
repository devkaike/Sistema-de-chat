package com.kaike.Sistema.de.chat.modules.login.controller;

import com.kaike.Sistema.de.chat.modules.login.dto.LoginRequest;
import com.kaike.Sistema.de.chat.modules.login.dto.LoginResponse;
import com.kaike.Sistema.de.chat.modules.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class TokenController {
    @Autowired
    public LoginService loginService;

    @PostMapping("/auth/user")
    public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest){
        LoginResponse response = loginService.authenticateUser(loginRequest);
        return  ResponseEntity.ok(response);
    }
}
