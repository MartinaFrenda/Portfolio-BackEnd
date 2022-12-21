package com.portfolio.backend.service;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.repository.RPersona;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {
    
    @Autowired
    public RPersona persoRepo;
    
    public List<Persona> verPersonas(){
        List<Persona> listaPersonas= persoRepo.findAll();
        return listaPersonas;
    }
    
    public void crearPersona(Persona perso){
        persoRepo.save(perso);
    }
    
    public void borrarPersona(int id){
        persoRepo.deleteById(id);
    }
    
    public Persona buscarPersona(int id){
        Persona perso = persoRepo.findById(id).orElse(null);
        return perso;
    }
    
    public void editarPersona(Persona perso) {
        persoRepo.save(perso);
    }
    
}
