package com.kaike.Sistema.de.chat.modules.roles.repository;

import com.kaike.Sistema.de.chat.modules.roles.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositoty extends JpaRepository<Role, Long> {

    Role findByNome(String nome);
}
