package com.soshiant.repository.users;


import com.soshiant.model.user.UserInfo;

import java.util.List;

public interface UserDao {

    public UserInfo getUserInfo(String userName);

    public List<UserInfo> getAllUsers();

    public boolean addNewUser(UserInfo userInfo);
}
