package com.api.inventario.inventario.entities;

import java.util.UUID;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "auditoriaProducto")
@EntityListeners(AuditingEntityListener.class)
public class AuditoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String idUsuario;

    private String fechaEdit;

    private String idProducto;

    public UUID getId() {
        return id;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setFechaEdit(String fechaEdit) {
        this.fechaEdit = fechaEdit;
    }

    public String getFechaEdit() {
        return fechaEdit;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

}
