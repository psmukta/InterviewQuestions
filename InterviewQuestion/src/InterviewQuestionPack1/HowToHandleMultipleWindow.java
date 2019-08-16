package InterviewQuestionPack1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToHandleMultipleWindow {
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	   driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
	}
	@Test
	public void WindowHandling() throws InterruptedException {
		
		
		
			WebElement SM=driver.findElement(By.linkText("Social Media"));
			Actions act=new Actions(driver);
			act.moveToElement(SM).build().perform();
			driver.findElement(By.partialLinkText("Go")).click();
			
			
			String mainwindow=driver.getWindowHandle();	
		Set<String>childwindow=driver.getWindowHandles();
		for(String child:childwindow) {
			driver.switchTo().window(child);
		}
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
		
		
		driver.switchTo().window(mainwindow);
		
		
		driver.findElement(By.xpath(".//*[@id='form2']/input[1]")).sendKeys("Parveen");
		
	}
}
