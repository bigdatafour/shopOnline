package com.team.mapper;

import com.team.pojo.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserInfoMapper {
    public  UserInfo get(String userName);
    public void add (UserInfo userInfo);
    public List<UserInfo> list();
}
