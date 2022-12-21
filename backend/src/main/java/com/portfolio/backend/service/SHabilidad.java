package com.portfolio.backend.service;

import com.portfolio.backend.entity.Habilidad;
import com.portfolio.backend.repository.RHabilidad;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidad {
    
    @Autowired
    public RHabilidad habiRepo;
    
    public List<Habilidad> verHabilidades(){
        List<Habilidad> ListaHabilidades= habiRepo.findAll();
        return ListaHabilidades;
    }
    
    public void crearHabilidad(Habilidad habi){
        habiRepo.save(habi);
    }
    
    public void borrarHabilidad(int id){
        habiRepo.deleteById(id);
    }
    
    public Habilidad buscarHabilidad(int id){
        Habilidad habi = habiRepo.findById(id).orElse(null);
        return habi;
    }
    
    public void editarHabilidad(Habilidad habi) {
        habiRepo.save(habi);
    }
    
}
