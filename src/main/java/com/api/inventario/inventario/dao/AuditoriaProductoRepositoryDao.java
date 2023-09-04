package com.api.inventario.inventario.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.inventario.inventario.entities.AuditoriaProducto;

public interface AuditoriaProductoRepositoryDao extends JpaRepository<AuditoriaProducto, UUID> {

}
