package core;

import java.io.FileInputStream;
import java.util.Properties;
import static java.lang.String.format;

public class PropertiesFactory {
	public static Properties get(String file) throws Exception {
		
		Properties props = new Properties();
		FileInputStream fileInputStream = new FileInputStream(format("./resources/%s.properties", file));
		props.load(fileInputStream);
		return props;
	}
}
