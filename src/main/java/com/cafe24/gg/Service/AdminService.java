package com.cafe24.gg.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cafe24.gg.Repository.ProductDAO;
import com.cafe24.gg.Vo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	public ProductDAO productDAO;

	public List<Product> getProductList() {
		return productDAO.findAll();
	}

	public Product addItem(Product newItem) {
		productDAO.save(newItem);
		return  newItem;
	}

	// public Optional<Product> getProductItem(Long id) {

	// 	Optional<Product> targetItem = productDAO.findById(id);

	// 	return targetItem;
	// }

	public Product editItem(Product paramitem) {
		
		Optional<Product> targetItem = productDAO.findById(paramitem.getProduct_id());
		targetItem.get().setTitle("수정된상품타이틀");
		
		productDAO.save(targetItem.get());

		return targetItem.get();
	}

}