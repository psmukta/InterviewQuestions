package crossbrowserPack;

import org.testng.annotations.DataProvider;

public class DataProviderData {
	@DataProvider(name="MultiBrowserData")
	public static Object[][] getData(){
		return new Object[][] {
			{"Chrome"},
			{"Firefox"},
			{"Edge"}
			
			
		};
	}

}
