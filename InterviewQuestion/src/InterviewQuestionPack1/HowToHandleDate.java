package InterviewQuestionPack1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToHandleDate {
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
	public void datehandle() {
		//driver.get("file:///C:/Users/tanvi/Desktop/date.html");
		//driver.findElement(By.xpath("/html/body/input[1]")).sendKeys("08/15/2018");
		driver.get("https://www.expedia.com/");
		driver.findElement(By.xpath("//*[@id=\"package-departing-hp-package\"]")).click();
		List<WebElement>DDate=driver.findElements(By.xpath(".//*[@id='package-departing-wrapper-hp-package']/div/div/div[2]/table/tbody/tr/td"));
		
		for(WebElement ele : DDate) {
			String dateText=ele.getText();
			if(dateText.contains("15")) {
				ele.click();
				break;
			  }
		}
		driver.findElement(By.xpath(".//*[@id='package-returning-hp-package']")).click();
		List<WebElement>RDate=driver.findElements(By.xpath(".//*[@id='package-returning-wrapper-hp-package']/div/div/div[2]/table/tbody/tr/td"));
		
		for(WebElement ele : RDate) {
			String dateText=ele.getText();
			if(dateText.contains("25")) {
				ele.click();
				break;
			}
		}
	}
}