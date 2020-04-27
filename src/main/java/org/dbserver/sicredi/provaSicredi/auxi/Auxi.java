package org.dbserver.sicredi.provaSicredi.auxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Auxi {
	
	
	public Properties getProperties(String nomeDoArquivo) throws IOException {
		InputStream inputStream = null;
		Properties prop = new Properties();
		try {
			
			prop = new Properties();
 
			File file = new File(".\\resources\\" + nomeDoArquivo);
			inputStream = new FileInputStream(file);
     		prop.load(inputStream);
			return prop;
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}

}
