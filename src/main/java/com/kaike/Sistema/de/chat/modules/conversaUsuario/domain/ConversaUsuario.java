package com.kaike.Sistema.de.chat.modules.conversaUsuario.domain;

import com.kaike.Sistema.de.chat.modules.conversa.domain.Conversa;
import com.kaike.Sistema.de.chat.modules.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "conversa_usuario")
@Getter
@Setter
public class ConversaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conversa_usuario")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "conversa_id", nullable = false)
    private Conversa conversa;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    private LocalDateTime data_entrada = LocalDateTime.now();

    private LocalDateTime data_saida;

    private boolean status_leitura;
}
