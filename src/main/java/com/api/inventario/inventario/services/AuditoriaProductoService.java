package com.api.inventario.inventario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.inventario.dao.AuditoriaProductoRepositoryDao;
import com.api.inventario.inventario.entities.AuditoriaProducto;
import com.api.inventario.inventario.interfaces.IAuditoriaProducto;

@Service
public class AuditoriaProductoService implements IAuditoriaProducto {

    @Autowired
    private AuditoriaProductoRepositoryDao auditoriaProductoDao;

    @Override
    public AuditoriaProducto save(AuditoriaProducto nuevo) {
        return auditoriaProductoDao.save(nuevo);
    }

}
