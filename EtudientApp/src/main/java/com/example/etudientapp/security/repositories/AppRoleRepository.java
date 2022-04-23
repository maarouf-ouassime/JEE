package com.example.etudientapp.security.repositories;

import com.example.etudientapp.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {

    AppRole findByRoleName(String rolename);


}
