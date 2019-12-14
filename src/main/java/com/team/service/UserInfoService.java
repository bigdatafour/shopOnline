package com.team.service;


import com.team.pojo.Advertisement;
import com.team.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    Boolean getName(String userName);
    void addUser(UserInfo userInfo);
    Boolean getPwd(UserInfo userInfo);


    void updateStatus(String userName);

    void signOutStatusChange(String user_name);

    void adClick(Advertisement advertisement);
}
