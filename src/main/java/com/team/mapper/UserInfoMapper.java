package com.team.mapper;

import com.team.pojo.Advertisement;
import com.team.pojo.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserInfoMapper {
    /**
     * 验证用户名是否存在
     * @param userName
     * @return
     */
    public  UserInfo getName(String userName);

    /**
     * 注册方法，把该用户加入数据库
     * @param userInfo
     */
    public void addUser (UserInfo userInfo);

    /**
     * 登录时候调用该方法，验证用户密码是否正确
     * @param userName
     * @return
     */
    public UserInfo getPwd(String userName);

    /**
     * 登录的时候改变用户状态由1变为0，0表示在线状态
     * @param userName
     */
    public void updateStatus(String userName);

    /**
     * 退出的时候改变用户的状态，用户状态由 0 改为 1, 1 表示离线状态
     * @param userName
     */
    public void signOutStatusChange(String userName);


    /**
     * 用户点击广告以后，调用此方法，在数据库里添加一条属于某区域的广告点击信息
     * @param advertisement
     */
    void adClick(Advertisement advertisement);
}
