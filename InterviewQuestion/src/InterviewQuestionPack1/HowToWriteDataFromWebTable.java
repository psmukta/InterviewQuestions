package InterviewQuestionPack1;

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


public class HowToWriteDataFromWebTable {
	WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		
         driver=new ChromeDriver();
         Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("file:///C:/ITTraining/WebTable.html");
	}


	@Test
	public void WebDataWritingL() throws IOException {
		List<WebElement>rows=driver.findElements(By.tagName("tr"));
		int rowCount=rows.size();
		System.out.println("Total rows are:"+rowCount);
		List<WebElement>colms=driver.findElements(By.tagName("th"));
		int colCount=colms.size();
		System.out.println("Total columns are:"+colCount);
		FileOutputStream fos=new FileOutputStream("c:\\ITTraining\\WebTable\\WebData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("Data1");
		for(int i=1;i<=rowCount;i++) {
			XSSFRow excelRow=sheet.createRow(i);
			for(int j=1;j<=colCount;j++) {
				
				if(i==1) {
					WebElement value=driver.findElement(By.xpath("html/body/table/tbody/tr["+i+"]/th["+j+"]"));
					//xpath manually fix 
					String a=value.getText();
					XSSFCell excelCell=excelRow.createCell(j);
					excelCell.setCellValue(a);
				}
				else {
					WebElement value=driver.findElement(By.xpath("html/body/table/tbody/tr["+i+"]/td["+j+"]"));
					String a=value.getText();
					XSSFCell excelCell=excelRow.createCell(j);
					excelCell.setCellValue(a);
				}
			}//inner loop
		}//outer loop
		wb.write(fos);
		fos.flush();
		fos.close();
		

	}
	//@AfterTest
	public void closeBrowser() {
		driver.close();


	}
}
