package com.example.etudientapp.service;

import com.example.etudientapp.entities.Etudiant;
import org.springframework.data.domain.Page;

public interface EtudiantService {
    Page<Etudiant> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
