package com.portfolio.backend.service;

import com.portfolio.backend.entity.Banner;
import com.portfolio.backend.repository.RBanner;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SBanner {
    
    @Autowired
    public RBanner repoBanner;
    
    public List<Banner> verBanner(){
        List<Banner> listaBanner= repoBanner.findAll();
        return listaBanner;
    }
    
    public void crearBanner(Banner ban){
        repoBanner.save(ban);
    }
    
    public void borrarBanner(int id){
        repoBanner.deleteById(id);
    }
    
    public Banner buscarBanner(int id){
        Banner ban = repoBanner.findById(id).orElse(null);
        return ban;
    }
    
    public void editarBanner(Banner ban){
        repoBanner.save(ban);
    }
    
}
