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
    public Boolean get(String userName) {
        Boolean flag = false;
        if(userInfoMapper.get(userName) != null){
            flag = true;    //当flag=true的时候,代表数据库中已经有这个用户名
        }
        return flag;
    }

    @Override
    public void add(UserInfo userInfo) {
        userInfoMapper.add(userInfo);
    }

    @Override
    public List<UserInfo> list() {
        return userInfoMapper.list();
    }

}
