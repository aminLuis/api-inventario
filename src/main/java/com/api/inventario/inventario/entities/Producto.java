package com.api.inventario.inventario.entities;

import java.util.UUID;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
@EntityListeners(AuditingEntityListener.class)
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String nombre;

    private int cantidad;

    private String fechaIngreso;

    private UUID idUsuario;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public UUID getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setIdUsuario(UUID id) {
        this.idUsuario = id;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
