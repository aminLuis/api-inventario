package com.api.inventario.inventario.interfaces;

import java.util.List;
import java.util.UUID;

import com.api.inventario.inventario.entities.Producto;

public interface IProducto {

    public List<Producto> findAll();

    public Producto findById(UUID id);

    public Producto save(Producto nuevo);

    public void delete(UUID id);
}
