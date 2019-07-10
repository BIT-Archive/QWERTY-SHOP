package com.cafe24.gg.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cafe24.gg.Repository.ProductDAO;
import com.cafe24.gg.Vo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService{

    @Autowired
    public ProductDAO productDAO;

	public List<Product> getProductList() {
		return productDAO.findAll();
    }

	public boolean addItem() {
		return true;
	}

}