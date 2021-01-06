package com.wqh.web.controller;

import com.wqh.api.TestService;
import com.wqh.entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TestController
 * @Author wqh
 * @Date 2021/1/6 10:04
 * @Description TODO
 * @Version 1.0
 */
@RestController
public class TestController {

    @Reference(version = "1.0.0")
    private TestService testService;

    @RequestMapping("/test")
    public String ins() {
        List<User> list = testService.selectAll();
        return list.toString();
    }
}
