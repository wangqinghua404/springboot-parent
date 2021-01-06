package com.wqh.server.service;

import com.wqh.api.TestService;
import com.wqh.entity.User;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestServiceImpl
 * @Author wqh
 * @Date 2021/1/6 9:42
 * @Description TODO
 * @Version 1.0
 */
@Service(version = "1.0.0", interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {
    @Override
    public List<User> selectAll() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("Tom");
        list.add(user);
        return list;
    }
}
