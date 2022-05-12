package com.example.demo.Service;
import com.example.demo.Entity.UserBean;
import com.example.demo.Mapper.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;

    public UserBean LoginIn(String userName, String password) {
        return userMapper.getInfo(userName, password);
    }

    public void Insert(String userName, String password) {
        userMapper.saveInfo(userName, password);
    }
}