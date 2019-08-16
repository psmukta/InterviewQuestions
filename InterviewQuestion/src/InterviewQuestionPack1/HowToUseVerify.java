package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class HowToUseVerify {
	WebDriver driver;
	
	//@Test
	public void TextVerify() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		WebElement Text=driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div[1]/div[1]/div[2]/span[1]"));
		
		String Actualtext=Text.getText();
		System.out.println("ActualText is :"+Actualtext);
		String Expectedtext="See photos and update";
		
		if(Actualtext==Expectedtext) {
			System.out.println("Text is present  : "+Actualtext);
			
		}
		else {
			System.out.println("Text is not correct");
		}
		driver.close();
		
	}
	@Test
	public void TextVerifyByHardAssert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		WebElement Text=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/div[1]/div[2]/span[1]"));
		//its work
		
		String Actualtext=Text.getText();
		System.out.println("ActualText is :"+Actualtext);
		String Expectedtext="See photos and updates";
		Assert.assertEquals(Actualtext, Expectedtext);
		driver.close();
		
	}
	
	//@Test
	public void TextVerifyBySoftAssert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		WebElement Text=driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div[1]/div[1]/div[2]/span[1]"));
		
		String Actualtext=Text.getText();
		System.out.println("ActualText is :"+Actualtext);
		String Expectedtext="See photos and update";
		SoftAssert SOA=new SoftAssert();
		SOA.assertEquals(Actualtext,Expectedtext);
		driver.close();
		SOA.assertAll();
		
	
	}

	

}
