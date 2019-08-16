package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToHandleIIFrame {
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
	
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
		}
	@Test(priority=0)
	public void IFrameHandling() {
		//Driver switch Iframe
		//driver.switchTo().frame(0);
		//driver.switchTo().frame("LoginForm");
		driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='fullbody']/iframe[1]")));
		
		driver.findElement(By.xpath("html/body/center/form/table/tbody/tr[1]/td[2]/input")).sendKeys("Parveen");
		
	}
	@Test(priority=1)
	public void HandlingSecondFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("Download")).click();
		driver.findElement(By.xpath(".//*[@id='mainContent']/table[1]/tbody/tr[1]/td[4]/a")).click();
	}
	
	
	
	
	//@Test(priority=1)
	public void AlertHandling() throws InterruptedException {
		//driver switch to main frame
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='btnConfirm']")).click();
		Thread.sleep(3000);
		Alert alt=driver.switchTo().alert();
		alt.accept();
		//alt.dismiss();
		System.out.println(alt.getText());
	}
	
}
