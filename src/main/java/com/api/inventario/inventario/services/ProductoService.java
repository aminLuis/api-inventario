package com.api.inventario.inventario.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.inventario.dao.ProductoRepositoryDao;
import com.api.inventario.inventario.entities.Producto;
import com.api.inventario.inventario.interfaces.IProducto;

@Service
public class ProductoService implements IProducto {

    @Autowired
    private ProductoRepositoryDao productoRepositoryDao;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepositoryDao.findAll();
    }

    @Override
    public Producto findById(UUID id) {
        return productoRepositoryDao.findById(id).orElseThrow(null);
    }

    @Override
    public Producto save(Producto nuevo) {
        return productoRepositoryDao.save(nuevo);
    }

    @Override
    public void delete(UUID id) {
        productoRepositoryDao.deleteById(id);
    }

}
