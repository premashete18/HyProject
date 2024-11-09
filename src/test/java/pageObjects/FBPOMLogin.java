package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FBPOMLogin 
{
	 
		  WebDriver driver; // login veriable 
		  public  FBPOMLogin(WebDriver driver)  // paramertrize constructor
		  {
			this.driver= driver;  // driver initilazation
		  }
	     
		  
		  By create=By.xpath("//a[text()='Create new account']");
		  By fname= By.name("firstname");
		  By Lname= By.name("lastname");
		  By dropdown=By.name("birthday_day");
		  By dropmonth=By.xpath("//*[@id='month']");
		  By dropyear=By.id("year");
		  By gender=By.xpath("//label[text()='Male']");
		  By mobile=By.xpath("div[text()='Mobile number or email address']");
		  By pass=By.xpath("//div[text()='New password']");

	  

		  public void login(String u , String p, String day, String month, String year) // called paramerizes here 
		  {
			  driver.findElement(create).click();
			  driver.findElement(fname).sendKeys(u);
			  driver.findElement(Lname).sendKeys(p);
			  
			  Select selectDay = new Select(driver.findElement(dropdown));
		      selectDay.selectByIndex(1);
		      
		      Select selectmonth=new Select(driver.findElement(dropmonth));
			  selectmonth.selectByIndex(2);
			  
			  Select seleyear=new Select(driver.findElement(dropyear));
			  seleyear.selectByIndex(2);
			  
			  /*WebElement  day=driver.findElement(By.id(dropdown));
			    Select s = new Select(day);
			    s.selectByIndex(1);
			    
			  
			
		  }
		  
		 /* public void selectDay(String day) 
		  {
		        Select selectDay = new Select(driver.findElement(dropdown));
		        selectDay.selectByVisibleText(day);
		        
		        
		  }
		  
		  public void selectmonth(String month)
		  {
			  Select selectmonth=new Select(driver.findElement(dropmonth));
			  selectmonth.selectByValue(month);
		  }
		  */
		  
}
}



