package InterviewQuestionPack1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToGetSearchElement {
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();

		//System.setProperty("webdriver.gecko.driver", "C:\\ITTraining\\AllDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();//should be latest version
		//System.setProperty("webdriver.edge.driver", "C:\\ITTraining\\AllDriver\\MicrosoftWebDriver.exe");
		//driver=new EdgeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(700,700));
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	@Test
	public void SearchElement() {
	driver.findElement(By.name("q")).sendKeys("selenium");
	List<WebElement>Sele=driver.findElements(By.xpath(".//*[@id='tsf']/div[2]/div/div[2]/div[2]/ul/li"));
	System.out.println("Total Elements are "+ Sele.size());
	for(int i=0;i<Sele.size();i++) {
		System.out.println(i+". "+Sele.get(i).getText());
		if(Sele.get(i).getText().contains("python")) {
			Sele.get(i).click();
			break;
		}
		
	}
	
	}
	@AfterTest
	public void TearDown() {
		driver.close();
	}
}
