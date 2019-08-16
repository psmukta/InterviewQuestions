package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToPerformDragAndDrop {
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/WebSite/JavaScript/DragAndDrop.html");

			}
	@Test
	public void DragAndDroptest() {
		Actions act=new Actions(driver);
		WebElement Source=driver.findElement(By.xpath("//*[@id=\"drag1\"]"));
		WebElement Destination=driver.findElement(By.xpath("//*[@id=\"div2\"]"));
		act.clickAndHold(Source).moveToElement(Destination).release(Destination).build().perform();
		System.out.println("Drag and Drop perform successfully");
	}

}
