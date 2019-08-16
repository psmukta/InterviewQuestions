package InterviewQuestionPack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameter {
	WebDriver driver;
	@BeforeTest
	public void OpenBrowser(){

		//System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		//driver=new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "C:\\ITTraining\\AllDriver\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		System.out.println("IE browser is running");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	@Parameters({"Fname","Lname","Email","AEmail","Password","Month","Day","Year","Gender"})
	@Test
	public void facebookSignUp( String FN, String LN,String EM, String AEM, String PW, String MN, String DY,String YR, String Sex){

		/*driver.get("https://www.facebook.com/");*/

		driver.findElement(By.name("firstname")).sendKeys(FN);
		driver.findElement(By.name("lastname")).sendKeys(LN);
		driver.findElement(By.name("reg_email__")).sendKeys(EM);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(AEM);
		driver.findElement(By.name("reg_passwd__")).sendKeys(PW);
		driver.findElement(By.id("month")).sendKeys(MN);
		driver.findElement(By.id("day")).sendKeys(DY);
		driver.findElement(By.id("year")).sendKeys(YR);

		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("u_0_9"))));


		if(Sex.equalsIgnoreCase("Male")){
			driver.findElement(By.id("u_0_a")).click();
		}
		else if(Sex.equalsIgnoreCase("Female")){
			driver.findElement(By.id("u_0_9")).click();
		}		
		else{
			System.out.println("Wrong Object Type");

		}
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
		driver.quit();
	}
}