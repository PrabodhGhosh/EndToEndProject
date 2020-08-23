package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
	/*
	 * getValue returns the value of the key provided as an input. It also
	 * takes file path as an input.
	 */
	public static String getValue(String path, String key)
	{
		String propertyValue = null;
		FileInputStream FIS = null;
		Properties prop = new Properties();
		try {
			FIS = new FileInputStream(path);
			prop.load(FIS);
			propertyValue = prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (FIS != null) {
				try {
					FIS.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
		}
		return propertyValue;
		}

}
