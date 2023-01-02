package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Habilidad;
import com.portfolio.backend.service.SHabilidad;
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
@RequestMapping("habilidad") //localhost:8080/persona
@CrossOrigin(origins = "http://localhost:4200/#/home") //el de mi portfolio index frontend
public class CHabilidad {
    
    @Autowired
    SHabilidad habiServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List <Habilidad> verHabilidades(){
        return habiServ.verHabilidades();
    }
    
    @GetMapping ("/ver/(id)")
    @ResponseBody
    public Habilidad verHabilidades(@PathVariable int id){
        return habiServ.buscarHabilidad(id);
    }
    
    @PostMapping ("/crear")
    public String agregarHabilidad (@RequestBody Habilidad habi){
        habiServ.crearHabilidad(habi);
        return "La habilidad fue creada exitosamente";
    }
    
    @DeleteMapping ("/borrar/(id)")
    public String eliminarHabilidad(@PathVariable int id){
        habiServ.borrarHabilidad(id);
        return "La habilidad fue borrada correctamente";
    }
    
    //otra forma de editar persona
    @PutMapping("/editar")
    public String updateHabilidad(@RequestBody Habilidad habi){
        habiServ.editarHabilidad(habi);
        return "La habilidad fue editada exitosamente";
    }
    
}
