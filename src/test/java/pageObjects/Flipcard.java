package pageObjects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipcard {

	public static void main(String[] args) throws InterruptedException, IOException {

		
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Login")).click();
        WebElement electonic=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[1]"));
        Actions action = new Actions(driver);
        action.clickAndHold(electonic).build().perform();
       
      //  System.out.println("Prema");
        driver.findElement(By.name("q")).sendKeys("mobile");
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
        Thread.sleep(4000);
        
        // xpath for list of all price and name product
        List<WebElement> products= driver.findElements(By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]"));
        
        
        
        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet sh= wb.createSheet("Mobile-data"); // sheet name in excel sheet i.e Mobile-data
        int rownum=0;  // inti row number 
         
        List<WebElement> name=List.of(); // list of name of the produce and price
        List<WebElement> price=List.of();
        
        
        Row row=null;
        for(WebElement product :products) // inhance 
        {
        	name = product.findElements(By.xpath("//div[@class=\"KzDlHZ\"]"));
        	price = product.findElements(By.xpath("//div[@class = 'Nx9bqj _4b5DiR']"));

        	
        }
        
        for(int i=0; i<name.size(); i++) 
        {
        	String item = name.get(i).getText(); 
        	String pp = price.get(i).getText();
        	
        	row = sh.createRow(rownum);
        	row.createCell(0).setCellValue(item);
        	row.createCell(1).setCellValue(pp);
        	
        	System.out.println( item + " - " + pp);
        	
        }

        FileOutputStream os = new FileOutputStream("Phone.xlsx");
        wb.write(os);

        		
        		Thread.sleep(4000);
        		driver.close();

        	}


        

		
	}


