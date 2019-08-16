package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowtoGetTypedText {
	WebDriver driver;
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\ITTraining\\\\AllDriver\\\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.get("file:///C:/ITTraining/OurWebSite.html");
		
	}
	
	
	@Test
	public void GetTypedText() {
		driver.findElement(By.xpath("html/body/div[2]/input[1]")).sendKeys("Parveen");
		String TypedText=driver.findElement(By.xpath("html/body/div[2]/input[1]")).getAttribute("value");
		System.out.println("Typed Text is"+TypedText);
		String ExpectedText="Parveen";
		Assert.assertEquals(TypedText, ExpectedText);
	}

}
