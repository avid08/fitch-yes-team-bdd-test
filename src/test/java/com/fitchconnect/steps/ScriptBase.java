package com.fitchconnect.steps;

import java.util.concurrent.TimeUnit;

import com.fitchconnect.framework.DriverFactory;
import com.fitchconnect.pages.PageManager;
import com.fitchconnect.testbase.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
/**
 * Created by Miah Ashrafuzzaman.
 */
public class ScriptBase extends TestBase {

	@Before
	public void setUp() {
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		PageManager.getInstance().closePages();
		try {
			DriverFactory.initialize().tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
