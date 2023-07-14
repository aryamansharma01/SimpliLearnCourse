package com.prolim.Phase3Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductDatabase extends JpaRepository<Product, Integer>{

}
