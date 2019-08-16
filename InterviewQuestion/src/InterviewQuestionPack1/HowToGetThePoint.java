package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToGetThePoint {
	WebDriver driver;
	@Test
	public void GetPoint() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	Thread.sleep(4000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    driver.get("file:///C:/ITTraining/Upload.html");
    Point p=driver.findElement(By.xpath("html/body/input[2]")).getLocation();
    
    int X=p.getX();
    int Y=p.getY();
    System.out.println("Point of WebElement : "+X+"," +Y);
    
}
}