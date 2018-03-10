package mthumb.a45doSegundoWeb.core;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import mthumb.a45dosegundo.MainActivity;

import static java.lang.String.format;

public class PropertiesFactory {
	public Properties get(String file) throws Exception {
		
		Properties props = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(format("%s.properties",file));

		props.load(inputStream);

		return props;
	}
}
