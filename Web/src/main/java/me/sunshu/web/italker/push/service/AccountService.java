package me.sunshu.web.italker.push.service;

import me.sunshu.web.italker.push.bean.db.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by sunshu on 17-6-9.
 */

@Path("/account")
public class AccountService {
    @GET
    @Path("/login")
    public String get(){
        return "You get to login";
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User Post(){
        User user = new User();
        user.setName("美女");
        user.setSex(2);
        return user;
    }


}
