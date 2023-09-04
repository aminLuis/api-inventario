package com.api.inventario.inventario.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inventario.inventario.entities.AuditoriaProducto;
import com.api.inventario.inventario.interfaces.IAuditoriaProducto;

@RestController
@RequestMapping("/auditoriaProducto")
public class AuditoriaProductoController {

    @Autowired
    private IAuditoriaProducto auditoriaProductoService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AuditoriaProducto nuevo) {
        AuditoriaProducto data = null;
        Map<String, Object> response = new HashMap<>();

        try {
            data = auditoriaProductoService.save(nuevo);
            response.put("mensaje", "Auditoría registrada con exito");
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al registrar en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(data, HttpStatus.CREATED);

    }

}
