package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import Base.BasePage;

public class Screenshot extends BasePage {
	
	public static void takescreen() {
		String pngfile=DateFun.datem()+".png";
		TakesScreenshot take=(TakesScreenshot)driver;
		File src=take.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"\\screenshot\\"+pngfile);
		try {
			FileUtils.copyFile(src, dest);
			test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\screenshot\\"+pngfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
