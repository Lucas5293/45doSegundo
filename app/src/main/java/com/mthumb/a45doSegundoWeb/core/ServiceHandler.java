package com.mthumb.a45doSegundoWeb.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Handler que instância os services
 *  @author lucas
 */
public class ServiceHandler {
    private Map<Class<?>, Object> instances = new HashMap<>();
    private Map<Class<?>, Class<?>> implementadas = new HashMap<>();

    public void execute() throws Exception{

    }

    public Object getInstance(Class<?> clazz){
        return this.instances.get(clazz);
    }

    private Object newObject(Class<?> clazz) throws Exception{
        Constructor<?> ctor;
        ctor = clazz.getConstructors()[0];
        Object object = ctor.newInstance();
        return object;
    }

    private Class<?> getImpl(Class<?> clazz) throws ClassNotFoundException {
        String className = clazz.getName();
        List<String> splited = Arrays.asList(className.split("\\."));
        List<String> splited2 = splited.subList(0, splited.size()-2);
        String out="";
        for (String s : splited2) {
            out+=s+".";
        }
        out+="impl."+splited.get(splited.size()-1)+"Impl";

        return Class.forName(out);
    }
}
