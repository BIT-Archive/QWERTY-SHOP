package com.cafe24.gg.Controller.Api;

import java.util.List;

import com.cafe24.gg.DTO.JSONResult;
import com.cafe24.gg.Service.UserService;
import com.cafe24.gg.Vo.Cart;
import com.cafe24.gg.Vo.Order;
import com.cafe24.gg.Vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public JSONResult 회원_로그인(@RequestBody User auth){
        User authUser = userService.Login(auth);
        return JSONResult.success(authUser);
    }

    @PostMapping(value = "/signup")
    public JSONResult 회원_가입(@RequestBody User newUser){
        User user = userService.SignUp(newUser);
        return JSONResult.success(user);
    }

    @PutMapping(value = "")
    public JSONResult 회원_정보_수정(@RequestBody User paramUser){
        User AfterUser = userService.Modify(paramUser);
        return JSONResult.success(AfterUser);
    }

    @DeleteMapping(value = "")
    public JSONResult 회원_탈퇴(@RequestBody Long paramNo){
        User tempUser = userService.DELETE(paramNo);
        return JSONResult.success(tempUser);
    }

    @PostMapping(value="/cart")
    public JSONResult 회원_장바구니_조회(@RequestBody User paramUser){
        
        Cart cart = userService.getCart(paramUser);
        
        return JSONResult.success(cart);
    }

    @PostMapping(value="/orderList")
    public JSONResult 회원_주문내역_조회(@RequestBody User paramUser){
        
        List<Order> orders = userService.getOrderList(paramUser);
        
        return JSONResult.success(orders);
    }

    @PostMapping(value="/validate")
    public JSONResult 유효성_검증(@RequestBody User paramUser){

        return JSONResult.success(new Object());
    }

}