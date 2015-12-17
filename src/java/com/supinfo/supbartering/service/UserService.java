/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.service;

import com.supinfo.supbartering.dao.UserDao;
import com.supinfo.supbartering.entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Laurent
 */
@Stateless
public class UserService {
    
    @EJB
    private UserDao userDao;
    
    public void addUser(User user) {
        userDao.addUser(user);
    }
    
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    
    public User findUserById(Long idUser) {
        return userDao.findUserById(idUser);
    }
    
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
    
    public User getUserConnection (String username, String password) {
        return userDao.getUserConnection(username, password);
    }
    
    public Long countNumberOfUser() {
        return userDao.countNumberOfUser();
    }
    
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    
}
