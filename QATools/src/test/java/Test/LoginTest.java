package Test;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Utils.DateFun;

public class LoginTest extends BasePage{
	ExtentReports reports;
	
	@Test
	public void testing() {
		test=reports.createTest("QA tools testing");
		browserOpen("chrome");
		appOpen("url");
		HomePage home=new HomePage(driver);
		LoginPage login=new LoginPage(driver);
		LogoutPage logout=new LogoutPage(driver);
		
		home.clickbtn();
		System.out.println("succesfully clicked");
	
		login.loginform();
		logout.test();
		logout.logoutclick();
		
		 pagequit();
		 
	}
	
	@BeforeSuite
	public void report() {
		
		
		String filename=DateFun.datem()+".html";
		
		ExtentSparkReporter extent=new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+filename);
		 reports=new ExtentReports();
		reports.attachReporter(extent);
		reports.setSystemInfo("OS", "windows");
		reports.setSystemInfo("BrowserName", "Chrome");
		reports.setSystemInfo("Build Number", "100.10.23");
		
	}
	
	@AfterSuite
	public void flushreport() {
		reports.flush();
		
	}

}
