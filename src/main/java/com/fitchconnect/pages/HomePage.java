package com.fitchconnect.pages;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fitchconnect.framework.DriverFactory;
import com.fitchconnect.framework.PropertyReader;
import com.fitchconnect.utilities.Delayed;
import com.fitchconnect.utilities.Mouseandkeyboardactions;

/**
 * Created by Miah Ashrafuzzaman.
 */
public class HomePage {

	private WebDriver driver;
	////div[@class='button button--2 button--action js-login']
	////a[@href='https://app.fitchconnect.com/']
     //*[@id="block-headeruseractions"]/div/div[1]
	// //*[@id="block-headeruseractions"]/div/div[2]/ul/li[1]/a

	////*[@id="block-headeruseractions"]/div/div[1]
	///html/body/div[1]/header/div/div[3]/div/div[2]/div/div[1]
	// document.querySelector("#block-headeruseractions > div > div.button.button--2.button--action.js-login.active")
	//#block-headeruseractions > div > div.button.button--2.button--action.js-login.active
	// //*[@id="block-headeruseractions"]/div/div[1]
	@FindBy(xpath = "//div[@class=\"button button--2 button--action js-login\"]")
	private WebElement logInLink;

	@FindBy(xpath = "//a[@href='https://app.fitchconnect.com/']")
	private WebElement fitchConnectLink;

	private Mouseandkeyboardactions mousefunction = new Mouseandkeyboardactions();
	private Delayed slowBrowser = new Delayed();

	private String expecteHomePageTitle = PropertyReader.TEST_HOMEPAGE_TITLE;

	public HomePage() {
		loadHomePage();
	}

	private void loadHomePage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void goToHomepage(String website) {
		slowBrowser.delay(2000);
		driver.navigate().to(website);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String homePageURL = driver.getCurrentUrl();
		System.out.println("Homepage URL is: " + homePageURL);
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(expecteHomePageTitle, homePageTitle);
		System.out.println("Homepage title is: " + homePageTitle);
	}

	public void clickLogIn() {
		mousefunction.mouseClick(driver, logInLink);
	}

	public void clickFitchConnect() {
		mousefunction.mouseClick(driver, fitchConnectLink);
	}

}
