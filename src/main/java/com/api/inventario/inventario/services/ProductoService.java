package com.api.inventario.inventario.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.inventario.DTOs.ProductoDto;
import com.api.inventario.inventario.dao.ProductoRepositoryDao;
import com.api.inventario.inventario.entities.Producto;
import com.api.inventario.inventario.interfaces.IProducto;

@Service
public class ProductoService implements IProducto {

    @Autowired
    private ProductoRepositoryDao productoRepositoryDao;

    @Override
    public List<ProductoDto> findAll() {
        List<Producto> productos = productoRepositoryDao.findAll();

        List<ProductoDto> productoUsurio = new ArrayList<>();
        for (Producto producto : productos) {
            ProductoDto dto = new ProductoDto();
            dto.setId(producto.getId());
            dto.setNombre(producto.getNombre());
            dto.setCantidad(producto.getCantidad());
            dto.setFechaIngreso(producto.getFechaIngreso());
            // dto.setUsuario(producto.getUsuario());
            productoUsurio.add(dto);
        }

        return productoUsurio;
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
