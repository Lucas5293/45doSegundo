package mthumb.a45doSegundoWeb.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.reflections.Reflections;

/** Handler que instância os services
 *  @author lucas
 */
public class ServiceHandler {
    private Map<Class<?>, Object> instances = new HashMap<>();
    private Map<Class<?>, Class<?>> implementadas = new HashMap<>();

    public void execute() throws Exception{
        Reflections ref = new Reflections("mthumb");
        for (Class<?> cl : ref.getTypesAnnotatedWith(Service.class)) {
            if (cl.isInterface()) {
                Class<?> impl = this.getImpl(cl);
                instances.put(cl, this.newObject(impl));
                implementadas.put(impl, cl);
            }
            else if (!instances.containsKey(cl)){
                if (!implementadas.keySet().contains(cl))
                    instances.put(cl,this.newObject(cl));
            }
        }

        for (Class<?> cl : ref.getTypesAnnotatedWith(Service.class)) {
            for (Field field : cl.getFields()) {
                if (field.isAnnotationPresent(ServiceInstance.class)) {
                    Object toset;
                    if (implementadas.keySet().contains(cl))
                        toset = instances.get(implementadas.get(cl));
                    else
                        toset = instances.get(cl);
                    field.set(toset, instances.get(field.getType()));
                }
            }
        }
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
