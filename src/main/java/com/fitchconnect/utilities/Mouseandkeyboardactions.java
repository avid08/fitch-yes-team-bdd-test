package com.fitchconnect.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * Created by Miah Ashrafuzzaman.
 */
public class Mouseandkeyboardactions {

	private JavaScriptActions jScript = new JavaScriptActions();

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions mhover = new Actions(driver);
		jScript.drawBorder(element, driver);
		mhover.moveToElement(element).perform();
	}

	public void mouseClick(WebDriver driver, WebElement element) {
		Actions mclick = new Actions(driver);
		jScript.drawBorder(element, driver);
		mclick.moveToElement(element).click().build().perform();
	}

	public void mouseHover(WebDriver driver, WebElement parent, WebElement child) {
		Actions mhover = new Actions(driver);
		mhover.moveToElement(parent).moveToElement(child).perform();
	}
}
