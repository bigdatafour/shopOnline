package com.team.controller;

import com.team.pojo.UserInfo;
import com.team.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/shopOnline")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;


    @CrossOrigin(origins = "*")
    @RequestMapping(value="registerUser", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public Boolean add (@RequestBody UserInfo userInfo){
        Boolean flag = false;
        System.out.println(userInfo.getUser_name());
        if(userInfoService.get(userInfo.getUser_name()) == false){   //如果数据库里查无此人，那么此人可以注册
            userInfoService.add(userInfo);
            flag = true;
        }
        return flag;
    }
}
