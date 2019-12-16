package guoxiaoli;

import java.io.IOException;

import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
//import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class Demo extends BaseTest {
	
	@BeforeMethod()
	public void login1() throws InterruptedException {
		  webtest.open("http://localhost:8067/iWebShop5.6/");
		  webtest.click("link=登录");
		  Thread.sleep(2000);
		  webtest.type("name=login_info","password");
		  webtest.type("name=password","123456");
		  webtest.click("class=input_submit");
		  webtest.click("link=首页");
		  Thread.sleep(2000);
		  Assert.assertTrue(webtest.ifContains("password"));
	}
	
	@Test(priority=31)//食品加入购物车
	public void foodcart() throws InterruptedException, IOException{
		webtest.click("link=进口食品");
		webtest.type("name=min_price","10");
		webtest.type("name=max_price","100");
		//webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='确定']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=6");
		Thread.sleep(2000);
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='加入购物车']");
		Thread.sleep(2000);
		webtest.click("link=首页");
		webtest.mouseoverElement("link=password");
		webtest.click("link=退出登录");
		Assert.assertTrue(webtest.ifContains("首页"));
	}
	@Test(priority=32)//食品购买
	public void foodbuy() throws InterruptedException, IOException{
		webtest.click("link=进口食品");
		webtest.type("name=min_price","10");
		webtest.type("name=max_price","100");
		//webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='确定']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=6");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='立即购买']");
		webtest.click("name=taxes");
		webtest.type("name=invoice_id","dx");
		webtest.click("xpath=//span[text()='确定无误，提交订单']");
//		webtest.click("xpath=//span[text()='立即支付']");
//		Thread.sleep(2000);
//		webtest.enterFrame(0);
//		webtest.click("xpath=//button[@type='button']");
//		webtest.leaveFrame();
		webtest.click("link=首页");
		Assert.assertTrue(webtest.ifContains("dx"));
	}
	
	@Test(priority=33)//家具加入购物车
	public void jiajucart() throws InterruptedException, IOException{
		webtest.click("link=家装建材");
		webtest.type("name=min_price","1000");
		webtest.type("name=max_price","5000");
		//webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='确定']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=189");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='加入购物车']");
		Thread.sleep(2000);
		webtest.click("link=首页");
		webtest.mouseoverElement("link=password");
		webtest.click("link=退出登录");
		Assert.assertTrue(webtest.ifContains("首页"));
	}
	@Test(priority=34)//家具购买
	public void jiajubuy() throws InterruptedException, IOException{
		webtest.click("link=家装建材");
		webtest.type("name=min_price","1000");
		webtest.type("name=max_price","5000");
		//webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='确定']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=189");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='立即购买']");
		webtest.click("name=taxes");
		webtest.type("name=invoice_id","dx");
		webtest.click("xpath=//span[text()='确定无误，提交订单']");
//		webtest.click("xpath=//span[text()='立即支付']");
//		Thread.sleep(2000);
//		webtest.enterFrame(0);
//		webtest.click("xpath=//button[@type='button']");
//		webtest.leaveFrame();
		webtest.click("link=首页");
		webtest.mouseoverElement("link=password");
		webtest.click("link=退出登录");
		Assert.assertTrue(webtest.ifContains("dx"));
	}
	
	@Test(priority=35)//女包加入购物车
	public void bagcart() throws InterruptedException, IOException{
		webtest.click("link=女包");
		webtest.type("name=min_price","300");
		webtest.type("name=max_price","500");
//		webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='确定']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=48");
		//webtest.click("class=reduce");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='加入购物车']");
		Thread.sleep(2000);
		webtest.click("link=首页");
		webtest.mouseoverElement("link=password");
		webtest.click("link=退出登录");
		Assert.assertTrue(webtest.ifContains("首页"));
	}
	
	@Test(priority=36)//女包购买
	public void bagbuy() throws InterruptedException, IOException{
		webtest.click("link=女包");
		webtest.type("name=min_price","300");
		webtest.type("name=max_price","500");
		webtest.click("onclick=priceLink();");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=48");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='立即购买']");
		Thread.sleep(2000);
		webtest.click("name=taxes");
		webtest.type("name=invoice_id","dx");
		webtest.click("xpath=//span[text()='确定无误，提交订单']");
//		webtest.click("xpath=//span[text()='立即支付']");
//		Thread.sleep(2000);
//		webtest.enterFrame(0);
//		webtest.click("xpath=//button[@type='button']");
//		webtest.leaveFrame();
		webtest.click("link=首页");
		webtest.mouseoverElement("link=password");
		webtest.click("link=退出登录");
		Assert.assertTrue(webtest.ifContains("dx"));
	}
	
	@Test(priority=37)//进入后台管理
	public void backstage() throws InterruptedException{
		webtest.click("link=后台管理");
		webtest.type("name=admin_name","admin");
		webtest.type("name=password","123456");
		webtest.type("name=captcha","a");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.ifContains("admin"));
	}
	
}



