package com.kaike.Sistema.de.chat.modules.mensagem.domain;

import com.kaike.Sistema.de.chat.modules.conversa.domain.Conversa;
import com.kaike.Sistema.de.chat.modules.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "mensagem")
@Getter
@Setter
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensagem")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conversa_id", nullable = false)
    private Conversa conversa;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    private String conteudo;

    private LocalDateTime data_envio = LocalDateTime.now();

}
