package com.soshiant.service.users;


import com.soshiant.model.user.UserInfo;
import com.soshiant.repository.users.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    //==================================================================================================================
    public boolean login(String userName, String password) {

        UserInfo userInfo = userDao.getUserInfo(userName);
        boolean loginResult = false;
        if(userInfo != null){
           loginResult = userInfo.getPassword().equals(password);
        }
        return  loginResult;
    }
    //======================================================================================================================
    public boolean addNewUser(UserInfo userInfo) {

        userDao.addNewUser(userInfo);
        return true;
    }

    //======================================================================================================================
    public List<UserInfo> getUsersList(){

        List<UserInfo> userInfoList = userDao.getAllUsers();
        return userInfoList;
    }
}

