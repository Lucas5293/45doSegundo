package com.mthumb.a45doSegundoWeb.core;

import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

/** Reponsável por carregar as properties
 *  @author lucas
 */
public class PropertiesFactory {

	public Properties get(String file) throws Exception {
		
		Properties props = new Properties();
		InputStream inputStream = PropertiesFactory.class.getClassLoader().getResourceAsStream(format("%s.properties",file));

		props.load(inputStream);

		return props;
	}
}
