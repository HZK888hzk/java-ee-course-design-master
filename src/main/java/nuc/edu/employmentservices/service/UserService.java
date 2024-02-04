package nuc.edu.employmentservices.service;

import nuc.edu.employmentservices.dao.UserMapper;
import nuc.edu.employmentservices.enity.User;
import nuc.edu.employmentservices.enity.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getAllUsers() {
        List<User> users = userMapper.getAllUsers();
        return users;
    }

    public User getUserById(Integer userId) {
        User user = userMapper.getUserById(userId);
        return user;
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUserBy(User user) {
        userMapper.updateUserBy(user);
    }

    public void deleteUserById(Integer userId) {
        userMapper.deleteUserById(userId);
    }

    public Integer GetUserNum() {
        return userMapper.GetUserNum();
    }

    public List<User> selectUserByType(Integer typeid) {
        return userMapper.selectUserByType(typeid);
    }

    public void deleteUserByuserId(Integer userId) {
        userMapper.deleteUserByuserId(userId);
    }

    public void updateUserByuserid(User user) {
        userMapper.updateUserByuserid(user);
    }


    public List<View> gather() {
        return userMapper.gather();
    }

    ;


    /**
     * 柱状图
     *
     * @return
     */
    public List<View> admins() {
        return userMapper.admins();
    }
}
