package com.spring.springboot.controller;

import com.spring.springboot.common.Result;
import com.spring.springboot.entity.*;
import com.spring.springboot.mapper.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import redis.clients.jedis.Jedis;
//定义是返回json的controller
@RestController
//定义统一的路由
@RequestMapping("/user")
public class UserController {
    //引入UserMaooer
    @Resource
    UserMapper userMapper;

    Jedis jedis = new Jedis("localhost");

    @RequestMapping("/addUser")
    @ResponseBody
    public Result addUser(@RequestBody User user) {
        System.out.println("try adduser" + user);
        if (userMapper.findByName(user.getName()) != null) {
            return new Result(500, "用户已存在", null);
        }
  
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        System.out.println(newUser);

        userMapper.insert(newUser);
//        newUser = userMapper.findByName(newUser.getName());

//        Customer newCustomer = new Customer();
//        newCustomer.setNum(newUser.getUid() + "");
//        newCustomer.setName(newUser.getName());
//
//        customerMapper.insert(newCustomer);

        return new Result(200, "注册成功", null);
    }

    @RequestMapping("/alterPassword")
    @ResponseBody
    public Result alterPassword(@RequestBody User user) {
        System.out.println("alter password:\n" + user);
        if (userMapper.findByName(user.getName()) == null) {
            return new Result(500, "用户不存在", null);
        }

//        User newUser = new User();
//        newUser.setName(user.getName());
//        newUser.setPassword(user.getPassword());

        System.out.println(user);
        userMapper.changePw(user.getPassword(), user.getName());

        return new Result(200, "密码更改成功", null);
    }

    @RequestMapping("/info")
    @ResponseBody
    public Result getInfo() {
        System.out.println("request for info");
        users users = new users();
        users.setName("testname");
//        users.setName(user.getName());
        return new Result(200, "成功请求用户信息", users);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result logout() {
        System.out.println("request for logout");
        return new Result(200, "登出成功", null);
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
//        System.out.println(user.getName());
//        System.out.println(user.getPassword());
//        System.out.println(user);
        User findByName = userMapper.findByName(user.getName());
//        System.out.println("Found User:" + findByName);

        users users = new users();
        users.setName(user.getName());
//        System.out.println(users);
//        System.out.println(findByName.getPassword());
//        System.out.println(user.getPassword());
        if (findByName == null) {
            return new Result(500, "用户已存在", null);
        }
        if (!findByName.getPassword().equals(user.getPassword())) {
            return new Result(500, "密码错误！", null);
        }
        if (findByName.getIsManager() == 1) {
            return new Result(200, "登陆成功", users);
        }
        System.out.println(users);
        return new Result(200, "登陆成功", users);
    }


    @RequestMapping("/about")
    @ResponseBody
    public Result About(@RequestBody User user) {
        System.out.println(user);

        return new Result(200, "success", user);
    }
}

//    public Result About(){
//
//        return new Result(200,"success","YES!");
//    }

    //  定义post接口
//    @PostMapping
//    //  新增 RequestBody注解把前台传来的数据转换成java对象实体
//    public Result<?> save(@RequestBody User user)
//    {
//        //使用userMapper的insert方法新增user对象
//        userMapper.insert(user);
//        return Result.success();
//    }
