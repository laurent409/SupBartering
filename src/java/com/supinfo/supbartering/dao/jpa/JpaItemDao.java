/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.dao.jpa;

import com.supinfo.supbartering.entity.Item;
import com.supinfo.supbartering.dao.ItemDao;
import com.supinfo.supbartering.entity.Item_;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
public class JpaItemDao implements ItemDao {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addItem(Item item) {
        em.persist(item);
    }

    @Override
    public void deleteItem(Item item) {
        item = em.merge(item);
        em.remove(item);
    }

    @Override
    public Item findItemById(Long idItem) {
        try {
            return em.find(Item.class, idItem);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        //return em.createQuery("SELECT it FROM Item it").getResultList();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> rootEntry = cq.from(Item.class);
        CriteriaQuery<Item> all = cq.select(rootEntry);
        TypedQuery<Item> allQuery = em.createQuery(all);
        try {
            return allQuery.getResultList();
        } catch( Exception e) {
            return null;
        }
    }
        
    @Override
    public List<Item> getItemsFromUser(Long idCreator) {
        //Query query = em.createQuery("SELECT it FROM Item it WHERE it.idCreator = :idCreator");
        //return (List<Item>) query.setParameter("idCreator", idCreator).getResultList();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> query = cb.createQuery(Item.class);
        Root<Item> root = query.from(Item.class);
        List<Predicate> predicate = new ArrayList<>();
        if ( idCreator != null )
            predicate.add(cb.equal(root.get(Item_.idCreator), idCreator));

        query.where(predicate.toArray(new Predicate[predicate.size()]));
        
        try {
            return (List<Item>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            return null;
        }               
    }

    @Override
    public List<Item> searchItemByString(String searchLikeThis) {
        Query query = em.createQuery(
            "SELECT it FROM Item it WHERE it.name LIKE :searchLikeThis "
                    + "OR it.description LIKE :searchLikeThis "
                    + "OR it.type LIKE :searchLikeThis ");          
        try {
            return (List<Item>) query.setParameter("searchLikeThis", "%"+searchLikeThis+"%").getResultList();
        } catch (Exception e) {
            return null;
        }
        /*
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> query = cb.createQuery(Item.class);
        Root<Item> root = query.from(Item.class);
        List<Predicate> predicate = new ArrayList<>();
        if ( searchLikeThis != null ) {
            predicate.add(cb.or(
                    cb.like(root.get(Item_.name), searchLikeThis),
                    cb.like(root.get(Item_.description), searchLikeThis), 
                    cb.like(root.get(Item_.type), searchLikeThis)));
        }
        query.where(predicate.toArray(new Predicate[predicate.size()]));
        
        try {
            return (List<Item>) em.createQuery(query).getResultList();
        } catch (Exception e) {
            return null;
        }               
        */
    }

    @Override
    public Long countNumberOfItems() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(Item.class)));  
        try {
            return em.createQuery(cq).getSingleResult();
        } catch ( Exception e ) {
            return null;
        }
    }
}
