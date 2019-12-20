package com.fitchconnect.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

/**
 * Created by Miah Ashrafuzzaman.
 */
public class DriverFactory {

	private ThreadLocal<WebDriver> driverBase = new ThreadLocal<WebDriver>();
	private static DriverFactory instance = null;

	private DriverFactory() {
	}

	public static DriverFactory initialize() {
		return initialize(null);
	}

	public static DriverFactory initialize(String browser) {
		if (instance == null) {
			instance = new DriverFactory();
		}

		if (browser == null) {
			browser = "";
		}

		if (instance.driverBase.get() == null) {
			WebDriver driver;
			System.out.println("Starting browser: " + browser);

			switch (browser.toLowerCase()) {



			case "chrome":
				ChromeDriverManager.getInstance().arch32().setup();
				driver = new ChromeDriver();
				instance.driverBase.set(driver);
				break;

			case "firefox":
				FirefoxDriverManager.getInstance().arch32().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.setCapability("marionette", true);
				driver = new FirefoxDriver(options);
				instance.driverBase.set(driver);
				break;

			case "ie":
				InternetExplorerDriverManager.getInstance().arch32().setup();
				driver = new InternetExplorerDriver();
				instance.driverBase.set(driver);
				break;

			case "":
				ChromeDriverManager.getInstance().arch32().setup();
				ChromeOptions options1 = new ChromeOptions();
				options1.addArguments("window-size=1400,800");
				options1.addArguments("headless");
				driver = new ChromeDriver(options1);
				instance.driverBase.set(driver);
				break;

			default:
				break;
			}

		}
		return instance;
	}

	public WebDriver getdriver() {
		return driverBase.get();
	}

	public void tearDown() {
		driverBase.get().quit();
		driverBase.remove();
		driverBase.set(null);
	}
}
