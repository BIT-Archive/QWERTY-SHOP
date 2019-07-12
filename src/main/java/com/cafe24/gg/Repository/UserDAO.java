package com.cafe24.gg.Repository;

import com.cafe24.gg.Vo.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, String> {

}

