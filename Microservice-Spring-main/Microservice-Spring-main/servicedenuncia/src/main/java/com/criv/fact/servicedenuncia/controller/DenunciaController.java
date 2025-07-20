package com.criv.fact.servicedenuncia.controller;

import com.criv.fact.servicedenuncia.entity.Denuncia;
import com.criv.fact.servicedenuncia.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/denuncias")
public class DenunciaController {
    @Autowired
    private DenunciaService service;

    @GetMapping
    public ResponseEntity<List<Denuncia>> getAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Denuncia> registros = service.getAll(page);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Denuncia> getById(@PathVariable("id") int id) {
        Denuncia denuncia = service.getById(id);
        return ResponseEntity.ok(denuncia);
    }

    @GetMapping("/usuario/{dni}")
    public ResponseEntity<List<Denuncia>> getByDni(@PathVariable("dni") String dni) {
        List<Denuncia> denuncias = service.getByDni(dni);
        return ResponseEntity.ok(denuncias);
    }

    @PostMapping
    public ResponseEntity<Denuncia> create(@RequestBody Denuncia denuncia) {
        Denuncia registro = service.create(denuncia);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @PutMapping("/{id}/anular")
    public ResponseEntity<Denuncia> anular(@PathVariable("id") int id) {
        Denuncia registro = service.anular(id);
        return ResponseEntity.ok(registro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
