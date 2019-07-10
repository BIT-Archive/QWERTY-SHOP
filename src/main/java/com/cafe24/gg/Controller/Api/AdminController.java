package com.cafe24.gg.Controller.Api;

import java.util.List;


import com.cafe24.gg.DTO.JSONResult;
import com.cafe24.gg.Service.AdminService;
import com.cafe24.gg.Vo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

@RestController("adminAPIController")
@RequestMapping("/api/admin")
public class AdminController{

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/product/list", method=RequestMethod.GET)
    public List<Product> getProductList(){
        List<Product> product = adminService.getProductList();

        return product;
    }

    @RequestMapping(value="/product/add", method=RequestMethod.POST)
    public JSONResult addProduct(Product newProdcut){

        boolean result = adminService.addItem();
        JSONResult json = new JSONResult(result, "inserting success", newProdcut);

        return json;
    }
}