package InterviewQuestionPack1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssert {
	@Test
	public void hardAssert() {
		System.out.println("Open Browser");
		Assert.assertEquals(true, false);//assert failed
		System.out.println("Go to URL");
		System.out.println("Enter user name");
	}
	//@Test
	public void softAssert() {
		SoftAssert soassert=new SoftAssert();
		System.out.println("Open Browser");
		soassert.assertEquals(true, false);//actually fail
		System.out.println("Go to URL");
		soassert.assertEquals(true, false);
		System.out.println("Enter user name");
		soassert.assertAll();
	}
	

}
