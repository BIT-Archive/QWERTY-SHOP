package com.cafe24.gg.Controller.Api;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.cafe24.gg.DTO.JSONResult;
import com.cafe24.gg.Service.AdminService;
import com.cafe24.gg.Vo.Product;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/product/read", method = RequestMethod.GET)
    public JSONResult getProductItem(@RequestParam(value="id") String id) {
        Optional<Product> item = adminService.getProductItem(Long.parseLong(id));

        return JSONResult.success(item);
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public JSONResult getProductList() {
        List<Product> list = adminService.getProductList();

        return JSONResult.success(list);
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public JSONResult addProduct(@RequestBody Product newItem) {

        Product adddedItem = adminService.addItem(newItem);

        return JSONResult.success(adddedItem);
    }

    @RequestMapping(value="/product/edit", method=RequestMethod.POST)
    public JSONResult editProduct(@RequestBody Product paramItem){

        Optional<Product> editedItem = adminService.editItem(paramItem);

        return JSONResult.success(editedItem);
    }

    @RequestMapping(value="/product/del", method=RequestMethod.DELETE)
    public JSONResult deleteItem(@RequestBody Long paramNo){

        Optional<Product> deletedItem = adminService.delItem(paramNo);

        return JSONResult.success(deletedItem);
    }
}