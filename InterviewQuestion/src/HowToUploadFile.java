import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToUploadFile {
	WebDriver driver;
	@Test
	public void FileUpload() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/Upload.html");
		driver.findElement(By.xpath("html/body/input")).sendKeys("C:\\ITTraining\\FacebookData.xlsx");
	}
}
