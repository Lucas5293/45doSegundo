package com.mthumb.a45doSegundoWeb.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Handler que instancia uma entidade de
 * acordo com a sua propriedade do JSON da api
 * @author lucas
 */
public class JsonToModel {
	
	public static List<Object> toObjects(Class<?> obj, JSONObject json) throws Exception {
		
		List<Object> objetos = new ArrayList<>();
		Map<Field, JSONMapper> toSet = new HashMap<>();

		EmptyOn an = obj.getAnnotation(EmptyOn.class);
		if (an!=null){
			if (isJsonEmpty(an.field(), an.value(), json)) {
				return objetos;
			}
		}

		for (Field atributo : obj.getDeclaredFields()) {
		  if (atributo.isAnnotationPresent(JSONMapper.class)) {
			  JSONMapper mapper = atributo.getAnnotation(JSONMapper.class);
			  toSet.put(atributo, mapper);
		  }
		}
		
		for(Field field: toSet.keySet()) {
			field.setAccessible(true);
			int objIndex=0;
			String atributo  = toSet.get(field).field();
			JSONArray jsonArray = (JSONArray) json.get(toSet.get(field).on());
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject content = (JSONObject) jsonArray.get(i);
				
				Object o;
				if (objetos.size()-1<objIndex) {
					objetos.add(JsonToModel.newObject(obj));
					o = objetos.get(objetos.size()-1);
				}
				else
					o = objetos.get(objIndex);
							
				Object atributoValue=null;
				if (!content.get(atributo).toString().equals("null")) {
					if (field.getType() != String.class)
						atributoValue = JsonToModel
								.convertToPrimitive(field.getType(), (String) content.get(atributo));
					else
						atributoValue = content.get(atributo);
				}
				if (atributoValue!=null) {
					field.set(o, atributoValue);
				}
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

	public static boolean isJsonEmpty(String field, String value, JSONObject json){
		try {
			if (String.valueOf(json.get(field)).equals(value))
                return true;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

}
