package com.cafe24.gg.Repository;

import com.cafe24.gg.Vo.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductDAO extends JpaRepository<Product, Long>{

}

