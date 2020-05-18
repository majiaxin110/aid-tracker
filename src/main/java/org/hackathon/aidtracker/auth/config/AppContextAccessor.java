package org.hackathon.aidtracker.auth.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContextAccessor implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppContextAccessor.context=applicationContext;
    }
    public static<T> T getBean(Class<T> cls){
        return context.getBean(cls);
    }
    public static<T> T getBean(Class<T> cls,String qualifier){
        return context.getBean(qualifier,cls);
    }


    public static ApplicationContext getContext(){
        return AppContextAccessor.context;
    }
}
