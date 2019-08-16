package InterviewQuestionPack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowCanCheckWebElementExistOrNot {
WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
	}
	@Test
	public void VarifyWebElementExistOrNot() {
		WebElement LatestNews  =driver.findElement(By.xpath(".//*[@id='fullbody']/h3"));
		boolean LN=LatestNews.isDisplayed();
		if(LN==true) {
			System.out.println("Element is pressent");
			
		}
		else {
			System.out.println("Element is not present");
		}

}
}
