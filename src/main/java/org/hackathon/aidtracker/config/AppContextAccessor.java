package org.hackathon.aidtracker.config;

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
    public static Object getBean(String name) throws BeansException {
        return AppContextAccessor.context.getBean(name);
    }

    public static ApplicationContext getContext(){
        return AppContextAccessor.context;
    }
}
