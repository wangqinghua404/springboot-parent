package com.wqh.jpa.service.impl;

import com.google.gson.Gson;
import com.wqh.jpa.dao.TestDao;
import com.wqh.jpa.entity.User;
import com.wqh.jpa.service.TestService;
import com.wqh.jpa.util.CommonUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestServiceImpl
 * @Author wqh
 * @Date 2021/1/5 14:22
 * @Description TODO
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    private static final Gson gson = new Gson();

    @Resource
    private TestDao testDao;

    @Override
    public ResponseEntity selectAll(User user) {
        try {

            Integer page = 1;
            Integer size = 3;
            Pageable pageable = PageRequest.of(page - 1, size);
            // 规格定义
            Specification<User> specification = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
//                if (!StringUtils.isEmpty(user.getName())) { //添加断言
////                        Predicate likeNickName = criteriaBuilder.like(root.get("name").as(String.class), user.getName() + "%");
//                    Predicate predicate = criteriaBuilder.equal(root.get("name"), user.getName());
//                    predicates.add(predicate);
//                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
            Page<User> pages = testDao.findAll(specification, pageable);
            ResponseEntity responseEntity = new ResponseEntity(page,HttpStatus.OK);
            String map = gson.toJson(responseEntity);
            return new ResponseEntity<>(CommonUtil.getResponse(pages), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
