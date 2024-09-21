package com.example.apirest.services;

import com.example.apirest.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, ID extends Serializable>{
    public List<E> findAll() throws Exception; //Lista de las entidades de un tipo que queramos obtener
    public E findById(ID id) throws Exception; //Busca un único registro de una entidad en la BD
    public E save(E entity) throws Exception; //Crear un registro de una entidad en la BD
    public E update(ID id, E entity) throws Exception; //Actualizar un registro en la BD
    public boolean delete(ID id) throws Exception; //Eliminar un registro en la BD
}
