package AutoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadByAutoIT {
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
	public void FileUpload() throws IOException {
		driver.get("file:///C:/ITTraining/Upload.html");
		driver.findElement(By.xpath("html/body/input[1]")).click();
		Runtime.getRuntime().exec("C:\\Users\\tanvi\\Desktop\\AutoItScript\\FileUpLoad.exe");
		
	}
}
