package com.mthumb.a45doSegundoWeb.core;

import static java.lang.String.format;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.mthumb.a45doSegundoWeb.api.APIConnection;
import com.mthumb.a45doSegundoWeb.models.League;

public class ModelHandlerTest extends TestsFactory {

	PropertiesFactory propertiesFactory;
	APIConnection apiConnection;

	@Before
	public void setUp() throws Exception {
		propertiesFactory = (PropertiesFactory) this.getServiceHandler().getInstance(PropertiesFactory.class);
		apiConnection = (APIConnection) this.getServiceHandler().getInstance(APIConnection.class);
	}
	
	@Test
	public void test() throws Exception {
		String result = apiConnection.sendGet(format(propertiesFactory.get("api").getProperty("api.leagues.by.country"),"brazil"));
		
		for(Object o : ModelHandler.toObjects(League.class,apiConnection.toJSON(result)) ) {
			League liga = (League) o;
			System.out.println(liga.id);
			System.out.println(liga.nome);
			System.out.println(liga.pais);
		}
	}

}
