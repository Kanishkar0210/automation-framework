package RunnerPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.pojo.LoginPage;

import com.utiltyclass.BaseClass;

public class Runner extends BaseClass {
	
	public static void main(String[] args) {
		
		Runner r = new Runner();
		
		
r.initBrowser("chrome");
		r.browserLaunch("https://demoqa.com/");
//		
//		
//		driver.manage().window().maximize();
//		LoginPage l=new LoginPage(r.driver);
//		
//		WebElement email = l.getEmail();
//		r.sendkeys(email, "Kanishkar");
//		
//		WebElement password = l.getPassword();
//		r.sendkeys(password, "12345");
//		
//		WebElement getbtnLogin = l.getLoginButton();
//		r.click(getbtnLogin);
//		//r.mouseAction(getbtnLogin, "click");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));
		r.scrollintoView("down", element);
		r.click(element);
		
	}

}
