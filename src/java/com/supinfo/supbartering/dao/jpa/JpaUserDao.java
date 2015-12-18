/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.dao.jpa;

import com.supinfo.supbartering.dao.UserDao;
import com.supinfo.supbartering.entity.User;
import com.supinfo.supbartering.entity.User_;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        try {
            return em.find(User.class, idUser);
        } catch (Exception e) {
            User user = new User();
            return (User) user;
        }
    }

    @Override
    public User findUserByUsername(String username) {
        /*
        try {
            return em.find(User.class, username);
        } catch (Exception e) {
            return null;
        }
        */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        List<Predicate> predicate = new ArrayList<>();
        
        if ( username != null )
            predicate.add(cb.equal(user.get(User_.userName), username));
        
        query.where(predicate.toArray(new Predicate[predicate.size()]));
        
        try {
            return em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            return null;
        }         
    }

    @Override
    public User getUserConnection(String username, String password) {
        /*
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :username AND u.password = :password");
        query.setParameter("username", username).setParameter("password", password);
        try {
            return (User) query.getSingleResult();            
        } catch(Exception e) {
            return null;
        }
        */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        List<Predicate> predicate = new ArrayList<>();
        
        if ( username != null )
            predicate.add(cb.equal(user.get(User_.userName), username));
        if ( password != null )
            predicate.add(cb.equal(user.get(User_.password), password));
        
        query.where(predicate.toArray(new Predicate[predicate.size()]));
        
        try {
            return em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            User userNull = new User();
            return (User) userNull;
        }            
    }

    @Override
    public Long countNumberOfUser() {
        /*
        Query query = em.createQuery("SELECT COUNT(u.userName) FROM User u");
        try {
            return (Long) query.getSingleResult();
        } catch ( Exception e ) {
            return null;
        }
        */
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(User.class)));  
        try {
            return em.createQuery(cq).getSingleResult();
        } catch ( Exception e ) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = em.createQuery(all);
        
        try {
            return allQuery.getResultList();        
        } catch ( Exception e ) {
            return null;
        }
    }
    
}
