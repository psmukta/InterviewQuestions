package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ManualToAutomation {
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
	public void VerifyTitle() {
		
		String ActualTitle=driver.getTitle();
		System.out.println("Title is:"+ActualTitle);
		String ExpectedTitle="Super Tech IT Solution";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
		
		
		
		@Test
		public void VerifyScrollText() {
		String ActualScrollText=driver.findElement(By.xpath("html/body/header/marquee/font")).getText();
		System.out.println("Scroll Text is:"+ActualScrollText);
		String ExpectedScrollText="Welcome to our IT Training Center. We are giving Traning on real project of Software Testing. Selenium with Java , TestNg, JUnit for functional Testing ** Cucumber for BDD Testing ** SoapUI for Webservice Testing ** MS SQL Server, MySql, Oracle Database for Backend Testing ** Appium for Mobile Testing ** Jmeter for Performance Testing**";
		Assert.assertEquals(ActualScrollText, ExpectedScrollText);
		
		
	}
}
