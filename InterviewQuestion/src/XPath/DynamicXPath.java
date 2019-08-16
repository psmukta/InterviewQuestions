package XPath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicXPath {
           WebDriver driver;
           @BeforeTest
       	public void OpenBrowser() throws InterruptedException {
       		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
       		driver=new ChromeDriver();
       		Thread.sleep(4000);
       		driver.manage().window().maximize();
       		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
       		driver.get("https://www.facebook.com/");
       		}
           @Test
           public void DynamicPath() {
        	   
        	   
        	 //Dynamic X-path by contains() and text() 
        	   //String text=driver.findElement(By.xpath(".//*[contains(text(), 'always')]")).getText();
        	   String text=driver.findElement(By.xpath(".//*[contains(text(), 'always will')]")).getText();

        	   System.out.println("Text is : "+text);
        	   
        	   //Dynamic X-path by starts-with() using name attribute
        	   driver.findElement(By.xpath("//*[starts-with(@name, 'firs')]")).sendKeys("Parveen");
        	   
        	   //Dynamic X-path by contains() using name attribute
        	   
        	   driver.findElement(By.xpath("//*[contains(@name, 'last')]")).sendKeys("Sultana");
        	   //basic x path
        	  driver.findElement(By.xpath(".//*[@id='u_0_u']")).click();
        	   
        	   String text1=driver.findElement(By.xpath(".//*[starts-with(@class,'mbs _3ma _6n _6s _6v')]")).getText();
        	   
        	   
        	   
        	   
        	   
        	   
        	   
           }
}
