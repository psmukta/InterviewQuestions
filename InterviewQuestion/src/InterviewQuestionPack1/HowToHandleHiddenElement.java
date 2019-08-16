package InterviewQuestionPack1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToHandleHiddenElement {
	WebDriver driver;
	@Test
	public void HiddenElement() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	Thread.sleep(4000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("file:///C:/ITTraining/OurWebSite.html");
	List<WebElement>radio=driver.findElements(By.xpath(".//*[@id='ml']"));
	int count=radio.size();
     System.out.println("total radio  " + count);
     for(int i=0; i<count;i++) {
    	WebElement ele=radio.get(i);
    	int x=ele.getLocation().getX();
    	if(x!=0) {
    		ele.click();
    		break;
    	}
     }
}
}