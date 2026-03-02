package com.dataprovider;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import com.utiltyclass.BaseClass;

public class DataProvider1 extends BaseClass{
	
	 public LoginPage lg;
	
	@Test(dataProvider = "login")
	private void login(String userName,String pass,String expectedCondition) throws InterruptedException {
		
		
		initBrowser("chrome");
		browserLaunch("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lg = new LoginPage(driver);
		WebElement userName1 = lg.getUserName();
		sendkeys(userName1,userName );
		WebElement password = lg.getPassword();
		sendkeys(password, pass);
		WebElement submitBt = lg.getSubmitBt();
		click(submitBt);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
		//sucess msg validation
		
		if(expectedCondition.equalsIgnoreCase("valid")) {

          
		WebElement succmsg = wait.until(ExpectedConditions.visibilityOf(lg.getSuccessMsg()));
		String successText = getText(succmsg); 
		Assert.assertEquals(successText, "Logged In Successfully", "Valid login failed!");

        } else {

            // FAILURE CASE (we EXPECT error message)
        	
        	WebElement errmsg = wait.until(ExpectedConditions.visibilityOf(lg.getErrorMsg()));
        	scrollintoView("down", errmsg);
    		String errorMsg = getText(errmsg); 
        	
        	
//            WebElement errorMsg = lg.getErrorMsg();
//            String errorText = getText(errorMsg);

            Assert.assertTrue(
            		errorMsg.contains("Your username is invalid!") ||
            		errorMsg.contains("Your password is invalid!"),
                    "Invalid login did NOT show correct error message!"
            );
        }
				
	}
	@AfterMethod
	private void teardown() {
		driver.quit();
	}
	@DataProvider(name = "login")
	Object[][] loginData(){
		
		Object data[][]= {{"student","pass","Invalid"},{"pass","dasdsa","Invalid"},{"student","Password123","Valid"}};
	
		return data;
	}

}

