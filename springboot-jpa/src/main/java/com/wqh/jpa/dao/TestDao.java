package com.wqh.jpa.dao;

import com.wqh.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

}