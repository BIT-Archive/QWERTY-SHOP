package com.cafe24.gg.Repository;

import com.cafe24.gg.Vo.ProductDetail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailDAO extends JpaRepository<ProductDetail, Integer> {
    
}