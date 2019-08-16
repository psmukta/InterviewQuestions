package InterviewQuestionPack1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IfTestCaseFailThenTakeAScreenShot {
	
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
	
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
	@Test
	public void TakeScreenShot() throws InterruptedException, IOException {
		try {
			
		driver.get("file:///C:/ITTraining/practice.html");
		driver.findElement(By.xpath("//*[@id=\"FN\"]")).sendKeys("Parveen");
		driver.findElement(By.xpath("//*[@id=\"L\"]")).sendKeys("Sultana");
		
		}catch(Exception e) {
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:\\ITTraining\\OurWebsite.jpg"));
		}
		Thread.sleep(4000);
		
	}
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
	}



}
/*here consul will show that test is pass but actually test is fail and will get screenshot.Because here try ...catch action work successfully.If there is any error in try...catch can handle it and shows pass in console.  */