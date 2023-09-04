package com.api.inventario.inventario.DTOs;

import java.util.UUID;

public class ProductoDto {

    private UUID id;

    private String nombre;

    private int cantidad;

    private String fechaIngreso;

    private UUID usuario;

    public void setId(UUID id) {
        this.id = id;
    }

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

    public void setUsuario(UUID usuario) {
        this.usuario = usuario;
    }

    public UUID getUsuario() {
        return usuario;
    }
}
