package mthumb.a45doSegundoWeb.api;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import mthumb.a45doSegundoWeb.core.PropertiesFactory;
import mthumb.a45doSegundoWeb.core.TestsFactory;

public class APIConnectionTest extends TestsFactory{

	PropertiesFactory propertiesFactory;
	APIConnection apiConnection;

	@Before
	public void setUp() throws Exception {
		propertiesFactory = (PropertiesFactory) this.getServiceHandler().getInstance(PropertiesFactory.class);
		apiConnection = (APIConnection) this.getServiceHandler().getInstance(APIConnection.class);
	}
	@Test
	public void test() throws Exception {
		String result = apiConnection.sendGet(propertiesFactory.get("api").getProperty("api.leagues.all"));
		System.out.println(result);
		System.out.println(apiConnection.toJSON(result).toString());
	}

}
