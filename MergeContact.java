package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("http://leaftaps.com/opentaps/control/main");
		 //Login into Link
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  WebElement eleUsername = driver.findElement(By.name("USERNAME"));
		  eleUsername.sendKeys("DemoSalesManager");
		  WebElement elePassword = driver.findElement(By.name("PASSWORD"));
		  elePassword.sendKeys("crmsfa");
		  Thread.sleep(1000);		  
		  WebElement eleLogin =driver.findElement(By.className("decorativeSubmit"));
		  eleLogin.click();
		  Thread.sleep(1000);
		  //Click on CRM Link
		  WebElement eleSubmit =driver.findElement(By.linkText("CRM/SFA"));
		  eleSubmit.click();
		  Thread.sleep(1000);
		  //create contact
		  driver.findElement(By.linkText("Contacts")).click();
		  driver.findElement(By.linkText("Merge Contacts")).click();
		  
		  driver.findElement(By.xpath("//img[@alt='Lookup']")).click();		 	
			Set<String> windowHandles = driver.getWindowHandles();			
			List<String> lst= new ArrayList<String>(windowHandles);				
			driver.switchTo().window(lst.get(1));			
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();			
					
			driver.switchTo().window(lst.get(0));	
			
			 driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();		 	
				Set<String> windowHandle = driver.getWindowHandles();			
				List<String> lst3= new ArrayList<String>(windowHandle);				
				driver.switchTo().window(lst3.get(1));			
				driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();							
				driver.switchTo().window(lst3.get(0));				
					
			driver.findElement(By.xpath("//a[text()='Merge']")).click();			
			Alert alert = driver.switchTo().alert();			
			alert.accept();
			System.out.println("Title of Page:"+driver.getTitle());
	}

}
