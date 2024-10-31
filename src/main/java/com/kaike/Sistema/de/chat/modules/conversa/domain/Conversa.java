package com.kaike.Sistema.de.chat.modules.conversa.domain;

import com.kaike.Sistema.de.chat.modules.conversaUsuario.domain.ConversaUsuario;
import com.kaike.Sistema.de.chat.modules.mensagem.domain.Mensagem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "conversa")
@Getter
@Setter
public class Conversa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conversa")
    private Long id;

    private String nome;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "conversa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConversaUsuario> usuarios;

    @OneToMany(mappedBy = "conversa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mensagem> mensagens;

}
