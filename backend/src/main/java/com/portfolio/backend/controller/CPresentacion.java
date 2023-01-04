package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Presentacion;
import com.portfolio.backend.service.SPresentacion;
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
@RequestMapping("presentacion") //localhost:8080/presentacion
@CrossOrigin(origins = "http://localhost:4200") //el de mi portfolio index frontend
public class CPresentacion {
    
    @Autowired
    SPresentacion presServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List <Presentacion> verPresentacion(){
        return presServ.verPresentacion();
    }
    
    @GetMapping ("/ver/(id)")
    @ResponseBody
    public Presentacion verPresentacion(@PathVariable int id){
        return presServ.buscarPresentacion(id);
    }
    
    @PostMapping ("/crear")
    public String agregarPresentacion (@RequestBody Presentacion pres){
        presServ.crearPresentacion(pres);
        return "La Presentacion fue creada exitosamente";
    }
    
    @DeleteMapping ("/borrar/(id)")
    public String eliminarPresentacion(@PathVariable int id){
        presServ.borrarPresentacion(id);
        return "La Presentacion fue borrada correctamente";
    }
    
    //otra forma de editar Presentacion
    @PutMapping("/editar")
    public String updatePresentacion(@RequestBody Presentacion pres){
        presServ.editarPresentacion(pres);
        return "La Presentacion fue editada exitosamente";
    }
    
}
