package com.criv.fact.servicedenuncia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "denuncias")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 8, nullable = false)
    private String dni;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(length = 3, nullable = false)
    private String titulo;

    @Column(length = 200, nullable = false)
    private String direccion;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false)
    private int estado = 1; // 1 = activa, 0 = anulada

    public Denuncia() {
    }

    public Denuncia(int id, String dni, Date fecha, String titulo, String direccion, String descripcion, int estado) {
        this.id = id;
        this.dni = dni;
        this.fecha = fecha;
        this.titulo = titulo;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
