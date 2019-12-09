package com.team.controller;

import com.team.pojo.UserInfo;
import com.team.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
@RequestMapping("/shopOnline")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;


    @CrossOrigin(origins = "*")
    @RequestMapping(value="registerUser", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public Boolean addUser (@RequestBody UserInfo userInfo){
        Boolean flag = false;
        System.out.println(userInfo.getUser_name());
        if(userInfoService.getName(userInfo.getUser_name()) == false){   //如果数据库里查无此人，那么此人可以注册
            userInfoService.addUser(userInfo);
            flag = true;
        }
        return flag;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "userLogin", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String userLogin (@RequestBody UserInfo userInfo, HttpSession session){
        String str = "";
        System.out.println(userInfo.getUser_name()+" "+userInfo.getUser_password());
        if(userInfoService.getName(userInfo.getUser_name()) == false){
            str = "userNone";
        }else if(userInfoService.getPwd(userInfo) == false){
            str = "pwdError";
        }else{
            str = "success";
            userInfoService.updateStatus(userInfo.getUser_name());
            session.setAttribute("userName",userInfo.getUser_name());
        }
        return str;
    }
}
