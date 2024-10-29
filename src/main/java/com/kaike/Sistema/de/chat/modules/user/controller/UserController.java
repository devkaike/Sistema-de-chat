package com.kaike.Sistema.de.chat.modules.user.controller;

import com.kaike.Sistema.de.chat.modules.user.domain.User;
import com.kaike.Sistema.de.chat.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/criar")
    public ResponseEntity<?> criar(@Validated @RequestBody User user){
        var response = userService.criarUser(user);
        return ResponseEntity.status(response.status()).body(response.message());
    }
}
