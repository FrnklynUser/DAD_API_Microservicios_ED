package com.criv.fact.servicedenuncia.service;

import com.criv.fact.servicedenuncia.entity.Denuncia;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DenunciaService {
    List<Denuncia> getAll(Pageable page);
    Denuncia getById(int id);
    List<Denuncia> getByDni(String dni);
    Denuncia create(Denuncia denuncia);
    Denuncia anular(int id);
    void delete(int id);
}
