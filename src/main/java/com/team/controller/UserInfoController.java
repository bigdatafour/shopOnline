package com.team.controller;

import com.team.pojo.Goods;
import com.team.pojo.UserInfo;
import com.team.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/shopOnline")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired HttpServletRequest request;

    /**
     * 这里是进行注册的方法，前台传过来一个JSON类型的字符串，然后判断此人存不存在，不存在的话即可注册
     * @param userInfo
     * @return
     */

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

    /**
     * 登录模块，前端传来JSON类型的字符串，后端判断该用户的用户名和密码之后，再进行登录的操作
     * @param userInfo
     * @return
     */

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
            System.out.println("session-----------"+session.getAttribute("userName"));
        }
        return str;
    }

    /**
     * 前端点击商品品类，后端进行用户最喜欢的商品品类的统计
     * @param goods
     */

    @RequestMapping(value = "goodsClick", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public void getGoods(@RequestBody Goods goods){
        System.out.println(goods.getGoodsName());
    }

    /**
     * 用户退出的时候，进入该SignOut()方法，该方法修改用户的登录状态为离线，并清除session对象中的所有信息
     * @param userInfo
     * @return
     */

    @RequestMapping(value = "signOut", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String get(@RequestBody UserInfo userInfo, HttpSession session){
        userInfo.setUser_name((String)session.getAttribute("userName"));
        String user_name = userInfo.getUser_name();
        userInfoService.signOutStatusChange(user_name);
        System.out.println("用户"+user_name+"已退出");
        session.removeAttribute("userName");
        return user_name;
    }

}
