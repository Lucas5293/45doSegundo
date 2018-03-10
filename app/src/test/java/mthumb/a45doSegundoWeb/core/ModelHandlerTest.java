package mthumb.a45doSegundoWeb.core;

import static java.lang.String.format;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import mthumb.a45doSegundoWeb.api.APIConnection;
import mthumb.a45doSegundoWeb.models.League;

public class ModelHandlerTest {
	
	Properties propertiesApi;

	@Before
	public void setUp() throws Exception {
		propertiesApi=new PropertiesFactory().get("api");
	}
	
	@Test
	public void test() throws Exception {
		String result = APIConnection.sendGet(format(propertiesApi.getProperty("api.leagues.by.country"),"brazil"));
		
		for(Object o : ModelHandler.toObjects(League.class,APIConnection.toJSON(result)) ) {
			League liga = (League) o;
			System.out.println(liga.id);
			System.out.println(liga.nome);
			System.out.println(liga.pais);
		}
	}

}
