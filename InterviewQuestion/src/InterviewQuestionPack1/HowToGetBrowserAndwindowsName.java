package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToGetBrowserAndwindowsName {
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
	@Test(priority=1)
	public void GetBrowserName() {
		Capabilities cap=((RemoteWebDriver)driver).getCapabilities();
		String BrowserName=cap.getBrowserName().toUpperCase();
		System.out.println("Browser Name is :"+BrowserName);
		String BS=cap.getVersion().toString();
		System.out.println("Browser version is " +BS);
	}
	@Test(priority=2)
	public void GetOperatingSystem() {
		String OS=System.getProperty("os.name").toUpperCase();
		System.out.println("Operating System is "+OS);
	}
	@Test
	public void GetUpperAndLowerCase() {
		String mn="parveen sultana";
		System.out.println("My name in UpperCase "+ mn.toUpperCase());
		System.out.println(mn.substring(8).toUpperCase());
		//System.out.println(str.substring(0,6));
	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}
	
	 

}
