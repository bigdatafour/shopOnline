package com.team.service;


import com.team.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    Boolean get(String userName);
    void add(UserInfo userInfo);

    List<UserInfo> list();
}
