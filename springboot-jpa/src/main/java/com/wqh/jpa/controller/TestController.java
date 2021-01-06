package com.wqh.jpa.controller;

import com.wqh.jpa.entity.User;
import com.wqh.jpa.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName TestController
 * @Author wqh
 * @Date 2021/1/5 9:56
 * @Description TODO
 * @Version 1.0
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @PostMapping(value = "/select")  //添加一个user
    public ResponseEntity select(@RequestBody User user) {
        return testService.selectAll(user);
    }

}
