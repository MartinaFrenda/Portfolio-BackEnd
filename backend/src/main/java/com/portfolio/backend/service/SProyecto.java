package com.portfolio.backend.service;

import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.repository.RProyecto;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    
    @Autowired
    public RProyecto repoProy;
    
    public List<Proyecto> verProyecto(){
        List<Proyecto> listaProyecto= repoProy.findAll();
        return listaProyecto;
    }
    
    public void crearProyecto(Proyecto proy){
        repoProy.save(proy);
    }
    
    public void borrarProyecto(int id){
        repoProy.deleteById(id);
    }
    
    public Proyecto buscarProyecto(int id){
        Proyecto proy = repoProy.findById(id).orElse(null);
        return proy;
    }
    
    public void editarProyecto(Proyecto proy) {
        repoProy.save(proy);
    }
}
