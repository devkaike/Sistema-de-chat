package com.kaike.Sistema.de.chat.modules.user.domain;

import com.kaike.Sistema.de.chat.modules.login.dto.LoginRequest;
import com.kaike.Sistema.de.chat.modules.roles.domain.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user")
@Data
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id;

    private String email;

    private String Senha;
    @ManyToOne
    @JoinColumn
    private Role role;

    public boolean isLoginCorrect(LoginRequest loginRequest, BCryptPasswordEncoder passwordEncoder){
        return passwordEncoder.matches(loginRequest.senha(), this.Senha);
    }
}
