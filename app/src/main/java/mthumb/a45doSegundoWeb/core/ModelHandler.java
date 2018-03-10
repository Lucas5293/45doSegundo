package mthumb.a45doSegundoWeb.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


public class ModelHandler {
	
	public static List<Object> toObjects(Class<?> obj, JSONObject json) throws Exception {
		
		List<Object> objetos = new ArrayList<>();
		Map<Field, JSONMapper> toSet = new HashMap<>();
		
		for (Field atributo : obj.getDeclaredFields()) {
		  if (atributo.isAnnotationPresent(JSONMapper.class)) {
			  JSONMapper mapper = atributo.getAnnotation(JSONMapper.class);
			  toSet.put(atributo, mapper);
		  }
		}
		
		for(Field field: toSet.keySet()) {
			int objIndex=0;
			String atributo  = toSet.get(field).field();
			JSONArray jsonArray = (JSONArray) json.get(toSet.get(field).on());
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject content = (JSONObject) jsonArray.get(i);
				
				Object o;
				if (objetos.size()-1<objIndex) {
					objetos.add(ModelHandler.newObject(obj));
					o = objetos.get(objetos.size()-1);
				}
				else
					o = objetos.get(objIndex);
							
				Object atributoValue;
				if (field.getType()!=String.class)
					atributoValue = ModelHandler
						.convertToPrimitive(field.getType(), (String) content.get(atributo));
				else
					atributoValue = content.get(atributo);
				
				field.set(o, atributoValue);
				objIndex++;
			}
		}
			

		return objetos;
	}
	
	public static Object newObject(Class<?> clazz) throws Exception{
		 Constructor<?> ctor;         
		 ctor = clazz.getConstructors()[0];
		 Object object = ctor.newInstance();
		 return object;
	}
	
	public static Object convertToPrimitive(Class<?> primi, String value){
		if (primi== int.class)
			return Integer.valueOf(value);
		else if (primi== float.class)
			return Float.valueOf(value);
		else if (primi== boolean.class)
			return Boolean.valueOf(value);
		else if (primi== double.class)
			return Double.valueOf(value);
		return null;
	}

}
