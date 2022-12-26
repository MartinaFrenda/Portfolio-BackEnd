package com.portfolio.backend.repository;

import com.portfolio.backend.entity.Presentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPresentacion extends JpaRepository <Presentacion, Integer>{
    
}
