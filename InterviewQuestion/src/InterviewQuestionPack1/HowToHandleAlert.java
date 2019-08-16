package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToHandleAlert {
WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
	*/
		System.setProperty("webdriver.ie.driver", "C:\\ITTraining\\AllDriver\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
		}
	
	@Test
	public void Showconfirmbox() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='btnConfirm']")).click();
		Thread.sleep(4000);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		System.out.println(alt.getText());
	}
	@Test
	public void Showalert() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='btnAlert']")).click();
		Thread.sleep(4000);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		System.out.println(alt.getText());
		
	}
	
}
