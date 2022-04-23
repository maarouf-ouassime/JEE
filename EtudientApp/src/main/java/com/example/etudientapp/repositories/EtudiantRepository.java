package com.example.etudientapp.repositories;

import com.example.etudientapp.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findEtudiantByNom(String nom);

    Page<Etudiant> findByNomContains(String keyword, Pageable pageable);

}
