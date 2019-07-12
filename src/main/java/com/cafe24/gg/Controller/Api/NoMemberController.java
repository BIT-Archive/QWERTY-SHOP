package com.cafe24.gg.Controller.Api;

import java.util.List;

import com.cafe24.gg.DTO.JSONResult;
import com.cafe24.gg.Service.NoMemberService;
import com.cafe24.gg.Vo.Cart;
import com.cafe24.gg.Vo.NoMember;
import com.cafe24.gg.Vo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/nomember")
public class NoMemberController {

    @Autowired
    private NoMemberService noSerivce;

    @PostMapping(value="")
    public JSONResult 비회원_로그인(@RequestBody NoMember noMember){
        
        NoMember authNoMember = noSerivce.Login(noMember);
        
        return JSONResult.success(authNoMember);
    }

    @PostMapping(value="/signup")
    public JSONResult 비회원_인증(@RequestBody NoMember noMember){
        
        NoMember authNoMember = noSerivce.Auth(noMember);
        
        return JSONResult.success(authNoMember);
    }

    @GetMapping(value="/cart")
    public JSONResult 비회원_장바구니_조회(@RequestBody NoMember noMember){
        
        Cart cart = noSerivce.getCart(noMember);
        
        return JSONResult.success(cart);
    }

    @GetMapping(value="/orderList")
    public JSONResult 비회원_주문내역_조회(@RequestBody NoMember noMember){
        
        List<Order> orders = noSerivce.getOrderList(noMember);
        
        return JSONResult.success(orders);
    }



}