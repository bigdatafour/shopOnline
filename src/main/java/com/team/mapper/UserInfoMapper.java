package com.team.mapper;

import com.team.pojo.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserInfoMapper {
    public  UserInfo getName(String userName);
    public void addUser (UserInfo userInfo);
    public UserInfo getPwd(String userName);
    public void updateStatus(String userName);

    public List<UserInfo> list();
}
