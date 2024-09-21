package com.example.apirest.config;

import com.example.apirest.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

//Revision listener es el encargado de hacer las revisiones
public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity){
        final Revision revision = (Revision) revisionEntity;
    }
}
