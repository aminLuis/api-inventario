package com.api.inventario.inventario.interfaces;

import java.util.List;

import com.api.inventario.inventario.entities.Usuario;

public interface IUsuario {
    public List<Usuario> findAll();
}
