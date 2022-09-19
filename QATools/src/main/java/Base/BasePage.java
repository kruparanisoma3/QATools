package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.internal.Utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
	Properties prop;
	public static WebElement ele;
	public static ExtentTest test;
	
	
	
	
	public void browserOpen(String browsername) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\drivers\\chromedriver.exe");
			driver=new InternetExplorerDriver();
			
		}
		else {
			driver=new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		prop=new Properties();
		if(prop!=null) {
			File file=new File(System.getProperty("user.dir")+"\\Properties\\object.Properties");
			try {
				FileInputStream fis=new FileInputStream(file);
				prop.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}
	
	
	public void appOpen(String url) {
		try {
		driver.get(prop.getProperty(url));
		reportPass("able to go to the application");
		
		}
		catch(Exception e) {
			reportFail("not able to open correct site"+e.getMessage());
		//	System.out.println(e.getMessage());
			
		}
	}
	
	public void rearclose() {
		driver.close();
		reportPass("closed the browser");
	}
	
	public void pagequit() {
		driver.quit();
		reportPass("quit the browser");
	}
	
	public static WebElement locators(By locator) {
		
		try {
		
		if(locator.equals("xpath")) {
			//ele=driver.findElement(By.xpath(prop.getProperty(locator)));
			ele=driver.findElement(locator);
		}
		else if(locator.equals("id")) {
			ele=driver.findElement(locator);
			
		}
		/*
		 * else if(locator.endsWith("_CSS")) {
		 * ele=driver.findElement(By.cssSelector(prop.getProperty(locator))); } else
		 * if(locator.endsWith("_name")) {
		 * ele=driver.findElement(By.name(prop.getProperty(locator)));
		 * 
		 * } else if(locator.endsWith("_class")) {
		 * ele=driver.findElement(By.className(prop.getProperty(locator))); } else
		 * if(locator.endsWith("_id")) {
		 * ele=driver.findElement(By.id(prop.getProperty(locator))); } else
		 * if(locator.endsWith("_link")) {
		 * ele=driver.findElement(By.linkText(prop.getProperty(locator))); } else
		 * if(locator.endsWith("_partial")) {
		 * ele=driver.findElement(By.partialLinkText(prop.getProperty(locator))); }
		 */
		else {
			System.out.println("not able to locate");
			
		}
		reportPass("matched locator was found");
		}
		catch(Exception e) {
			
			e.getStackTrace();
			System.out.println(e.getMessage());
			reportFail("locator not found");
			
			
		}
		return ele;
		
	}
	
	public static void reportFail(String str) {
		
		Screenshot.takescreen();
		
		test.log(Status.FAIL, str);
		
		
		
	}
	
	public static void reportPass(String str) {
		test.log(Status.PASS,str);
	}
	
	
	public static void titletest(String expected) {
		try {
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected);
		reportPass("title found");
		}
		catch(Exception e) {
			reportFail("Title not found");
		}
	}
	
	
	

}
