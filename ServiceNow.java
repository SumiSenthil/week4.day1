package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://dev113545.service-now.com");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		 WebElement homepage = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(homepage);
		 driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");			
		 driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Sl0gaItSFt3A");				
		 driver.findElement(By.id("sysverb_login")).click();
		 driver.findElement(By.xpath("//label[text()='Filter navigator']/following::input[1]")).sendKeys("Incidents");
		 driver.findElement(By.xpath("//span[text()='Incident']/following::div[text()='All'][1]")).click();
		 WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);			
		driver.findElement(By.xpath("//button[text()='New']")).click();		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement caller = driver.findElement(By.xpath("//span[text()='Caller']/following::input[@id='sys_display.incident.caller_id']"));		
		wait.until(ExpectedConditions.visibilityOf(caller));		
		caller.sendKeys("System Administrator");		
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//span[text()='Caller']/following::input[@id='incident.short_description']")).sendKeys("Incident creation");		
		String incidentNumber = driver.findElement(By.xpath("//span[text()='Number']/following::input[@id='incident.number']")).getAttribute("value");		
		System.out.println("Incident number"+incidentNumber);		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();		
		driver.findElement(By.xpath("//span[text()='Press Enter from within the input to submit the search.']/following::input[1]")).sendKeys(incidentNumber);		
		String text = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]/a")).getText();		
		System.out.println("Received Incident number" + text);		
		if(incidentNumber.equals(text))
		{
			System.out.println("Incidents are same");
		}
		else
		{
			System.out.println("Incidents are different");
		}
		File src = driver.getScreenshotAs(OutputType.FILE);		
		File dst= new File("./snap/servicenow.png");		
		FileUtils.copyFile(src, dst);				

	}

}
