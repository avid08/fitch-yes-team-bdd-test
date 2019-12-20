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
import com.fitchconnect.utilities.JavaScriptActions;
import com.fitchconnect.utilities.MultipleWindows;

/**
 * Created by Miah Ashrafuzzaman.
 */
public class LoginPage {

	private WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement logInEmailInput;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement logInPasswordInput;

	@FindBy(xpath = "//button[@id='signIn']")
	private WebElement signInSubmitButton;

	private JavaScriptActions js = new JavaScriptActions();
	private Delayed slowBrowser = new Delayed();
	private MultipleWindows sWindows = new MultipleWindows();

	private String loginPageTitle = PropertyReader.TEST_LOGINPAGE_TITLE;

	public LoginPage() {
		loadLoginPage();
	}

	private void loadLoginPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_LoginPage() {
		sWindows.switchToNewTab(driver);
		slowBrowser.sleeper(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String expectedLoginPageURL = driver.getCurrentUrl();
		System.out.println("Loginpage URL is: " + expectedLoginPageURL);
		String expectedLoginPageTitle = driver.getTitle();
		Assert.assertEquals(expectedLoginPageTitle, loginPageTitle);
		System.out.println("Loginpage title is: " + expectedLoginPageTitle);
	}

	public void enterUsername(String username) {
		slowBrowser.delay(2000);
		logInEmailInput.sendKeys(username);
		System.out.println("Username is: " + username);
	}

	public void enterPassword(String password) {
		slowBrowser.delay(2000);
		logInPasswordInput.sendKeys(password);
		System.out.println("Password is: " + password);
	}

	public void clickSubmit() {
		slowBrowser.sleeper(2000);
		js.javaClickWebElement(signInSubmitButton, driver);
	}
}