package com.utiltyclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
public class BaseClass {
	
	public static WebDriver driver;
	public Actions action;
	public JavascriptExecutor js;
	public String path = "C:\\Users\\Hi\\Desktop\\Kanishkar\\";
	
	
	public void initBrowser(String browser) {
		
		switch(browser.toLowerCase()) {
		
		case "chrome":
			
			 driver = new ChromeDriver();
			break;
		case "edge":
			
			 driver = new EdgeDriver();
			break;
		
		case "firefox":
			 driver = new FirefoxDriver();
			break;
			
			default:
			
			System.out.println("Invalid browser");
		
		}
	}
	public void sendkeys(WebElement ele, String Data) {
		
		ele.sendKeys(Data);

	}

	public void browserLaunch(String Url) {
		driver.get(Url);

	}
	
	
	public void click(WebElement ele) {
		
		ele.click();
	}
	
	public void dropDown(WebElement ele,String type, String Data) {
	
		Select sel = new Select(ele);
		
		switch(type.toLowerCase()) {
		case "value":
			
			sel.selectByValue(Data);
			break;
		case "text":
			sel.selectByVisibleText(Data);
			break;
			
		case "index":
			
			int index = Integer.parseInt(Data);
		sel.selectByIndex(index);
		break;
				
		}
	}
	public void mouseAction(WebElement ele ,String type) {
		
		 action = new Actions(driver);
		switch(type.toLowerCase()) {
		
		case "hover":
			action.moveToElement(ele).perform();
			break;
		case "double":
			action.doubleClick().perform();
			break;
		case "right":
			action.contextClick().perform();break;
		case "click":
			action.click().perform();break;
		}
}
	
	public void dragandDrop(WebElement source,WebElement destination) {
		action = new Actions(driver);
		
		action.dragAndDrop(source, destination).build().perform();
		
	}
	
	public void scrollintoView(String upordown,WebElement ele) {
		
		js = (JavascriptExecutor) driver;
		
		switch(upordown.toLowerCase()) {
		case "down":
			js.executeScript("arguments[0].scrollIntoView(true)", ele);break;
		case "up":
			js.executeScript("arguments[0].scrollIntoView(false)", ele);break;
	
		
		}

	}
	
	public void takescreenshot() {
		

	
	String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	File dateFolder = new File(path + File.separator + currentDate);
    if (!dateFolder.exists()) {
        dateFolder.mkdirs();
    }
    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    TakesScreenshot tk = (TakesScreenshot) driver;
    File source = tk.getScreenshotAs(OutputType.FILE);
    //newpath
    File destination = new File(dateFolder + File.separator + "Screenshot_" + timeStamp + ".png");
    try {
		FileUtils.copyFile(source, destination);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
		
	}
	
	public  String getText(WebElement ele) {
		String text = ele.getText();
        return text;
	}
	
	
	
	
}
