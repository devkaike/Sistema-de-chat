package com.kaike.Sistema.de.chat.modules.conversa.repository;

import com.kaike.Sistema.de.chat.modules.conversa.domain.Conversa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversaRepository extends JpaRepository<Conversa, Long> {
}
