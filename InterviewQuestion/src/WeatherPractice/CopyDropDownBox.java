package WeatherPractice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CopyDropDownBox {
	WebDriver driver;
	@BeforeTest
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver","C://ITTraining//AllDriver//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get("https://www.weather.gov/");
		
	}
	
		//@Test(priority=0)
		public void CountDropDownBox()   {
			Select DropDown=new Select(driver.findElement(By.xpath(".//*[@id='stateListings']/form/select")));
			List<WebElement>lists=DropDown.getOptions();
			//int list=lists.size();
			System.out.println("total dropdown options are "+lists.size());
			for(int i=0;i<lists.size();i++) {
				String optionvalue=lists.get(i).getText();
						System.out.println(i+"."+optionvalue);
			
			}
			//Advanced ForLoop
			/*for(WebElement el:lists) {
				System.out.println(el.getText());
			}*/
		}
		@Test(priority=3)
		public void WriteToExcel() throws IOException {
			
			Select DropDown=new Select(driver.findElement(By.xpath(".//*[@id='stateListings']/form/select")));
			List<WebElement>lists=DropDown.getOptions();
			
			System.out.println("total dropdown options are "+lists.size());
			File f= new File("C:\\ITTraining\\WebTableData\\DropDownList.doc");
			FileWriter fw =new FileWriter(f);
			BufferedWriter bw=new BufferedWriter(fw);
			for(int i=0;i<lists.size();i++) {
				String optionvalue=lists.get(i).getText();
						bw.write(optionvalue);
						bw.newLine();
						bw.flush();
						
						
						}
			
			
		}
		
		//@Test(priority=1)
		public void CheckAlert() throws InterruptedException { 
			JavascriptExecutor jse=((JavascriptExecutor)driver);
			jse.executeScript("window.scrollBy(0,500)");
			Thread.sleep(4000);
			Select StateSelect=new Select(driver.findElement(By.xpath(".//*[@id='stateListings']/form/select")));
			StateSelect.selectByVisibleText("Alaska");
			driver.findElement(By.xpath(".//*[@id='stateListings']/form/input")).click();
		
		}
		
		@AfterTest
		public void TearDown() {
			driver.close();
		}
}
