/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import com.glaresea.membershare.entity.Friend;
import com.glaresea.membershare.entity.FriendPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 * 2017-7-5 21:13:39
 * @author Weiguang Wang
 * @Email: wangwg2005@163.com
 */
@Stateless
@Path("com.glaresea.membershare.entity.friend")
public class FriendFacadeREST extends AbstractFacade<Friend> {

    @PersistenceContext(unitName = "com.glaresea_membershare_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private FriendPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;user1=user1Value;user2=user2Value'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.glaresea.membershare.entity.FriendPK key = new com.glaresea.membershare.entity.FriendPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> user1 = map.get("user1");
        if (user1 != null && !user1.isEmpty()) {
            key.setUser1(new java.lang.Integer(user1.get(0)));
        }
        java.util.List<String> user2 = map.get("user2");
        if (user2 != null && !user2.isEmpty()) {
            key.setUser2(new java.lang.Integer(user2.get(0)));
        }
        return key;
    }

    public FriendFacadeREST() {
        super(Friend.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Friend entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Friend entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.glaresea.membershare.entity.FriendPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Friend find(@PathParam("id") PathSegment id) {
        com.glaresea.membershare.entity.FriendPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friend> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Friend> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
