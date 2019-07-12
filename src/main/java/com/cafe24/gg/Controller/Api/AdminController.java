package com.cafe24.gg.Controller.Api;

import java.util.List;
import java.util.Optional;

import com.cafe24.gg.DTO.JSONResult;
import com.cafe24.gg.Service.AdminService;
import com.cafe24.gg.Vo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("adminAPIController")
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/product")
    public JSONResult 상품_조회(@RequestParam(value="id") String id) {
        Optional<Product> item = adminService.getProductItem(Long.parseLong(id));

        return JSONResult.success(item);
    }

    @GetMapping(value = "/product/list")
    public JSONResult 상품_리스트() {
        List<Product> list = adminService.getProductList();

        return JSONResult.success(list);
    }

    @PostMapping(value = "/product")
    public JSONResult 상품_추가(@RequestBody Product newItem) {

        Product adddedItem = adminService.addItem(newItem);

        return JSONResult.success(adddedItem);
    }

    @PutMapping(value="/product")
    public JSONResult 상품_수정(@RequestBody Product paramItem){

        Optional<Product> editedItem = adminService.editItem(paramItem);

        return JSONResult.success(editedItem);
    }

    @DeleteMapping(value="/product")
    public JSONResult 상품_삭제(@RequestBody Long paramNo){

        Optional<Product> deletedItem = adminService.delItem(paramNo);

        return JSONResult.result(false, deletedItem);
    }
}