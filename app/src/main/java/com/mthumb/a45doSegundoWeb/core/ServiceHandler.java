package com.mthumb.a45doSegundoWeb.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

/** Handler que instância os services
 *  @author lucas
 */
public class ServiceHandler {

    private static Map<Class<?>, Object> instances = new HashMap<>();

    public static Object get(Class<?> clazz){
        if (!instances.containsKey(clazz)) {
            instances.put(clazz, newObject(clazz));
        }
        return ServiceHandler.instances.get(clazz);
    }

    private static Object newObject(Class<?> clazz){
        Constructor<?> ctor;
        ctor = clazz.getConstructors()[0];
        Object object=null;
        try {
             object = ctor.newInstance();
        }catch (Exception e){
            new Exception(format("Erro ao instanciar serviço: %s\n%s",clazz.getName(),e));
        }
        return object;
    }

}
