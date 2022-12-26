package com.portfolio.backend.service;

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.repository.REducacion;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    
    @Autowired
    public REducacion repoEdu;
    
    public List<Educacion> verEducacion(){
        List<Educacion> listaEducacion= repoEdu.findAll();
        return listaEducacion;
    }
    
    public void crearEducacion(Educacion edu){
        repoEdu.save(edu);
    }
    
    public void borrarEducacion(int id){
        repoEdu.deleteById(id);
    }
    
    public Educacion buscarEducacion(int id){
        Educacion edu = repoEdu.findById(id).orElse(null);
        return edu;
    }
    
    public void editarEducacion(Educacion edu) {
        repoEdu.save(edu);
    }
    
}
