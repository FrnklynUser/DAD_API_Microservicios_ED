package com.ramos.servicedenuncia.controller;

import com.ramos.servicedenuncia.entity.Denuncia;
import com.ramos.servicedenuncia.service.DenunciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService service;

    @PostMapping
    public ResponseEntity<Denuncia> registrar(@RequestBody Denuncia denuncia) {
        denuncia.setCreatedAt(LocalDateTime.now());
        denuncia.setEstado(1);
        return new ResponseEntity<>(service.create(denuncia), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Denuncia>> listar(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "5") int limit) {
        Pageable page = PageRequest.of(offset, limit);
        return ResponseEntity.ok(service.getAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Denuncia> obtenerPorId(@PathVariable int id) {
        Denuncia denuncia = service.getById(id);
        if (denuncia == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(denuncia);
    }

    @GetMapping("/usuario/{dni}")
    public ResponseEntity<List<Denuncia>> obtenerPorDni(@PathVariable String dni) {
        return ResponseEntity.ok(service.getByDni(dni));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Denuncia> anular(@PathVariable int id) {
        Denuncia denuncia = service.anular(id);
        if (denuncia == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(denuncia);
    }
}
