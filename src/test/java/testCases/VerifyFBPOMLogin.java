package testCases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class VerifyFBPOMLogin 
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
  @Test()
  public void login() 
  {
	  pageObjects.FBPOMLogin p= new pageObjects.FBPOMLogin(driver);
	  p.login("Prema", "shete", "2", "2", "3");
	  Assert.assertEquals(0, 0);
  }
  
  
  
  @AfterMethod
  public void close(ITestResult r) throws IOException
  {
	 int actual=  r.getStatus();
	 int expect=  ITestResult.FAILURE;
	 
	if(actual == expect )
	{
		Date d= new Date();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String time= df.format(d);
		
		File x = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		File y = new File("src\\Reports\\screen"+time+ ".png");
		FileUtils.copyFile(x, y);
	}
	else
	{
		driver.close();
	}
}
}
