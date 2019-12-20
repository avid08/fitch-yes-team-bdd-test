package com.fitchconnect.testbase;

import org.openqa.selenium.WebDriver;
import com.fitchconnect.framework.DriverFactory;
import com.fitchconnect.framework.PropertyReader;
/**
 * Created by Miah Ashrafuzzaman.
 */
public class TestBase {
	protected WebDriver driver = DriverFactory.initialize(PropertyReader.BROWSER_TO_RUN).getdriver();
}
