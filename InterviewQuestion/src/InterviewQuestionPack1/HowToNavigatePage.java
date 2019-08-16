package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToNavigatePage {
	WebDriver driver;
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/ITTraining/OurWebSite.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

}
	@Test
	public void PageNavigate() {
		driver.findElement(By.partialLinkText("Facebook")).click();
		System.out.println("Facebook Title is "+driver.getTitle());
		driver.navigate().back();
		System.out.println("OurWebSite current url is"+driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println("Facebook current Url"+driver.getCurrentUrl());
		driver.navigate().refresh();
		//driver.findElement(By.partialLinkText("Google")).click();
	}
}

