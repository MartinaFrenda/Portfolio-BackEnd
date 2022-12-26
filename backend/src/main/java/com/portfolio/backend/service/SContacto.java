package com.portfolio.backend.service;

import com.portfolio.backend.entity.Contacto;
import com.portfolio.backend.repository.RContacto;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SContacto {
    
    @Autowired
    public RContacto repoCont;
    
    public List<Contacto> verContacto(){
        List<Contacto> listaContactos= repoCont.findAll();
        return listaContactos;
    }
    
    public void crearContacto(Contacto cont){
        repoCont.save(cont);
    }
    
    public void borrarContacto(int id){
        repoCont.deleteById(id);
    }
    
    public Contacto buscarContacto(int id){
        Contacto cont = repoCont.findById(id).orElse(null);
        return cont;
    }
    
    public void editarContacto(Contacto cont) {
        repoCont.save(cont);
    }
}
