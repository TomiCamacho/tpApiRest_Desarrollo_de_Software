package com.example.apirest.controllers;

import com.example.apirest.entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.Serializable;

// Define una interfaz genérica para controladores base
public interface BaseController<E extends Base, ID extends Serializable> {

    // Metodo para obtener todas las entidades
    public ResponseEntity<?> getAll();
    // <?> implica cualquier entidad que extienda de Object
    public ResponseEntity<?> getAll(Pageable pageable);
    // Metodo para obtener una entidad por su ID
    public ResponseEntity<?> getOne(@PathVariable ID id);

    // Metodo para guardar una nueva entidad
    public ResponseEntity<?> save(@RequestBody E entity);

    // Metodo para actualizar una entidad existente por su ID
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);

    // Metodo para eliminar una entidad por su ID
    public ResponseEntity<?> delete(@PathVariable ID id);
}

// BaseController: Es una interfaz genérica que define los métodos CRUD básicos
// (getAll, getOne, save, update, delete) para cualquier entidad que extienda Base.