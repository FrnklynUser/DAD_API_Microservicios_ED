package com.ramos.servicedenuncia.service;

import com.ramos.servicedenuncia.entity.Denuncia;
import com.ramos.servicedenuncia.repository.DenunciaRepository;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DenunciaService {
    Denuncia create(Denuncia denuncia);
    List<Denuncia> getAll(Pageable pageable);
    Denuncia getById(int id);
    List<Denuncia> getByDni(String dni);
    Denuncia anular(int id);
}
