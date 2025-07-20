package com.criv.fact.servicedenuncia.repository;

import com.criv.fact.servicedenuncia.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
    List<Denuncia> findByDni(String dni);
}