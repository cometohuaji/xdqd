package com.example.demo.Controller;

import com.example.demo.Entity.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.Service.UserService;

import javax.annotation.Resource;

@Slf4j
@Controller
public class LoginController {

    //将Service注入Web层
    @Resource
    UserService userService;

    @Controller
    public class HelloController {
        @RequestMapping("/")
        public String hello(){
            return "login";
        }
    }

    //实现登录
    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String userName,String password){
        UserBean userBean = userService.LoginIn(userName, password);
        log.info("userName:{}",userName);
        log.info("password:{}",password);
        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String signUp(){
        return "register";
    }

    //实现注册功能
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String signUp(String userName,String password){
        System.out.println(userName + " " + password);
        userService.Insert(userName, password);
        return "success";
    }
}
