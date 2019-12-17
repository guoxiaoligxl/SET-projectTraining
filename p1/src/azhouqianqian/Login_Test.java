package azhouqianqian;
/*
 * 14¸ö
 */
import java.io.IOException;

/*
 * 7¸ö
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class Login_Test extends BaseTest{

	@DataProvider(name="test1")
	public Object[][] createData1() throws IOException {
		ExcelDataProvider provider = new ExcelDataProvider();
	 	return provider.getTestDataByExcel("F:\\data.xlsx","login1");
	}
		
	
	@Test(dataProvider="test1")
	// ³É¹¦µÇÂ¼
	public void test_login1(String username,String password) throws IOException, InterruptedException {
		
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=µÇÂ¼");
		webtest.type("name=login_info", username);
		webtest.type("name=password", password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
		System.out.println(webtest.isElementPresent("link="+username));
		Assert.assertTrue(webtest.ifContains(username));
		webtest.mouseoverElement("link="+username);
		webtest.click("link=ÍË³öµÇÂ¼");
	}
	
	@DataProvider(name="test2")
	public Object[][] createData2() throws IOException {
		ExcelDataProvider provider = new ExcelDataProvider();
	 	return provider.getTestDataByExcel("F:\\data.xlsx","login2");
	}
	
	@Test(dataProvider="test2")
	// µÇÂ¼Ê§°Ü£¨ÓÃ»§Ãû´íÎó£©
	public void test_login2(String username,String password) throws InterruptedException {
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=login_info", username);
		webtest.type("name=password", password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
		System.out.println(webtest.isElementPresent("link=zhouqian"));
		if (webtest.isElementPresent("link=zhouqian") == true) {
			assert true;
		} else {
			assert false : "µÇÂ¼Ê§°Ü";
		}
	}
	
	
	@DataProvider(name="test3")
	public Object[][] createData3() throws IOException {
		ExcelDataProvider provider = new ExcelDataProvider();
	 	return provider.getTestDataByExcel("F:\\data.xlsx","login3");
	}

	@Test(dataProvider="test3")
	// µÇÂ¼Ê§°Ü£¨ÃÜÂë´íÎó£©
	public void test_login3(String username,String password) {
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=login_info", username);
		webtest.type("name=password", password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
		System.out.println(webtest.isElementPresent("link=zhouqian"));
		if (webtest.isElementPresent("link=zhouqian") == true) {
			assert true;
		} else {
			assert false : "µÇÂ¼Ê§°Ü";
		}
	}
	
	
	@DataProvider(name="test4")
	public Object[][] createData4() throws IOException {
		ExcelDataProvider provider = new ExcelDataProvider();
	 	return provider.getTestDataByExcel("F:\\data.xlsx","login4");
	}

	@Test(dataProvider="test4")
	// µÇÂ¼Ê§°Ü£¨ÓÃ»§ÃûÖÐº¬ÓÐ·Ç·¨×Ö·û£©
	public void test_login4(String username,String password) {
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=login_info", "zhou&qian");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='µÇÂ¼']");
		System.out.println(webtest.isElementPresent("link=zhouqian"));
		if (webtest.isElementPresent("link=zhouqian") == true) {
			assert true;
		} else {
			assert false : "µÇÂ¼Ê§°Ü";
		}
	}
	
	
	@DataProvider(name="test5")
	public Object[][] createData5() throws IOException {
		ExcelDataProvider provider = new ExcelDataProvider();
	 	return provider.getTestDataByExcel("F:\\data.xlsx","login5");
	}

	@Test(dataProvider="test5")
	// µÇÂ¼Ê§°Ü£¨ÃÜÂëÖÐº¬ÓÐ·Ç·¨×Ö·û£©
	public void test_login5(String username,String password) {
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=login_info", username);
		webtest.type("name=password", password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
		System.out.println(webtest.isElementPresent("link=zhouqian"));
		if (webtest.isElementPresent("link=zhouqian") == true) {
			assert true;
		} else {
			assert false : "µÇÂ¼Ê§°Ü";
		}
	}
	
	
	@DataProvider(name="test6")
	public Object[][] createData6() throws IOException {
		ExcelDataProvider provider = new ExcelDataProvider();
	 	return provider.getTestDataByExcel("F:\\data.xlsx","login6");
	}

	@Test(dataProvider="test6")
	// µÇÂ¼Ê§°Ü£¨ÓÃ»§ÃûÎª¿Õ£©
	public void test_login6(String username,String password) {
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=login_info",username);
		webtest.type("name=password", password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
		System.out.println(webtest.isElementPresent("link=zhouqian"));
		if (webtest.isElementPresent("link=zhouqian") == true) {
			assert true;
		} else {
			assert false : "µÇÂ¼Ê§°Ü";
		}
	}
	
	
	@DataProvider(name="test7")
	public Object[][] createData7() throws IOException {
		ExcelDataProvider provider = new ExcelDataProvider();
	 	return provider.getTestDataByExcel("F:\\data.xlsx","login7");
	}

	@Test(dataProvider="test7")
	// µÇÂ¼Ê§°Ü£¨ÃÜÂëÎª¿Õ£©
	public void test_login7(String username,String password) {
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=login_info", username);
		webtest.type("name=password", password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
		System.out.println(webtest.isElementPresent("link=zhouqian"));
		if (webtest.isElementPresent("link=zhouqian") == true) {
			assert true;
		} else {
			assert false : "µÇÂ¼Ê§°Ü";
		}
	}
}


