package com.cafe24.gg.Service;

import java.util.List;

import com.cafe24.gg.Repository.UserDAO;
import com.cafe24.gg.Vo.Cart;
import com.cafe24.gg.Vo.Order;
import com.cafe24.gg.Vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

	public User Login(User auth) {
		return null;
	}

	public User SignUp(User newUser) {
		return null;
	}

	public User Modify(User paramUser) {
		return null;
	}

	public User DELETE(Long paramNo) {
		return null;
	}

	public Cart getCart(User paramUser) {
		return null;
	}

	public List<Order> getOrderList(User paramUser) {
		return null;
	}


    

}