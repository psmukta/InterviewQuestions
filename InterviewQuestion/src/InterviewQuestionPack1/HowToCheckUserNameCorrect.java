package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToCheckUserNameCorrect {
	WebDriver driver;
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

}
	@Test
	public void CheckUserName() {
		WebElement username=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		username.sendKeys("psmukta@yahoo.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("areebi");;
		driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).submit();
		String ExpectedUsername="psmukta@yahoo.com";
		String ActualUsername=username.getAttribute("value");
		Assert.assertEquals(ActualUsername, ExpectedUsername);
		if(ActualUsername==ExpectedUsername) {
		System.out.println("user name is correct");
		}
		else{
			System.out.println("user name is not correct");
			
		}
		
	}
}
