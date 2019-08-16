package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowCanGetCurrentURL {
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\ITTraining\\AllDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	@Test
	public void GetCurrentURL() {
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
		String CURL=driver.getCurrentUrl();
		
		System.out.println("Current URL is: "+CURL);	
	}

}
