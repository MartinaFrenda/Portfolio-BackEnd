package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.service.SEducacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("educacion") //localhost:8080/persona
@CrossOrigin(origins = "http://localhost:4200/#/home") //el de mi portfolio index frontend
public class CEducacion {
    
    @Autowired
    SEducacion eduServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List <Educacion> verEducacion(){
        return eduServ.verEducacion();
    }
    
    @GetMapping ("/ver/(id)")
    @ResponseBody
    public Educacion verEducacion(@PathVariable int id){
        return eduServ.buscarEducacion(id);
    }
    
    @GetMapping ("/crear")
    public String agregarEducacion (@RequestBody Educacion edu){
        eduServ.crearEducacion(edu);
        return "La Educacion fue creada exitosamente";
    }
    
    @DeleteMapping ("/borrar/(id)")
    public String eliminarEducacion(@PathVariable int id){
        eduServ.borrarEducacion(id);
        return "La Educacion fue borrada correctamente";
    }
    
    //otra forma de editar Educacion
    @PutMapping("/editar")
    public void updateEducacion(@RequestBody Educacion edu){
        eduServ.editarEducacion(edu);
    }
    
}
