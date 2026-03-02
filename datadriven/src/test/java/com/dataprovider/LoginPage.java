package com.dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="username")
	private WebElement userName;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="submit")
	private WebElement submitBt;
	@FindBy(xpath="//h1[text()='Logged In Successfully']")
	private WebElement SuccessMsg;
	@FindBy(id="error")
	private WebElement errorMsg;

	public WebElement getErrorMsg() {
		return errorMsg;
	}
	public WebElement getSuccessMsg() {
		return SuccessMsg; 
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSubmitBt() {
		return submitBt;
	}
	

}
