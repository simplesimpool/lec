package com.lec.webproj.utility;
import java.lang.reflect.Field;

public class CheckNullUtility {
    public static boolean isNullDataExists(Object obj) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
           
                field.setAccessible(true);
                Object value = field.get(obj);

                if (value == null) {
                    System.out.println("null : " + field.getName());
                    return true;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false; 
    }
}