package azhouqianqian;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.utils.ReadProperties;

/*
 * 5个
 */
@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class ExchangePoints extends BaseTest{
/*
 * 通过积分兑换模块，提交商品订单
 */
	@Test
	//跳转到商品详情页
	public void test1() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("xpath=//h3[text()='兑换积分']");
//		断言
		Assert.assertTrue(webtest.ifContains("所需兑换积分"));
	}
/*
 * 提交订单流程
 */	
	
	@Test
	//使用积分立即购买1瓶拉菲
	public void test2() throws InterruptedException, IOException{
//		登录
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=登录");
		webtest.type("name=login_info", "zhouqian");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='登录']");
//		回到首页
		webtest.click("link=首页");
		webtest.click("xpath=//h3[text()='兑换积分']");
		Assert.assertTrue(webtest.ifContains("所需兑换积分"));
//		立即购买
		webtest.click("id=buyNowButton");
		Assert.assertTrue(webtest.ifContains("填写核对订单信息"));
//		提交订单
		webtest.click("xpath=//span[text()='确定无误，提交订单']");
		Assert.assertTrue(webtest.ifContains("订单已提交"));
	}
	
/*
 * 修改地址
 */
	@Test
	//使用积分立即购买1瓶拉菲
	public void test3() throws InterruptedException, IOException{
//		登录
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=登录");
		webtest.type("name=login_info", "zhouqian");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='登录']");
//		回到首页
		webtest.click("link=首页");
		webtest.click("xpath=//h3[text()='兑换积分']");
		Assert.assertTrue(webtest.ifContains("所需兑换积分"));
//		立即购买
		webtest.click("id=buyNowButton");
		Assert.assertTrue(webtest.ifContains("填写核对订单信息"));
//		修改地址
		webtest.click("xpath=//span[contains(text(),'修改地址')]");
		Thread.sleep(3000);
		webtest.enterFrame("OpenaddressWindow");
		webtest.typeAndClear("name=address", "河北师范大学");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.ifContains("河北师范大学"));
//		提交订单
		webtest.click("xpath=//span[text()='确定无误，提交订单']");
		Assert.assertTrue(webtest.ifContains("订单已提交"));
	}
	
	/*
	 * 修改数量
	 */
		@Test
		//使用积分立即购买2瓶拉菲
		public void test4() throws InterruptedException, IOException{
//			登录
			webtest.open(ReadProperties.getPropertyValue("base_url"));
			webtest.click("link=登录");
			webtest.type("name=login_info", "zhouqian");
			webtest.type("name=password", "123456");
			webtest.click("xpath=//input[@value='登录']");
//			回到首页
			webtest.click("link=首页");
			webtest.click("xpath=//h3[text()='兑换积分']");
			Assert.assertTrue(webtest.ifContains("所需兑换积分"));
//			数量加一，数量加一，数量减一
			webtest.click("id=buyAddButton");
			webtest.click("id=buyAddButton");
			webtest.click("id=buyReduceButton");
//			立即购买
			webtest.click("id=buyNowButton");
			Assert.assertTrue(webtest.ifContains("填写核对订单信息"));
//			提交订单
			webtest.click("xpath=//span[text()='确定无误，提交订单']");
			Assert.assertTrue(webtest.ifContains("订单已提交"));
		}
		
/*
 * 提示用户积分不足
 */
		@Test
		public void test5() throws InterruptedException, IOException{
//			登录
			webtest.open(ReadProperties.getPropertyValue("base_url"));
			webtest.click("link=登录");
			webtest.type("name=login_info", "lixuan");
			webtest.type("name=password", "123456");
			webtest.click("xpath=//input[@value='登录']");
//			回到首页
			webtest.click("link=首页");
			webtest.click("xpath=//h3[text()='兑换积分']");
			Assert.assertTrue(webtest.ifContains("所需兑换积分"));
//			立即购买
			webtest.click("id=buyNowButton");
			Assert.assertTrue(webtest.ifContains("用户积分不足"));
			
		}
}


