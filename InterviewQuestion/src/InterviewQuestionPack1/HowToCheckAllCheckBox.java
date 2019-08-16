package InterviewQuestionPack1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowToCheckAllCheckBox {
	WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/ITTraining/WebSite/SuperTech.html");
	}

	@Test
	public void CheckBox() {
		//xpath for all checkbox :all checkbox should be catch  
		List<WebElement>checkbox=driver.findElements(By.xpath("html/body/div[2]/form[3]/input"));
		int totalcheckbox=checkbox.size();
		System.out.println("Total check box : "+totalcheckbox);

	}
	@Test
	public void VarifyCheckBoxCheckedOrNot() {
		WebElement CheckBox2=driver.findElement(By.xpath(".//*[@id='form3']/input[2]"));
		boolean checkedbox=CheckBox2.isSelected();
		if(checkedbox==true) {
			System.out.println("Checked Box is Checked");
			
		}
		else{
			System.out.println("Checked Box is not Checked");
			
		}
		


	}


}
