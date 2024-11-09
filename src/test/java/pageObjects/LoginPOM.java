package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


  public class LoginPOM
  {
  WebDriver driver; // login veriable 
  public  LoginPOM(WebDriver driver)  // paramertrize constructor
  {
	this.driver= driver;  // driver initilazation
  }


	 By unm= By.id("email");
	 By pwd= By.id("pass");
	 By log=By.xpath("//button[@name='login']");
	 By Forgot=By.linkText("Forgotten password?");
	 
	 // for created account
	 By create= By.xpath("//a[text()='Create new account']");
     By fname= By.name("firstname");
     By Lname= By.name("lastname");
     By day =By.id("day");
     
  /*   WebElement dayElement = driver.findElement(dayDropdown);
     Select selectDay = new Select(dayElement);
     selectDay.selectByVisibleText("10");

*/




  public void login(String u , String p) // called paramerizes here 
  {
	  driver.findElement(unm).sendKeys(u);
	  driver.findElement(pwd).sendKeys(p);
	  driver.findElement(log).click();
  }
  
  public void password( String p) // called paramerizes here 
  {
	  driver.findElement(pwd).sendKeys(p);
  }
  
  public void forget() // called paramerizes here 
  {
	  driver.findElement(Forgot).click();
  }
  
  public void creat(String F,String L) // called paramerizes here 
  {
	  driver.findElement(create).click();
	  driver.findElement(fname).sendKeys(F);
	  driver.findElement(Lname).sendKeys(F);
	  
  }
  
  public void selectDay(String day) // called paramerizes here 
  {
	  

      Select selectDay = new Select(driver.findElement(By.id(day)));
	  selectDay.selectByVisibleText(day);
  }
  
}