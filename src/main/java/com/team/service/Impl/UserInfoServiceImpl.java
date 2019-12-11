package com.team.service.Impl;

import com.team.mapper.UserInfoMapper;
import com.team.pojo.UserInfo;
import com.team.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public Boolean getName(String userName) {
        Boolean flag = false;
        if(userInfoMapper.getName(userName) != null){
            flag = true;    //当flag=true的时候,代表数据库中已经有这个用户名
        }
        return flag;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.addUser(userInfo);
    }

    @Override
    public Boolean getPwd(UserInfo userInfo) {
        Boolean flag = false;
        if(userInfo.getUser_password().equals(userInfoMapper.getPwd(userInfo.getUser_name()).getUser_password())){
            flag = true;    //当flag=true的时候，代表这个用户从前端输入的密码与数据库里的密码相匹配，登录成功
        }
        return flag;
    }

    @Override
    public List<UserInfo> list() {
        return userInfoMapper.list();
    }

    @Override
    public void updateStatus(String userName) {
        userInfoMapper.updateStatus(userName);
    }

    @Override
    public void signOutStatusChange(String user_name) {
        userInfoMapper.signOutStatusChange(user_name);
    }

}
