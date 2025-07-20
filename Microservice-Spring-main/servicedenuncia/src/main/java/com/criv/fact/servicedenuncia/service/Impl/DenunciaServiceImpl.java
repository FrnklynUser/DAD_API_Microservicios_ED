package com.criv.fact.servicedenuncia.service.Impl;

import com.criv.fact.servicedenuncia.entity.Denuncia;
import com.criv.fact.servicedenuncia.repository.DenunciaRepository;
import com.criv.fact.servicedenuncia.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DenunciaServiceImpl implements DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> getAll(Pageable page) {
        try {
            return repository.findAll(page).toList();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Denuncia getById(int id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> getByDni(String dni) {
        try {
            return repository.findByDni(dni);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Denuncia create(Denuncia denuncia) {
        try {
            return repository.save(denuncia);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public Denuncia anular(int id) {
        try {
            Denuncia denuncia = repository.findById(id).orElseThrow();
            denuncia.setEstado(0); // Estado "0" = Anulado
            return repository.save(denuncia);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
