package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowcanHandleSubMenu {
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\ITTraining\\AllDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(700,700));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
		}
	
	//@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	//@Test
	public void SubMenuHandling() throws InterruptedException {
		
		WebElement SM=driver.findElement(By.linkText("Social Media"));
		Actions act=new Actions(driver);
		 act.moveToElement(SM).build().perform();
		
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Go")).click();
		
		
		
		
		//open new google tab
	}
	@Test
	public void SubmenuHandling1() throws InterruptedException {
		
		WebElement News=driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[3]/a"));
		Actions act=new Actions(driver);
		act.moveToElement(News).build().perform();
		WebElement HNews=driver.findElement(By.linkText("Hindi News"));
		Actions act1=new Actions(driver);
		act1.moveToElement(HNews).build().perform();
		Thread.sleep(3000);
		Actions act2=new Actions(driver);
		act2.moveToElement(driver.findElement(By.partialLinkText("India P"))).build().perform();
		
		
	}

}
