package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Banner;
import com.portfolio.backend.service.SBanner;
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
@RequestMapping("banner") //localhost:8080/banner
@CrossOrigin(origins = "http://localhost:4200/#/home") //el de mi portfolio index frontend
public class CBanner {
    
    @Autowired
    SBanner banServ;
    
    @GetMapping ("/lista")
    @ResponseBody
    public List <Banner> verBanner(){
        return banServ.verBanner();
    }
    
    @GetMapping ("/ver/(id)")
    @ResponseBody
    public Banner verBanner(@PathVariable int id){
        return banServ.buscarBanner(id);
    }
    
    @PostMapping ("/crear")
    public String agregarBanner (@RequestBody Banner ban){
        banServ.crearBanner(ban);
        return "El banner fue creado exitosamente";
    }
    
    @DeleteMapping ("/borrar/(id)")
    public String eliminarBanner(@PathVariable int id){
        banServ.borrarBanner(id);
        return "El banner fue borrado correctamente";
    }
    
    //otra forma de editar banner
    @PutMapping("/editar")
    public String updateBanner(@RequestBody Banner ban){
        banServ.editarBanner(ban);
        return "el banner se edito exitosamente";
    }
    
}
