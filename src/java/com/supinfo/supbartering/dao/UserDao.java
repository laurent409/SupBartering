/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.dao;

import com.supinfo.supbartering.entity.User;
import javax.ejb.Local;

/**
 *
 * @author Laurent
 */

@Local
public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public User findUserById(Long idUser);
    public User getUserConnection(String username, String password);
}
