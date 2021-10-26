package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup(); 
		 ChromeDriver driver=new ChromeDriver();
		 //MAXIMISE WINDOW
		 driver.manage().window().maximize();		 
		 driver.get("http://leafground.com/pages/frame.html");	
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();			
			WebElement frame1 = driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));			
			driver.switchTo().frame(frame1);			
			driver.findElement(By.id("Click")).click();	
			//capture screenshot		
			 File src = driver.getScreenshotAs(OutputType.FILE);
			 File dst = new File("./snaps/frame.png");
			 FileUtils.copyFile(src, dst);			 
			driver.switchTo().defaultContent();			
			int totalFrames = driver.findElements(By.tagName("iframe")).size();			
			System.out.println("No of frames "+totalFrames);
	}

}
