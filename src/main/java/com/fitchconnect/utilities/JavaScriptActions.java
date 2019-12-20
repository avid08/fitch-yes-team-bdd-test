package com.fitchconnect.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by Miah Ashrafuzzaman.
 */
public class JavaScriptActions {

	public void javaClick(WebDriver driver, String element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement elementtoClick = driver.findElement(By.xpath(element));
		js.executeScript("arguments[0].click()", elementtoClick);
	}

	public void javaClickWebElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", element);
	}

	public void scrollTobottom(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public void waitforElement(WebDriver driver, String path) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", path);
	}

	public void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public void clickElementWhenClickable(WebDriver driver, WebElement element, int timeout) {
		WebElement elementToClick = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		elementToClick = wait.until(ExpectedConditions.elementToBeClickable(element));
		elementToClick.click();
	}
}
