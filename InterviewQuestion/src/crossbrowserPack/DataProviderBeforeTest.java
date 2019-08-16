package crossbrowserPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderBeforeTest {
	WebDriver driver;
	@Test(dataProviderClass=DataProviderData.class,dataProvider="MultiBrowserData")
	public void setUp(String browserName) {
		
			if(browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
				driver=new ChromeDriver();
				System.out.println("Chrome browser is running");
			}
			else if(browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\ITTraining\\AllDriver\\geckodriver.exe");
				driver=new FirefoxDriver();
				System.out.println("Firefox browser is running");
			}
			
			else if(browserName.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\ITTraining\\AllDriver\\MicrosoftWebDriver.exe");
				driver=new EdgeDriver();
				System.out.println("Edge browser is running");
			}
			else{
				System.out.println("wrong browser");
			}
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
	
	
	
		driver.findElement(By.name("email")).sendKeys("psmukta@yahoo.com");
		driver.findElement(By.name("pass")).sendKeys("zunairahi");
		
		driver.findElement(By.id("u_0_2")).submit();
		driver.close();
	}
	
	

}
