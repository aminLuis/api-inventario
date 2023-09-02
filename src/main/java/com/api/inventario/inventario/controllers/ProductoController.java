package com.api.inventario.inventario.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inventario.inventario.entities.Producto;
import com.api.inventario.inventario.interfaces.IProducto;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProducto productoService;

    @GetMapping("/getAll")
    public List<Producto> getProductos() {
        return productoService.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getProducto(@PathVariable UUID id) {
        Producto producto = null;
        Map<String, Object> response = new HashMap<>();

        try {
            producto = productoService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (producto == null) {
            response.put("mensaje", "El producto con ID " + id + " no fue encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Producto nuevo) {
        Producto producto = null;
        Map<String, Object> response = new HashMap<>();

        try {
            producto = productoService.save(nuevo);
            response.put("mensaje", "Producto registrado con exito");
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al registrar en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(producto, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody Producto producto) {
        Producto actual = productoService.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (actual == null) {
            response.put("mensaje", "El producto con ID " + id + " no fue encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            actual.setNombre(producto.getNombre());
            actual.setCantidad(producto.getCantidad());
            actual.setFechaIngreso(producto.getFechaIngreso());

            productoService.save(actual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar producto");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(actual, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        Map<String, Object> response = new HashMap<>();

        try {
            productoService.delete(id);
            response.put("mensaje", "Producto eliminado con exito");
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar producto con ID " + id);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
