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

public class LocalPhoneTable {
	WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");

		driver=new ChromeDriver();
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		driver.get("https://www.localphone.com/");
		//driver.get("https://www.w3schools.com/html/html_tables.asp");
	}
	@Test
	public void writeWebtable() throws IOException {
		List<WebElement>rows=driver.findElements(By.xpath(".//*[@id='homepageComparison']/table/tbody/tr"));
		
		int Row=rows.size();
		System.out.println("Total Row are:"+Row);
		List<WebElement>columns=driver.findElements(By.xpath(".//*[@id='homepageComparison']/table/thead/tr/th"));
		
		int Col=columns.size();
		System.out.println("Total columns are:"+Col);
		
		//FileOutputStream fos=new FileOutputStream("c:\\ITTraining\\WebTable\\LocalPhone_Table.xlsx");//excel sheet should be create auto 
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"\\src\\localPhone\\LocalPhone.xlsx");//inside the project
		//C:\Users\tanvi\Desktop\Project\InterviewQuestion\src
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet st= wb.createSheet("Data1");
		for(int i=1;i<=Row;i++) {
			XSSFRow RW=st.createRow(i);
			for(int j=1;j<=Col;j++) {
				if(j==1) {
					
				WebElement value=driver.findElement(By.xpath(".//*[@id='homepageComparison']/table/tbody/tr["+i+"]/th["+j+"]"));
				
					String a=value.getText();
					XSSFCell EC=RW.createCell(j);
					EC.setCellValue(a);
				}
				else {
					WebElement value=driver.findElement(By.xpath(".//*[@id='homepageComparison']/table/tbody/tr["+i+"]/td["+(j-1)+"]"));
					
					String a=value.getText();
					XSSFCell EC=RW.createCell(j);
					EC.setCellValue(a);
				}
			}
		}
		wb.write(fos);
		fos.flush();
		fos.close();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
