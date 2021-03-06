package me.sunshu.web.italker.push;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import me.sunshu.web.italker.push.provider.GsonProvider;
import me.sunshu.web.italker.push.service.AccountService;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Logger;

/**
 * Created by sunshu
 */
public class Application extends ResourceConfig{

    public Application(){

        // 注册逻辑处的包名
        packages(AccountService.class.getPackage().getName());
        // 注册json 解析
//        register(JacksonJsonProvider.class);
        register(GsonProvider.class);
        // 注册Log
        register(Logger.class);
    }

}
