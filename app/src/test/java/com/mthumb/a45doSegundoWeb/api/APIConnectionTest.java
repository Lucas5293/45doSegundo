package com.mthumb.a45doSegundoWeb.api;

import org.junit.Before;
import org.junit.Test;

import com.mthumb.a45doSegundoWeb.core.PropertiesFactory;
import com.mthumb.a45doSegundoWeb.core.ServiceHandler;

public class APIConnectionTest{

	PropertiesFactory propertiesFactory;
	APIConnection apiConnection;

	@Before
	public void setUp() throws Exception {
		propertiesFactory = (PropertiesFactory) ServiceHandler.get(PropertiesFactory.class);
		apiConnection = (APIConnection) ServiceHandler.get(APIConnection.class);
	}
	@Test
	public void test() throws Exception {
		String result = apiConnection.sendGet(propertiesFactory.get("api").getProperty("api.leagues.all"));
		System.out.println(result);
		System.out.println(apiConnection.toJSON(result).toString());
	}

}
