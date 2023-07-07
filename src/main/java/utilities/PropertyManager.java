package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyManager {
	static Logger log = Logger.getLogger(PropertyManager.class.getName());

	public String getProperty(String key) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;

		String currentDirectory = System.getProperty("user.dir");
		String resourceName = currentDirectory + "/src/main/resources/base.properties";

		try {
			fis = new FileInputStream(resourceName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop.getProperty(key);
	}
}