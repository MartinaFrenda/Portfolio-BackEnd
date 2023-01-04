package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.service.SExperiencia;
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
@RequestMapping("experiencia") //localhost:8080/experiencia
@CrossOrigin(origins = "http://localhost:4200") //el de mi portfolio index frontend
public class CExperiencia {
    
    @Autowired
    SExperiencia expeServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List <Experiencia> verExperiencia(){
        return expeServ.verExperiencia();
    }
    
    @GetMapping ("/ver/(id)")
    @ResponseBody
    public Experiencia verExperiencia(@PathVariable int id){
        return expeServ.buscarExperiencia(id);
    }
    
    @PostMapping ("/crear")
    public String agregarExperiencia (@RequestBody Experiencia exp){
        expeServ.crearExperiencia(exp);
        return "La Experiencia fue creada exitosamente";
    }
    
    @DeleteMapping ("/borrar/(id)")
    public String eliminarExperiencia(@PathVariable int id){
        expeServ.borrarExperiencia(id);
        return "La Experiencia fue borrada correctamente";
    }
    
    //otra forma de editar Experiencia
    @PutMapping("/editar")
    public String updateExperiencia(@RequestBody Experiencia exp){
        expeServ.editarExperiencia(exp);
        return "La Experiencia fue editada exitosamente";
    }
    
}
