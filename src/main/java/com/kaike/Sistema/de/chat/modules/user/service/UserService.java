package com.kaike.Sistema.de.chat.modules.user.service;

import com.kaike.Sistema.de.chat.modules.roles.domain.Role;
import com.kaike.Sistema.de.chat.modules.roles.repository.RoleRepositoty;
import com.kaike.Sistema.de.chat.modules.user.domain.User;
import com.kaike.Sistema.de.chat.modules.user.repository.UserRepository;
import com.kaike.Sistema.de.chat.util.DTOs.serviceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepositoty roleRepositoty;

    public serviceResponseDTO criarUser(User user){

        Role basicRole = roleRepositoty.findByNome("ADMIN");

        if (basicRole == null) {
            new serviceResponseDTO(404,"Role de usuário não encontrada.");
        }
        user.setRole(basicRole);
        user.setSenha(passwordEncoder.encode(user.getSenha()));

        userRepository.save(user);
        return new serviceResponseDTO(200, "cadastro realizado com sucesso!");
    }

    public serviceResponseDTO buscarUser(){
        return new serviceResponseDTO(200, userRepository.findAll());
    }

    public serviceResponseDTO buscarPorIdUser(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            return new serviceResponseDTO(404, "user not found");
        }

        return new serviceResponseDTO(200, user.get());
    }

    public serviceResponseDTO buscarPorEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            return new serviceResponseDTO(404, "Email não cadastrado");
        }

        return new serviceResponseDTO(200, user.get());
    }

}
