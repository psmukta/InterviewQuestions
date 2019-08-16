package WeatherPractice;


import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class TemperatureConvertmain {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\Alldriver\\Chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.weather.gov/");
		driver.findElement(By.id("inputstring")).clear();
		driver.findElement(By.id("inputstring")).sendKeys("11427");
		List<WebElement>list=driver.findElements(By.xpath("html/body/div[7]/div"));
		list.size();
		System.out.println("total list is "+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("11427, Queens Village, NY, USA")) {
				list.get(i).click();
				break;
			}
		}
		
		
		WebElement ele=driver.findElement(By.xpath(".//*[@id='current_conditions-summary']/p[2]"));		
		String temp=ele.getText();

		WebElement ele1=driver.findElement(By.xpath(".//*[@id='current_conditions-summary']/p[3]"));
		String celsiustemp=ele1.getText();
		System.out.println("Fahrenhite temp is "+temp+"\nCelsius temp is "+celsiustemp);

		double actualFarenToCenConv = tempConvert(temp);
		 celsiustemp=celsiustemp.replaceAll("[^0-9]", "");
		double expectedResultinCels = Double.parseDouble(celsiustemp);
		Assert.assertEquals(actualFarenToCenConv, expectedResultinCels);
		
		if(actualFarenToCenConv==expectedResultinCels) {
			System.out.println("Test case pass");
		}
		else {
			System.out.println("Test case fail");
		}
		driver.close();


	}

	public static double tempConvert(String temp) {
		String temp1 = temp.replaceAll("[^0-9]", "");
		double fahr = Double.parseDouble(temp1);
		double cel= (double) ((5*(fahr -32))/9);
		double Cellvl=Math.round(cel);
		System.out.println("Today temperature is=> "+Cellvl);
		return Cellvl;
	}
}

