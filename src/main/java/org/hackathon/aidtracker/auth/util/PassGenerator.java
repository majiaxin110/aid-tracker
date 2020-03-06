package org.hackathon.aidtracker.auth.util;

import org.hackathon.aidtracker.auth.config.AppContextAccessor;
import org.springframework.context.ApplicationContext;

public class PassGenerator {
    public static void main(String[] args) {
        gen();
    }
    public static void gen(){
        ApplicationContext context = AppContextAccessor.getContext();
        System.out.println(context);
    }
}
