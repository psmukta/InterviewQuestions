package InterviewQuestionPack1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToHandleBrokenLink {
	public static void main(String[]args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\ITTraining\\AllDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.capitalone.com/");
		List<WebElement> Links=driver.findElements(By.tagName("a"));
		System.out.println("Total links are " +Links.size());
		
		for(int i=0; i<Links.size();i++) {
			String url=Links.get(i).getAttribute("href");
			verifyActiveLinks(url);
		}
	}
	public static void verifyActiveLinks(String linkurl) throws Exception {
		URL url=new URL(linkurl);
		HttpURLConnection huc=(HttpURLConnection)url.openConnection();
		huc.setConnectTimeout(3000);
		huc.connect();
		if(huc.getResponseCode()==200) {
			System.out.println(linkurl+"-"+huc.getResponseMessage());
		}
		else if(huc.getResponseCode()==404) {
			System.out.println(linkurl+"-"+huc.getResponseMessage());
		}
		else if(huc.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(linkurl+"-"+huc.getResponseMessage());
		}
		else {
			System.out.println("URL is not correct");
		}
		
		}
	}
	


