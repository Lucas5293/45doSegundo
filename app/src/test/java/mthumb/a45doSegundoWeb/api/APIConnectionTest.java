package mthumb.a45doSegundoWeb.api;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import mthumb.a45doSegundoWeb.core.PropertiesFactory;

public class APIConnectionTest {
	
	Properties propertiesApi;

	@Before
	public void setUp() throws Exception {
		propertiesApi=new PropertiesFactory().get("api");
	}
	@Test
	public void test() throws Exception {
		String result = APIConnection.sendGet(propertiesApi.getProperty("api.leagues.all"));
		System.out.println(result);
		System.out.println(APIConnection.toJSON(result).toString());
	}

}
