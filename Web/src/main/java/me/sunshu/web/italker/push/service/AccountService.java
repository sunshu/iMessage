package me.sunshu.web.italker.push.service;

import me.sunshu.web.italker.push.bean.api.account.RegisterModel;
import me.sunshu.web.italker.push.bean.db.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by sunshu
 */

@Path("/account")
public class AccountService {


//    @GET
//    @Path("/login")
//    public String get(){
//        return "You get to login";
//    }
//
//    @POST
//    @Path("/login")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public User Post(){
//        User user = new User();
//        user.setName("美女");
//        user.setSex(2);
//        return user;
//    }


    @POST
    @Path("/register")
    // 指定请求与返回相应体的
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RegisterModel register(RegisterModel registerModel){
        return registerModel;
//        User user = new User();
//        user.setName("美女");
//        user.setSex(2);
//        return user;


    }


}
