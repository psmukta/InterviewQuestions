package WeatherPractice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TemperatureConvertAndVerify {
	WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\Chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS );
		driver.get("https://forecast.weather.gov/MapClick.php?lat=40.72796340000008&lon=-73.75704659999997#.W7wZhWhKjIU");
	}
	
	
	@Test(priority=1)
		public void varifyTempareture() {
		WebElement ele=driver.findElement(By.xpath(".//*[@id='current_conditions-summary']/p[2]"));
		String temp=ele.getText();
		System.out.println("Faren temp=> "+temp);
		int actualFarenToCenConv = tempConvert(temp);
		
		WebElement ele1=driver.findElement(By.xpath(".//*[@id='current_conditions-summary']/p[3]"));
		String celsiustemp=ele1.getText();
		System.out.println("celsius temp=> "+celsiustemp);
		celsiustemp = celsiustemp.replaceAll("[^0-9]", "");
		int expectedResultinCels = Integer.parseInt(celsiustemp);
		Assert.assertEquals(actualFarenToCenConv, expectedResultinCels);
	}
	
		 int tempConvert(String text) {
		String temp = text.replaceAll("[^0-9]", "");
		int fahr = Integer.parseInt(temp);
		int cel= (int) ((5*(fahr -32))/9);
		System.out.println("Today temperature is=> "+cel);
		return cel;
}

		@AfterTest
		public void teardown() {
		driver.close();
	}



}
