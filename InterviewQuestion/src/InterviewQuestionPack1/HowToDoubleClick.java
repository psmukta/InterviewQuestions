package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToDoubleClick  {
	WebDriver driver;

	@BeforeTest(alwaysRun=true)
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\ITTraining\\AllDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
		}
	@Test(groups= {"Double"})
	public void DoubleClick() throws InterruptedException {
		/*System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");*/
		
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("window.scrollBy(0, 1500)");
		Thread.sleep(5000);
		WebElement DL=driver.findElement(By.xpath("/html/body/div[2]/button[1]"));
		Actions act=new Actions(driver);
		act.doubleClick(DL).build().perform();
	}
	@Test(groups= {"CSS"})
    public void GetCSSProperty() {
	String fontname=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
			.getCssValue("font-family");
	System.out.println("Font name is : "+fontname);
	}
	@Test(groups= {"CSS"})
	 public void GetCSSProperty1() {
	String fontsize=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
			.getCssValue("font-size");
	System.out.println("Font size is "+fontsize);
	}
	@Test(groups= {"CSS"})
	 public void GetCSSProperty2() {
	String fontcolor=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
			.getCssValue("color");
	System.out.println("Font color is : "+fontcolor);
	}
	@Test(groups= {"CSS"})
	 public void GetCSSProperty3() {
	String fontweight=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
			.getCssValue("font-weight");
	System.out.println("Font weight is : "+fontweight);
	}
	@Test(groups= {"CSS"})
	 public void GetCSSProperty4() {
	String backgroundcolor=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
			.getCssValue("background-color");
	System.out.println("Font backgroundcolor is : "+backgroundcolor);
	}
	@Test(groups= {"CSS"})
	 public void GetCSSProperty5() {
	String textdecoration=driver.findElement(By.xpath(".//*[@id='linkForm']/header/marquee/font"))
			.getCssValue("text-decoration");
	System.out.println("Font textdecoration is : "+textdecoration);
	
	}
	@AfterTest(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}

}
