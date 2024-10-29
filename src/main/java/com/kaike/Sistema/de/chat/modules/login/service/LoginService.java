package com.kaike.Sistema.de.chat.modules.login.service;

import com.kaike.Sistema.de.chat.modules.login.dto.LoginRequest;
import com.kaike.Sistema.de.chat.modules.login.dto.LoginResponse;
import com.kaike.Sistema.de.chat.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoginService {
    private JwtEncoder jwtEncoder;
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public LoginService(JwtEncoder jwtEncoder, BCryptPasswordEncoder passwordEncoder, UserRepository userRepository){
        this.jwtEncoder = jwtEncoder;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public LoginResponse authenticateUser(LoginRequest loginRequest){
        var user = userRepository.findByEmail(loginRequest.email());

        if(user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)){
            throw new BadCredentialsException("user or password is invalid!");
        }

        var userOptional = user.get();
        var id = userOptional.getId();
        var now = Instant.now();
        var expiresIn = 3000L;

        String scope = user.get().getRole().getNome();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("spring-security-jwt")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .subject(user.get().getEmail())
                .claim("scope",scope)
                .build();
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(jwtValue, expiresIn, id);
    }
}
