package com.cafe24.gg.Controller.Api;

import java.util.List;
import java.util.Map;

import com.cafe24.gg.Service.AdminService;
import com.cafe24.gg.Vo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
}