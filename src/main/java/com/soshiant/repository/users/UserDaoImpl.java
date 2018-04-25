package com.soshiant.repository.users;


import com.soshiant.model.user.UserInfo;
import com.soshiant.repository.users.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //==================================================================================================================
    public UserInfo getUserInfo(String userName) {

        String sqlText = "select * from UserInfo where username = ?";

        UserInfo userInfo = null;
        try{
            userInfo = jdbcTemplate.queryForObject(sqlText,new Object[]{userName},new BeanPropertyRowMapper<>(UserInfo.class));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return userInfo;
    }
    //==================================================================================================================
    public List<UserInfo> getAllUsersByName(String userFirstName) {

        String sqlText = "select * from UserInfo where userFirstName = ?";

        RowMapper userInfoRowMapper = new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(rs.getInt("userId"));
                userInfo.setUserFirstName(rs.getString("userFirstName"));
                userInfo.setUserLastName(rs.getString("userLastName"));
                return userInfo;
            }
        };
        List<UserInfo> userInfoList = (List<UserInfo>) jdbcTemplate.queryForObject(
                                                                    sqlText,
                                                                    new Object[] { userFirstName },
                                                                    userInfoRowMapper);
        return userInfoList;

    }
    //==================================================================================================================
    public List<UserInfo> getAllUsers() {

        String sqlText = "select * from UserInfo";

        try{
           List<UserInfo> userInfoList = jdbcTemplate.query(sqlText,new BeanPropertyRowMapper<>(UserInfo.class));
           return  userInfoList;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public boolean addNewUser(UserInfo userInfo) {

        String sqlText = "INSERT INTO UserInfo(UserFirstName,UserLastName, Username, password) VALUES (?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sqlText,new Object[]{userInfo.getUserFirstName(),userInfo.getUserLastName(),userInfo.getUsername(),userInfo.getPassword()});
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    //==================================================================================================================
}
