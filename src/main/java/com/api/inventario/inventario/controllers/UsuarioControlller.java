package com.api.inventario.inventario.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable UUID id) {
        Usuario usuario = null;
        Map<String, Object> response = new HashMap<>();

        try {
            usuario = usuarioService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (usuario == null) {
            response.put("mensaje", "El usuario con ID " + id + " no fue encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

}
