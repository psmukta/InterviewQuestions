import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsingWithoutSendkeys {
	WebDriver driver;
	@BeforeTest
	public void SetUp() {
	System.setProperty("webdriver.chrome.driver","C:\\ITTraining\\AllDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().setSize(new Dimension(500,700));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
	@Test
	public void EnterWithoutSendkeys() throws InterruptedException {
		driver.get("file:///C:/ITTraining/OurWebSite.html");
		//1.way
		WebElement FN=driver.findElement(By.name("FName"));
	    JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='Parveen'",FN);
		Thread.sleep(3000);
		//2nd way
		//driver.findElement(By.id("FN")).clear();
		//jse.executeScript("document.getElementById('FN').value='Parveen'");
		jse.executeScript("document.getElementById('LN').value='Sultana'");
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0,-2000)");
		JOptionPane.showMessageDialog(null, "scroll up and down successfully");
	}

}
