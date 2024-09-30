package com.example.apirest.controllers;

import com.example.apirest.entities.Base;
import com.example.apirest.entities.Persona;
import com.example.apirest.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

// Clase abstracta que implementa la interfaz BaseController
public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {

    // Inyección de dependencias del servicio correspondiente
    @Autowired
    protected S service;

    // Metodo para obtener todas las entidades
    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        try {
            // Devuelve todas las entidades con estado HTTP 200 (OK)
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            // En caso de error, devuelve un mensaje de error con estado HTTP 404 (Not Found)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable) {
        try {
            // Devuelve todas las entidades con estado HTTP 200 (OK)
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        } catch (Exception e) {
            // En caso de error, devuelve un mensaje de error con estado HTTP 404 (Not Found)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    // Metodo para obtener una entidad por su ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            // Devuelve la entidad encontrada con estado HTTP 200 (OK)
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            // En caso de error, devuelve un mensaje de error con estado HTTP 404 (Not Found)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    // Metodo para guardar una nueva entidad
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody E entity) {
        try {
            // Guarda la entidad y devuelve el resultado con estado HTTP 200 (OK)
            return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
        } catch (Exception e) {
            e.printStackTrace(); // Para depuración
            // En caso de error, devuelve un mensaje de error con estado HTTP 400 (Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    // Metodo para actualizar una entidad existente por su ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity) {
        try {
            // Actualiza la entidad y devuelve el resultado con estado HTTP 200 (OK)
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        } catch (Exception e) {
            // En caso de error, devuelve un mensaje de error con estado HTTP 400 (Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    // Metodo para eliminar una entidad por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            // Elimina la entidad y devuelve el resultado con estado HTTP 204 (No Content)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
        } catch (Exception e) {
            // En caso de error, devuelve un mensaje de error con estado HTTP 400 (Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}

// Es una clase abstracta que implementa BaseController y proporciona la implementación de los métodos
// CRUD utilizando un servicio (service) inyectado. Cada metodo maneja las operaciones correspondientes
// y devuelve una ResponseEntity con el estado HTTP adecuado.
