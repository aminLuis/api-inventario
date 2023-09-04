package com.api.inventario.inventario.interfaces;

import java.util.List;
import java.util.UUID;

import com.api.inventario.inventario.entities.Usuario;

public interface IUsuario {
    public List<Usuario> findAll();

    public Usuario findById(UUID id);
}
