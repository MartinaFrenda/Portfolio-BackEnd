package com.portfolio.backend.service;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    
    @Autowired
    public RExperiencia repoExp;
    
    public List<Experiencia> verExperiencia(){
        List<Experiencia> listaExperiencias= repoExp.findAll();
        return listaExperiencias;
    }
    
    public void crearExperiencia(Experiencia exp){
        repoExp.save(exp);
    }
    
    public void borrarExperiencia(int id){
        repoExp.deleteById(id);
    }
    
    public Experiencia buscarExperiencia(int id){
        Experiencia exp = repoExp.findById(id).orElse(null);
        return exp;
    }
    
    public void editarExperiencia(Experiencia exp) {
        repoExp.save(exp);
    }
}
