package com.api.inventario.inventario.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inventario.inventario.entities.Usuario;
import com.api.inventario.inventario.interfaces.IUsuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlller {

    @Autowired
    private IUsuario usuarioService;

    @GetMapping("/getAll")
    public List<Usuario> getAll() {
        return usuarioService.findAll();
    }

}
