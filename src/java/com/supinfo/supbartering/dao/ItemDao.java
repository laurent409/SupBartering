/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.dao;

import com.supinfo.supbartering.entity.Item;
import java.util.List;

/**
 *
 * @author Laurent
 */
public interface ItemDao {
    public void addItem(Item item);
    public void deleteItem(Item item);
    public Item findItemById(Long idItem);
    public List<Item> getAllItems();
    public List<Item> getItemsFromUser(Long idCreator);
    public List<Item> searchItemByString(String searchLikeThis);
}
