package com.api.inventario.inventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.inventario.dao.UsuarioRepositoryDao;
import com.api.inventario.inventario.entities.Usuario;
import com.api.inventario.inventario.interfaces.IUsuario;

@Service
public class UsuarioService implements IUsuario {

    @Autowired
    private UsuarioRepositoryDao usuarioRepositoryDao;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepositoryDao.findAll();
    }

}
