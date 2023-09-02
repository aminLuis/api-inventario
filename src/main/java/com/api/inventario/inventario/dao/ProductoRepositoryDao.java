package com.api.inventario.inventario.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.inventario.inventario.entities.Producto;

public interface ProductoRepositoryDao extends JpaRepository<Producto, UUID> {

}
