/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.dao.jpa;

import com.supinfo.supbartering.entity.Item;
import com.supinfo.supbartering.dao.ItemDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        return em.find(Item.class, idItem);
    }

    @Override
    public List<Item> getAllItems() {
        return em.createQuery("SELECT it FROM Item it").getResultList();
    }
    
    @Override
    public List<Item> getItemsFromUser(Long idCreator) {
        Query query = em.createQuery("SELECT it FROM Item it WHERE it.idCreator = :idCreator");
        return (List<Item>) query.setParameter("idCreator", idCreator).getResultList();
    }

    @Override
    public List<Item> searchItemByString(String searchLikeThis) {
        Query query = em.createQuery(
            "SELECT it FROM Item it WHERE it.name LIKE :searchLikeThis "
                    + "OR it.description LIKE :searchLikeThis "
                    + "OR it.type LIKE :searchLikeThis ");          
        return (List<Item>) query.setParameter("searchLikeThis", "%"+searchLikeThis+"%").getResultList();
    }
}
