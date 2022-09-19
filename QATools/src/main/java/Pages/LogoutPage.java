package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.BasePage;

public class LogoutPage extends BasePage {
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By ele=By.id("userName-value");
	By btn=By.id("submit");
	
	public void title() {
		
		titletest("ToolsQA");
		
		
	}
	
	public void test() {
				String str=driver.findElement(ele).getText();
		Assert.assertEquals(str, "kruparanisoma");
		
	
	}
	public void logoutclick() {
		
		driver.findElement(btn).click();
		
	}

}
