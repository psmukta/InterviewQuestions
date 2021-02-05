package WebTablePack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//https://www.guru99.com/handling-dynamic-selenium-webdriver.html
public class ReadSpecificCellData {
		WebDriver driver;
		
		
		@BeforeTest
		public void openBrowse() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver","C:\\ITTraining\\AllDriver\\geckodriver.exe");
			
			/*WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			*/
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			Thread.sleep(4000);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		@Test 
		public void clickSubmenu() throws InterruptedException {
			driver.get("https://www.w3schools.com/");
			Thread.sleep(4000);
			WebElement LearnHTML=driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[1]/a[1]"));
			Actions act=new Actions(driver);
			act.moveToElement(LearnHTML).click().build().perform();
			WebElement HTMLTable=driver.findElement(By.xpath("//*[@id=\"leftmenuinnerinner\"]/a[17]"));
			Actions act2=new Actions(driver);
			act2.moveToElement(HTMLTable).click().build().perform();
			
		}
		
		@Test
		public void readData() throws IOException {
			//driver.get("https://www.w3schools.com/html/html_tables.asp");
			
			List<WebElement>rows=driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr"));
			int rowCount=rows.size();
			System.out.println("Total Rows are:"+rowCount);
			List<WebElement>Columns=driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr[1]/th"));
			int colCount=Columns.size();
			System.out.println("Total Columns are:"+colCount);
			
			
			WebElement tab=driver.findElement(By.id("customers")); 
			WebElement tableRow = tab.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[3]"));
	         String rowtext = tableRow.getText();
			 System.out.println("Third row of table : "+rowtext);
			WebElement coltab=tableRow.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[3]/td[3]"));
			String value=coltab.getText();
			System.out.println(value);
			
		}
		
		//@AfterTest
		public void tearDown() {
			driver.close();
		}
		

}
