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

import pageObjects.LoginPOM;

public class VerifyLoginPOM
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
  @Test(priority=1)
  public void login()
  {
	  pageObjects.LoginPOM p= new pageObjects.LoginPOM(driver);
		p.login("Prema", "Prema@123");
		p.password("Prema111");
		Assert.assertEquals(0, 0);
		//Assert.assertEquals(0, 0);
  }
  
  
  @Test(priority=2)
  public void forgetpass()
  {
	  pageObjects.LoginPOM p= new pageObjects.LoginPOM(driver);
		p.forget();
		Assert.assertEquals(0, 1);
		//Assert.assertEquals(0, 0);
  }
  
  @Test(priority=3)
  public void create() // para
  {
	    pageObjects.LoginPOM p= new pageObjects.LoginPOM(driver);
		p.creat("Prema", "Shete");
	    
	    


	   //  Select selectDay = new Select((WebElement) day);

		
		
	/*List<WebElement> all=s.getOptions();

		
		for(int i=0 ; i<all.size(); i++)

		{
			System.out.println(all.get(i).getText());
			if(all.get(i).getText().matches("10"))
            {
				all.get(i).click();
				break;
            }
		}

	*/
		//Assert.assertEquals(0, 0);
  } 
  @Test(priority=4)
  public void dropdown() // para
  {
	  LoginPOM dp= new LoginPOM(driver);
	  dp.selectDay("7");
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
		File y = new File("src\\test\\java\\utilities"+time+ ".png");
		FileUtils.copyFile(x, y);
	}
	else
	{
		driver.quit();
	}
}
}

