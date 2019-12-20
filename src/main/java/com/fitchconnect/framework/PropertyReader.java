package com.fitchconnect.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Miah Ashrafuzzaman.
 */
public class PropertyReader {
	private static PropertyReader instance = null;
	private Properties properties = new Properties();
	private Map<String, String> envVariable = System.getenv();

	private PropertyReader() {
		load();
	}

	public static PropertyReader getInstance() {
		if (instance == null) {
			instance = new PropertyReader();
		}
		return instance;
	}

	public String getProperty(String key) {
		String value = properties.getProperty(key);
		return value;
	}

	public String getEnvProperty(String key) {
		String value = null;
		if (envVariable.containsKey(key)) {
			value = envVariable.get(key);
		}
		return value;
	}

	private void load() {
		InputStream input = null;
		try {
			input = new FileInputStream("src/test/resources/Config.properties");
			// load a properties file
			properties.load(input);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String BROWSER_TO_RUN = PropertyReader.getInstance().getProperty("browser");
	public static String TEST_HOME_URL = PropertyReader.getInstance().getProperty("homePageURL");
	public static String TEST_HOMEPAGE_TITLE = PropertyReader.getInstance().getProperty("homePageTitle");
	public static String TEST_MEMBER_URL = PropertyReader.getInstance().getProperty("homePageURL");
	public static String TEST_MEMBERPAGE_TITLE = PropertyReader.getInstance().getProperty("memberPageTitle");
	public static String USERNAME = PropertyReader.getInstance().getProperty("username");
	public static String PASSWORD = PropertyReader.getInstance().getProperty("password");
	public static String TEST_LOGINPAGE_URL = PropertyReader.getInstance().getProperty("loginPageURL");
	public static String TEST_LOGINPAGE_TITLE = PropertyReader.getInstance().getProperty("loginPageTitle");
}
