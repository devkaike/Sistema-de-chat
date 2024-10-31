package com.kaike.Sistema.de.chat.modules.conversa.service;

import com.kaike.Sistema.de.chat.modules.conversa.domain.Conversa;
import com.kaike.Sistema.de.chat.modules.conversa.repository.ConversaRepository;
import com.kaike.Sistema.de.chat.util.DTOs.serviceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversaService {

    @Autowired
    private ConversaRepository conversaRepository;

    public serviceResponseDTO criarConversa(Conversa conversa){
        conversaRepository.save(conversa);
        return new serviceResponseDTO(200, "conversa criada!");
    }

    public serviceResponseDTO listarConversa(){
        return new serviceResponseDTO(200, conversaRepository.findAll());
    }
}
