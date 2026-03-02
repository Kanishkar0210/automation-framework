package com.sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utiltyclass.BaseClass;

import RunnerPage.Runner;

public class Sample extends BaseClass{

	
	public static void main(String[] args) {
		Sample r = new Sample();
		
		
		r.initBrowser("chrome");
		r.browserLaunch("https://demoqa.com/");
		driver.manage().window().maximize();

		// 1. Wait for the element to exist
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//h5[text()='Book Store Application']")));

		// 2. Scroll into view with offset (avoid sticky header)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -100);", element);

		// 3. Wait until clickable
		wait.until(ExpectedConditions.elementToBeClickable(element));

		// 4. Click safely with JS fallback
		try {
		    element.click(); // normal click
		} catch (ElementClickInterceptedException e) {
		    js.executeScript("arguments[0].click();", element); // fallback click
		}				
		
	}
}
