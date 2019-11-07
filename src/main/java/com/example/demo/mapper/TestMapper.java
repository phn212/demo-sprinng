package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Mapper
@Repository
@EnableTransactionManagement(proxyTargetClass = true)
public interface TestMapper {
    List  queryUser();
    void addUser(User user);
    void delete(User user);
}
