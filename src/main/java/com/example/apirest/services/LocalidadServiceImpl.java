package com.example.apirest.services;

import com.example.apirest.entities.Localidad;
import com.example.apirest.repositories.BaseRepository;
import com.example.apirest.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl (BaseRepository<Localidad, Long> baseRepository){
        super(baseRepository);
    }
}
