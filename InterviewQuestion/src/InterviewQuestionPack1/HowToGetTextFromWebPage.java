package InterviewQuestionPack1;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToGetTextFromWebPage{
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\ITTraining\\AllDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	@Test
	public void GetTextTest() {
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"fullbody\"]/h3"));
		String LN=ele.getText();
		System.out.println("Text is :"+LN);
		//LN=Local news
		
		
		
		
	}

}


