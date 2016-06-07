package uk.gov.dwp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.camel.component.properties.PropertiesFunction;

public class FallBackPropertiesPlaceHolder implements PropertiesFunction {

	private final static String defaultPropsFileLocation = "/route.properties";
	
	private Properties props = new Properties();

	
	public FallBackPropertiesPlaceHolder(){
		String propsFileLocation = System.getProperty("route.props");
		System.out.println("**********************************************************");
		System.out.println(" FallBackPropertiesPlaceHolder propsfilelocation = " + propsFileLocation);
		System.out.println("**********************************************************");

		
		System.out.println(System.getenv("datasource.url"));
		try {

			InputStream is = null;
			if ( propsFileLocation == null ){
				is = FallBackPropertiesPlaceHolder.class.getResourceAsStream(defaultPropsFileLocation);
			} else {
				is = new FileInputStream(new File(propsFileLocation));
			}
				
			props.load(is);
						
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	
	@Override
	public String getName() {
		return "props";
	}

	@Override
	public String apply(String key) {
		return props.getProperty(key);
	}

}
