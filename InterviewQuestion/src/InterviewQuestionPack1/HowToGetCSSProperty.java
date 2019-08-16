package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToGetCSSProperty {
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
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
	}
		@Test
	    public void GetCSSProperty() {
		String fontname=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
				.getCssValue("font-family");
		System.out.println("Font name is : "+fontname);
		String fontsize=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
				.getCssValue("font-size");
		System.out.println("Font size is "+fontsize);
		String fontcolor=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
				.getCssValue("color");
		System.out.println("Font color is : "+fontcolor);
		String fontweight=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
				.getCssValue("font-weight");
		System.out.println("Font weight is : "+fontweight);
		String backgroundcolor=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
				.getCssValue("background-color");
		System.out.println("Font backgroundcolor is : "+backgroundcolor);
		String textdecoration=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
				.getCssValue("text-decoration");
		System.out.println("Font textdecoration is : "+textdecoration);

		
		
	}
		@AfterTest
		public void TearDown() {
			driver.close();
		}
		
	

}
