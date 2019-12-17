package azhouqianqian;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

/*
 * 5个
 */
@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class Pingtuan extends BaseTest {
	/*
	 *  网页跳转链接(无拼团商品)
	 */
	@Test()
	public void test_jump1() {
//		拼团页面跳转
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=更多>");
//		断言
		System.out.println(webtest.isElementPresent("xpath=//strong[contains(text(),'拼团活动')]"));
		if (webtest.isElementPresent("xpath=//strong[contains(text(),'拼团活动')]") == true) {
			assert true;
		} else {
			assert false : "跳转失败";
		}
//		返回上一级
		webtest.click("link=返回上一级操作");
		Assert.assertTrue(webtest.ifContains("拼团商品"));
	
	}
	
	@Test()
	public void test_jump2() {
//		拼团页面跳转
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=更多>");
//		断言
		System.out.println(webtest.isElementPresent("xpath=//strong[contains(text(),'拼团活动')]"));
		if (webtest.isElementPresent("xpath=//strong[contains(text(),'拼团活动')]") == true) {
			assert true;
		} else {
			assert false : "跳转失败";
		}
//		跳转到网站首页
		webtest.click("link=网站首页");
		Assert.assertTrue(webtest.ifContains("首页"));
	}
	
	@Test()
	public void test_jump3() throws IOException {
//		拼团页面跳转
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=更多>");
//		断言
		System.out.println(webtest.isElementPresent("xpath=//strong[contains(text(),'拼团活动')]"));
		if (webtest.isElementPresent("xpath=//strong[contains(text(),'拼团活动')]") == true) {
			assert true;
		} else {
			assert false : "跳转失败";
		}
//		跳转到我的订单
		webtest.click("link=我的订单");
		Assert.assertTrue(webtest.ifContains("我的订单"));
	}
	
	@Test()
	public void test_jump4() {
//		拼团页面跳转
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=更多>");
//		断言
		System.out.println(webtest.isElementPresent("xpath=//strong[contains(text(),'拼团活动')]"));
		if (webtest.isElementPresent("xpath=//strong[contains(text(),'拼团活动')]") == true) {
			assert true;
		} else {
			assert false : "跳转失败";
		}
//		跳转到我的购物车
		webtest.click("link=我的购物车");
		Assert.assertTrue(webtest.ifContains("购物车"));
	}
	
/*
 * 开团购买
 */
	@Test()
	public void test_buy() throws IOException {
//		拼团页面跳转
//		登录
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=登录");
		webtest.type("name=login_info", "zhouqian");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='登录']");
//		回到首页
		webtest.click("link=首页");
//		进入拼团商品页
		webtest.click("xpath=//h3[text()='电视']");
		Assert.assertTrue(webtest.ifContains("电视"));
//		进入商品详情页
		webtest.click("xpath=//span[text()='电视']");
//		立即拼团
		webtest.click("我要开团");
//		提交订单
		webtest.click("xpath=//span[text()='确定无误，提交订单']");
		Assert.assertTrue(webtest.ifContains("订单已提交"));
		
	}
}


