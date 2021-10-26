package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCher {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();
		 driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 //Frame1
		 WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));			
		 driver.switchTo().frame(frame1);			
		 driver.findElement(By.xpath("//b[@id='topic']/following::input[1]")).sendKeys("Frames");
		 //Frame2
		 WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));			
		driver.switchTo().frame(frame3);			
		WebElement WeleCheck = driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following::input[1]"));
		WeleCheck.click();
		//Frame3
		driver.switchTo().defaultContent();		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));		
		driver.switchTo().frame(frame2);		
		WebElement eleSource = driver.findElement(By.xpath("//select[@id='animals']"));	
		//eleSource.click();
		Select dropDown=new Select(eleSource);
		dropDown.selectByIndex(2);	

	}

}
