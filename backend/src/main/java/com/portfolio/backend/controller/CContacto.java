package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Contacto;
import com.portfolio.backend.service.SContacto;
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
@RequestMapping("contacto") //localhost:8080/persona
@CrossOrigin(origins = "http://localhost:4200/#/home") //el de mi portfolio index frontend
public class CContacto {
        
    @Autowired
    SContacto contServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List <Contacto> verContacto(){
        return contServ.verContacto();
    }
    
    @GetMapping ("/ver/(id)")
    @ResponseBody
    public Contacto verContacto(@PathVariable int id){
        return contServ.buscarContacto(id);
    }
    
    @GetMapping ("/crear")
    public String agregarContacto (@RequestBody Contacto cont){
        contServ.crearContacto(cont);
        return "El Contacto fue creado exitosamente";
    }
    
    @DeleteMapping ("/borrar/(id)")
    public String eliminarContacto(@PathVariable int id){
        contServ.borrarContacto(id);
        return "El contacto fue borrado correctamente";
    }
    
    //otra forma de editar Contacto
    @PutMapping("/editar")
    public void updateContacto(@RequestBody Contacto cont){
        contServ.editarContacto(cont);
    }
    
}
