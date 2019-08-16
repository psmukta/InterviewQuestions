package crossbrowserPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserByDataProvider {
	WebDriver driver;
	
	@Test(dataProvider="MultiBrowserData")
	public void setup(String browserName) {
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
		else if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\ITTraining\\AllDriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			System.out.println("IE browser is running");
		}
		else {
			System.out.println("Wrong browser");
		}
		
		driver.manage().window().maximize();
	
		driver.get("https://www.facebook.com/");

		driver.findElement(By.name("firstname")).sendKeys("Parveen");
		driver.findElement(By.name("lastname")).sendKeys("Sultana");
		driver.findElement(By.name("reg_email__")).sendKeys("sultana@yahoo.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("sultana@yahoo.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("sul2123");
		driver.findElement(By.id("month")).sendKeys("May");
		driver.findElement(By.id("day")).sendKeys("20");
		driver.findElement(By.id("year")).sendKeys("1990");

		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("u_0_9"))));
		
		driver.findElement(By.id("u_0_9")).click();
		driver.close();

		/*if(Sex.equalsIgnoreCase("Male")){
			driver.findElement(By.id("u_0_a")).click();
		}
		else if(Sex.equalsIgnoreCase("Female")){
			driver.findElement(By.id("u_0_9")).click();
		}		
		else{
			System.out.println("Wrong Object Type");

		}*/
	}
	/*@AfterTest
	public void closeBrowser(){
		driver.close();
		//driver.quit();
	}*/
	@DataProvider(name="MultiBrowserData")
	public Object[][] getData(){
		return new Object[][] {
			{"Chrome"},
			{"Firefox"},
			{"Edge"},
			{"IE"}
			
		};
	}

}

