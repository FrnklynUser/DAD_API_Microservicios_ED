package com.ramos.servicedenuncia.serviceImpl;

import com.ramos.servicedenuncia.service.DenunciaService;
import com.ramos.servicedenuncia.repository.DenunciaRepository;
import com.ramos.servicedenuncia.entity.Denuncia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DenunciaServiceImpl implements DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    @Override
    @Transactional
    public Denuncia create(Denuncia denuncia) {
        return repository.save(denuncia);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> getAll(Pageable pageable) {
        return repository.findAll(pageable).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Denuncia getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> getByDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    @Transactional
    public Denuncia anular(int id) {
        Denuncia denuncia = repository.findById(id).orElse(null);
        if (denuncia == null) return null;
        denuncia.setEstado(0);
        denuncia.setUpdatedAt(LocalDateTime.now());
        return repository.save(denuncia);
    }
}
