package com.portfolio.backend.repository;

import com.portfolio.backend.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RContacto extends JpaRepository <Contacto, Integer>{
    
}
