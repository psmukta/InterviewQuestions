package InterviewQuestionPack1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class IfTestCaseFailThenTakeScreenShotByITest2 {
	
	WebDriver driver;
	
/*If Two test fail and take screenshot*/
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/practice.html");
		Thread.sleep(4000);
		}
	@Test(priority=0)
	public void TakeScreenShot() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//*[@id=\"FN\"]")).sendKeys("Parveen");
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].style.border='2px solid red'", driver.findElement(By.xpath("//*[@id=\"LN\"]")));
		driver.findElement(By.xpath("//*[@id=\"L\"]")).sendKeys("Sultana");
		Thread.sleep(4000);
		
	}
	@Test(priority=1)
	public void ClickOnFemale() {
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].style.border='2px solid red'", driver.findElement(By.xpath("html/body/input[6]")));
		driver.findElement(By.xpath("html/d/input[6]")).click();
		
		
	}
	
	@AfterMethod
	public void ScreenShot(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:\\ITTraining\\"+sdf.format(d)+".jpg"));
		}
	}
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
	}


}
