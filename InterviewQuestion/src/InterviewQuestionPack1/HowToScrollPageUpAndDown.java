package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToScrollPageUpAndDown {
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
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
		}
	
	//@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	@Test
	public void GetScrollUpAndDown() throws InterruptedException {
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(0, 2300)");//`0 means horizontal scroll
		Thread.sleep(5000);
		
		jse.executeScript("window.scrollBy(0, -2300)");
	}


}
