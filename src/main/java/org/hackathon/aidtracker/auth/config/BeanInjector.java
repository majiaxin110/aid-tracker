package org.hackathon.aidtracker.auth.config;

import org.hackathon.aidtracker.multipart.AsyncMultipartResolver;
import org.hackathon.aidtracker.multipart.CustomRawStreamHandler;
import org.hackathon.aidtracker.multipart.DefaultRawStreamHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeanInjector {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    AsyncMultipartResolver multipartResolver(){
//
////        Map<String, AsyncMultipartResolver.Anchor> excluded=new HashMap<>();
////        excluded.put("/ttt",new AsyncMultipartResolver.Anchor("async","ok"));
////        excluded.put("/test",new AsyncMultipartResolver.Anchor(new CustomRawStreamHandler(),"sss","ok"));
////        return new AsyncMultipartResolver(excluded);
//    }

//    @Bean
//    CommonsMultipartResolver multipartResolver(){
//        return new CommonsMultipartResolver();
//    }
}
