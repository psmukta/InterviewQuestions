package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToGetTextBoxSize {
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
	public void GetTextBoxSize() {
		WebElement SearchBox=driver.findElement(By.name("q"));
		int height=SearchBox.getSize().getHeight();
		int width=SearchBox.getSize().getWidth();
		System.out.println("SearchBox height is : "+height +"\n " + "SearchBox widyh is :"+ width);
	}
	

}
