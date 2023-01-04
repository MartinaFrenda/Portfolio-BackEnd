package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Proyecto;
import com.portfolio.backend.service.SProyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyecto") //localhost:8080/proyecto
@CrossOrigin(origins = "http://localhost:4200") //el de mi portfolio index frontend
public class CProyecto {
    
    @Autowired
    SProyecto proyServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List <Proyecto> verProyecto(){
        return proyServ.verProyecto();
    }
    
    @GetMapping ("/ver/(id)")
    @ResponseBody
    public Proyecto verProyecto(@PathVariable int id){
        return proyServ.buscarProyecto(id);
    }
    
    @PostMapping ("/crear")
    public String agregarProyecto (@RequestBody Proyecto proy){
        proyServ.crearProyecto(proy);
        return "El Proyecto fue creado exitosamente";
    }
    
    @DeleteMapping ("/borrar/(id)")
    public String eliminarProyecto(@PathVariable int id){
        proyServ.borrarProyecto(id);
        return "El Persona fue borrado correctamente";
    }
    
    //otra forma de editar proyecto
    @PutMapping("/editar")
    public String updateProyecto(@RequestBody Proyecto proy){
        proyServ.editarProyecto(proy);
        return "El Proyecto fue editada exitosamente";
    }
    
}
