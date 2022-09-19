package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.BasePage;

public class HomePage extends BasePage {
	static WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		
	}
	
	
	
	By xpath=By.xpath("//div[@class='main-header']");
	By loginbtn=By.xpath("//button[@id='login']");
	

	
	public void title() {
		
		titletest("ToolsQA");
	
	}
	
	
	public void testheader() {
		
		String str=driver.findElement(xpath).getText();
		System.out.println(str);
		Assert.assertEquals(str, "Book Store");
		
	}
	public void clickbtn() {
		
		driver.findElement(loginbtn).click();
		
		
	}
	
	
	

}
