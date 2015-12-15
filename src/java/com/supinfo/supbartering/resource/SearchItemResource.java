/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.resource;

import com.supinfo.supbartering.entity.Item;
import com.supinfo.supbartering.service.ItemService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Laurent
 */
@Path("/search-items")
@Stateless
public class SearchItemResource {

    @EJB
    private ItemService itemService;

    @GET
    @Path("/{search}")
    public List<Item> searchItemByString(@PathParam("query") String search) {
        return itemService.searchItemByString(search);
    }

}
