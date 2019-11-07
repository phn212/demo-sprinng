package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("/query")
    public String query(){

        System.out.println(testMapper.queryUser().toString());

        return "login";
    }

    @RequestMapping("/register")
    @ResponseBody
    public List login(@RequestParam String name, @RequestParam String password,@RequestParam String sex){
        System.out.println(name+"==============="+password);
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());
        user.setSex(Integer.valueOf(sex));
        user.setBz("1");
        testMapper.addUser(user);
        List list=testMapper.queryUser();

        return list;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public List delete(@RequestParam String name, @RequestParam String password ){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        testMapper.delete(user);
        List list=testMapper.queryUser();
        return list;
    }
}
