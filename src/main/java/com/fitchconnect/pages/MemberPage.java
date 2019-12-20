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
public class MemberPage {

	private WebDriver driver;

	@FindBy(xpath = "//button[@class='p- bdw-1 bdbs-s bdc-gray300 bgc-dim10-hv cur-p-hv p- bdw-1 bdbs-s bdc-gray300 bgc-dim10-hv cur-p-hv']")
	private WebElement logOutSideBar;

	@FindBy(xpath = "//button[@class='ml- bdc-t bdrs-tiny bds-s bdw-1 bgc-lightblue800 c-white fz-small ph- pv-- bgc-gray500-hv cur-p-hv']")
	private WebElement logOut;

	private Mouseandkeyboardactions mousefunction = new Mouseandkeyboardactions();
	private Delayed slowBrowser = new Delayed();

	private String expectedMemberPageTitle = PropertyReader.TEST_MEMBERPAGE_TITLE;

	public MemberPage() {
		loadMemberPage();
	}

	private void loadMemberPage() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void verify_MemberPage() {
		slowBrowser.sleeper(4000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String memberPageURL = driver.getCurrentUrl();
		System.out.println("Memberpage URL is: " + memberPageURL);
		String memberPageTitle = driver.getTitle();
		Assert.assertEquals(expectedMemberPageTitle, memberPageTitle);
		System.out.println("Memberpage title is: " + memberPageTitle);
	}

	public void logout() {
		slowBrowser.sleeper(2000);
		mousefunction.mouseClick(driver, logOutSideBar);
		slowBrowser.sleeper(2000);
		mousefunction.mouseClick(driver, logOut);
		System.out.println("User is logged out.");
	}
}
