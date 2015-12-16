/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.dao.jpa;

import com.supinfo.supbartering.dao.UserDao;
import com.supinfo.supbartering.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Laurent
 */
@Stateless
public class JpaUserDao implements UserDao
{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }
    
    @Override
    public User findUserById(Long idUser) {
        return em.find(User.class, idUser);
    }

    @Override
    public User findUserByUsername(String username) {
        return em.find(User.class, username);
    }

    @Override
    public User getUserConnection(String username, String password) {
        //Query query = em.createQuery("SELECT u FROM User u WHERE u. username = :username AND u. password = :password").getSingleResult();
        /*
        Query queryCheck = em.createNamedQuery("SELECT COUNT(u) FROM User u WHERE u.userName = :username AND u.password = :password");
        queryCheck.setParameter("username", username).setParameter("password", password);
        Integer checkUser = (Integer) queryCheck.getResultList().size();
        if ( checkUser == 1 ) {
        */
            Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :username AND u.password = :password");
            return (User) query.setParameter("username", username).setParameter("password", password).getSingleResult();
        /*
        } else 
            return new User();
        */
    }
    
}
