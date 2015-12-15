/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.service;

import com.supinfo.supbartering.entity.Item;
import com.supinfo.supbartering.dao.ItemDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Laurent
 */
@Stateless
public class ItemService {
    
    @EJB
    private ItemDao itemDao;
    
    public void addObject(Item item) {
        itemDao.addItem(item);
    }
    
    public void deleteItem(Item item) {
        itemDao.deleteItem(item);
    }
    
    public Item findItemById(Long idItem) {
        return (Item) itemDao.findItemById(idItem);
    }
    
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }
    
    public List<Item> getItemsFromUser(Long idCreator) {
        return itemDao.getItemsFromUser(idCreator);
    }
    
    public List<Item> searchItemByString(String searchLikeThis) {
        return itemDao.searchItemByString(searchLikeThis);
    }
}
