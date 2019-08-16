package InterviewQuestionPack1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToCountLink {
		WebDriver driver;
		
		@BeforeTest
		public void SetUp() {
		System.setProperty("webdriver.chrome.driver","C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(500,700));
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		//driver.get("https://www.capitalone.com/");
		driver.get("https://www.mtb.com/banking?ch=psg&cid=psg|2019brand|174511067687|google|28238075849|kwd-301870613715&matchtype=e&adid=174511067687&addisttype=g&gclid=EAIaIQobChMIwPqrpY2K4AIVgUwNCh1z5wOdEAAYASAAEgLfmPD_BwE");
	}
	//@Test
	public void LinkCount() {
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int totalLinks=links.size();
		System.out.println("Total links are: "+totalLinks);
		
		for(int i=0; i<totalLinks; i++) {
			String url=links.get(i).getAttribute("href");
			System.out.println(i+". "+links.get(i).getText()+"---"+url);
			
		}
		
	}
	@Test      //M&T bank
	public void countMenu() {
		List<WebElement>Menu=driver.findElements(By.xpath(".//*[@id='nav-primary-collapse-1']/ul/li"));
		int TotalMenu=Menu.size();
		for(int i=1;i<TotalMenu;i++) {
			String menu=Menu.get(i).getAttribute("value");
			System.out.println(i+"."+Menu.get(i).getText());
		}
			
	}
}
