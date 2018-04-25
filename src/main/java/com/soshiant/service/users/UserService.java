package com.soshiant.service.users;


import com.soshiant.model.user.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public boolean login(String userName, String password);

    public boolean addNewUser(UserInfo userInfo);

    public List<UserInfo> getUsersList();

}
