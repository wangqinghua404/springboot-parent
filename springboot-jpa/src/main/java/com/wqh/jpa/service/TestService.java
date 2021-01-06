package com.wqh.jpa.service;


import com.wqh.jpa.entity.User;
import org.springframework.http.ResponseEntity;

public interface TestService {

    ResponseEntity selectAll(User user);

}
