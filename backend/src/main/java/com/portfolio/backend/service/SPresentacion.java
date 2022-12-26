package com.portfolio.backend.service;

import com.portfolio.backend.entity.Presentacion;
import com.portfolio.backend.repository.RPresentacion;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPresentacion {
    
    @Autowired
    public RPresentacion repoPres;
    
    public List<Presentacion> verPresentacion(){
        List<Presentacion> listaPresentacion= repoPres.findAll();
        return listaPresentacion;
    }
    
    public void crearPresentacion(Presentacion pres){
        repoPres.save(pres);
    }
    
    public void borrarPresentacion(int id){
        repoPres.deleteById(id);
    }
    
    public Presentacion buscarPresentacion(int id){
        Presentacion pres = repoPres.findById(id).orElse(null);
        return pres;
    }
    
    public void editarPresentacion(Presentacion pres) {
        repoPres.save(pres);
    }
}
