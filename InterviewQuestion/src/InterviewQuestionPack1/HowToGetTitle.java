package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToGetTitle {
 WebDriver driver;

@BeforeTest
public void OpenBrowser() throws InterruptedException {
	//System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
	//driver=new ChromeDriver();
	
	System.setProperty("webdriver.gecko.driver", "C:\\ITTraining\\AllDriver\\geckodriver.exe");
	driver=new FirefoxDriver();
	Thread.sleep(4000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@Test
	public void GetTitle() {
		
		driver.get("file:///C:/ITTraining/OurWeSite.html");
		String title=driver.getTitle();
		System.out.println("Title is : "+title);
	}
	@AfterTest
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}
}
