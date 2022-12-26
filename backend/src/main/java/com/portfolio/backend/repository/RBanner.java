package com.portfolio.backend.repository;

import com.portfolio.backend.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RBanner extends JpaRepository <Banner, Integer>{
    
}
