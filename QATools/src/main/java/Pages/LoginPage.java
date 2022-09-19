package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	By username=By.xpath("//div[@class='col-md-9 col-sm-12']/input[@id='userName']");
	By pwd=By.id("password");
	By btn=By.id("login");
	
	public void title() {
		
		titletest("ToolsQA");
		
	}
	
	public void loginform() {
		
		
		driver.findElement(username).sendKeys("kruparanisoma");
		driver.findElement(pwd).sendKeys("Krupa@21");
		driver.findElement(btn).click();
		
		
	}
	
	

}
