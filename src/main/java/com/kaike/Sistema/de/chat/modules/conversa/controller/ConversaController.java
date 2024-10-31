package com.kaike.Sistema.de.chat.modules.conversa.controller;

import com.kaike.Sistema.de.chat.modules.conversa.domain.Conversa;
import com.kaike.Sistema.de.chat.modules.conversa.service.ConversaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conversa")
public class ConversaController {

    @Autowired
    private ConversaService conversaService;

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@Validated @RequestBody Conversa conversa){
        var response = conversaService.criarConversa(conversa);
        return ResponseEntity.status(response.status()).body(response.message());
    }

    @GetMapping("/Listar")
    public ResponseEntity<?> listar(){
        var response = conversaService.listarConversa();
        return ResponseEntity.status(response.status()).body(response.message());
    }
}
