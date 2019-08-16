package WebTablePack;

import java.io.FileNotFoundException;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocalPhoneTable2 {
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");

		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		driver.get("https://www.localphone.com/");
		
	}
	@Test
	public void writeWebtable() throws IOException {
		List<WebElement>rows=driver.findElements(By.xpath(".//*[@id='homepageComparison']/table/tbody/tr/td[1]"));
		
		//.//*[@id='homepageComparison']/table/tbody/tr
		int Row=rows.size();
		System.out.println("Total Row are:"+Row);
		List<WebElement>columns=driver.findElements(By.xpath(".//*[@id='homepageComparison']/table/tbody/tr[1]/td"));
		
		//.//*[@id='homepageComparison']/table/thead/tr/th
		
		int Col=columns.size();
		System.out.println("Total columns are:"+Col);
		
		//Xls_Reader reader=new Xls_Reader("c:\\ITTraining\\WebTable\\LocalPhone_Table.xlsx");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
