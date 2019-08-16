package InterviewQuestionPack1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToHighlightAnyWebElement {
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
	
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/practice.html");
		}
	@Test
	public void TakeScreenShot() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"FN\"]")).sendKeys("Parveen");
		WebElement LastName=driver.findElement(By.xpath("//*[@id=\"LN\"]"));
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].style.border='2px solid red'", LastName);
		
		driver.findElement(By.xpath("//*[@id=\"L\"]")).sendKeys("Sultana");
			Thread.sleep(4000);
		
	}
	@AfterMethod
	public void ScreenShot(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:\\ITTraining\\OurWebsite.jpg"));
		}
	}
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
	}



}
