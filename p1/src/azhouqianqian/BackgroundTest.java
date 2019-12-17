package azhouqianqian;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

/*
 * 16个
 */
@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class BackgroundTest extends BaseTest {
	@BeforeMethod
	public void backLogin() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=后台管理");
		webtest.type("name=admin_name", "admin");
		webtest.type("name=password", "123456");
		webtest.type("name=captcha", "123");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("超级管理员"));
	}
/*
 * 后台订单
 */
	@Test
//	添加订单(无筛选条件)
	public void testindent1(){
		webtest.click("link=订单");
		webtest.click("link=添加订单");
		webtest.click("link=添加商品");
		webtest.click("xpath=//button[text()='执行']");
		webtest.enterFrame("OpensearchGoods");
		Assert.assertTrue(webtest.ifContains("2207667"));
		webtest.click("id=goods0");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='执行']");
		Assert.assertTrue(webtest.ifContains("2207667"));
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("订单号"));
	}
	@Test
//	添加订单(添加商品~商品名称)
	public void testindent2(){
		webtest.click("link=订单");
		webtest.click("link=添加订单");
		webtest.click("link=添加商品");
		webtest.enterFrame("OpensearchGoods");
		webtest.type("class=form-control","红酒");
		webtest.click("xpath=//button[text()='执行']");
		Assert.assertTrue(webtest.ifContains("2207667"));
		webtest.click("id=goods2");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='执行']");
		Assert.assertTrue(webtest.ifContains(" 2192019"));
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("订单号"));
	}
	
	@Test
//	添加订单(添加商品~选择商品分类) 失败
	public void testindent3(){
		webtest.click("link=订单");
		webtest.click("link=添加订单");
		webtest.click("link=添加商品");
//		进入第一个iframe
		webtest.enterFrame("OpensearchGoods");
//		选择商品分类
		webtest.click("class=btn btn-default");
//		进入第二个iframe
//		WebElement web = webtest.getWebElement("xpath=//iframe[contains(@name,'OpenartDialog')]");
//		webtest.TrendsenterFrame(webtest.getWebElement("xpath=//iframe[contains(@name,'OpenartDialog')]"));
		webtest.click("xpath=//span[@text='食品饮料']");
		
//		退出第二个iframe
		webtest.click("xpath=//button[text()='确定']");
		Assert.assertTrue(webtest.ifContains("2207667"));
		webtest.leaveFrame();
//		点击执行
		webtest.click("xpath=//button[text()='执行']");
//		退出第一个iframe
		webtest.click("id=goods2");
		webtest.leaveFrame();
		
		webtest.click("xpath=//button[text()='执行']");
		Assert.assertTrue(webtest.ifContains(" 2192019"));
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("订单号"));
	}
	
	@Test
//	添加订单(添加商品~根据商品价格上下限进行筛选)
	public void testindent4(){
		webtest.click("link=订单");
		webtest.click("link=添加订单");
		webtest.click("link=添加商品");
//		进入第一个iframe
		webtest.enterFrame("OpensearchGoods");
//		选择商品价格上下限
		webtest.type("name=search[seller_price_down]","500");
		webtest.type("name=search[seller_price_up]","550");
		webtest.click("xpath=//button[text()='执行']");
//		退出第一个iframe
		webtest.click("id=goods0");
		webtest.leaveFrame();
//		点击执行
		webtest.click("xpath=//button[text()='执行']");
		Assert.assertTrue(webtest.ifContains(" 1523270"));
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("订单号"));
	}
	
	@Test
//	添加订单(添加商品~根据创建日期进行筛选)
	public void testindent5(){
		webtest.click("link=订单");
		webtest.click("link=添加订单");
		webtest.click("link=添加商品");
//		进入第一个iframe
		webtest.enterFrame("OpensearchGoods");
//		选择商品价格上下限
		webtest.type("name=search[create_time_start]","2019-12-01");
		webtest.type("name=search[create_time_end]","2019-12-07");
//		退出第一个iframe
		webtest.leaveFrame();
//		点击执行
		webtest.click("xpath=//button[text()='执行']");
		Assert.assertTrue(webtest.ifContains("无相关商品"));
	}
	
/*
 * 全选
 */
	@Test
	public void testAll6(){
		webtest.click("link=订单");
//		点击全选
		webtest.click("link=全选");
	}
	
	
/*
 * 后台页面显示跳转
 */
	
	@Test
	public void Show_list7(){
//		订单
		webtest.click("link=订单");
		webtest.click("link=添加订单");
		webtest.click("link=退款申请列表");
		webtest.click("link=换货申请列表");
		webtest.click("link=维修申请列表");
		webtest.click("link=单据管理");
		webtest.click("link=收款单");
		webtest.click("link=换货单");
		webtest.click("link=发货单");
		webtest.click("link=退款单");
		webtest.click("link=维修单");
		webtest.click("link=发货地址");
		webtest.click("link=发货地址管理");
//		营销
		webtest.click("link=营销");
		webtest.click("link=促销活动");
		webtest.click("link=促销活动列表");
		webtest.click("link=营销活动");
		webtest.click("link=积分兑换");
		webtest.click("link=限时抢购");
		webtest.click("link=拼团");
		webtest.click("link=团购");
		webtest.click("link=特价");
		webtest.click("link=优惠券管理");
		webtest.click("link=优惠券列表");
//		统计
		webtest.click("link=统计");
		webtest.click("link=基础数据统计");
		webtest.click("link=用户注册统计");
		webtest.click("link=人均消费统计");
		webtest.click("link=销售金额统计");
		webtest.click("link=日志操作记录");
		webtest.click("link=充值操作记录");
		webtest.click("link=后台操作记录");
		webtest.click("link=商户数据统计");
		webtest.click("link=货款明细列表");
		webtest.click("link=货款结算申请");
	}
	
/*
 * 营销
 */
//	添加活动
	@Test
	public void test_add1(){
		webtest.click("link=营销");
		webtest.click("link=添加活动");
		webtest.type("name=name", "双十一盖楼活动");
//		设置活动时间
		webtest.type("name=start_time", "2019-10-11 00:00:00");
		webtest.type("name=end_time", "2019-11-10 00:00:00");
//		选择活动规则
		webtest.selectByValue("name=type","0");
//		设置活动金额
		webtest.type("name=condition", "400");
//		选择奖励方式
		webtest.selectByValue("name=award_type", "1");
//		设置优惠金额
		webtest.type("name=award_value","50");
//		点击确定
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	添加积分兑换活动
	@Test
	public void test_add2(){
		webtest.click("link=营销");
		webtest.click("link=营销活动");
		webtest.click("link=积分兑换");
		webtest.click("link=添加积分兑换");
//		设置活动标题
		webtest.type("name=name", "积分换换换");
//		设置活动商品
		webtest.click("xpath=//button[text()='选择商品']");
		webtest.click("xpath=//button[text()='执行']");
		webtest.enterFrame("OpensearchGoods");
		webtest.click("id=goods3");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='执行']");
//		设置所需积分数
		webtest.type("name=point", "200");
//		点击确定
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	添加限时抢购活动
	@Test
	public void test_add3(){
		webtest.click("link=营销");
		webtest.click("link=营销活动");
		webtest.click("link=限时抢购");
		webtest.click("link=添加限时抢购");
//		设置活动标题
		webtest.type("name=name", "购购购");
//		设置活动时间
		webtest.type("name=start_time", "2019-10-11 00:00:00");
		webtest.type("name=end_time", "2019-11-10 00:00:00");
//		设置活动商品
		webtest.click("xpath=//button[text()='选择商品']");
		webtest.click("xpath=//button[text()='执行']");
		webtest.enterFrame("OpensearchGoods");
		webtest.click("id=goods3");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='执行']");
//		设置抢购价格
		webtest.type("name=award_value", "200");
//		点击确定
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	添加拼团
	@Test
	public void test_add4(){
		webtest.click("link=营销");
		webtest.click("link=营销活动");
		webtest.click("link=拼团");
		webtest.click("link=添加拼团");
//		设置活动标题
		webtest.type("name=title", "拼拼拼");
//		设置活动商品
		webtest.click("xpath=//button[text()='添加商品']");
		webtest.click("xpath=//button[text()='执行']");
		webtest.enterFrame("OpensearchGoods");
		webtest.click("id=goods3");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='执行']");
		webtest.type("name=assemble_price", "200");
//		设置成团人数
		webtest.type("name=limit_nums", "3");
//		点击确定
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	添加团购
	@Test
	public void test_add5(){
		webtest.click("link=营销");
		webtest.click("link=营销活动");
		webtest.click("link=团购");
		webtest.click("link=添加团购");
//		设置活动标题
		webtest.type("name=title", "团团团");
//		设置活动时间
		webtest.type("name=start_time", "2019-10-11 00:00:00");
		webtest.type("name=end_time", "2019-11-10 00:00:00");
//		设置活动商品
		webtest.click("xpath=//button[text()='添加商品']");
		webtest.click("xpath=//button[text()='执行']");
		webtest.enterFrame("OpensearchGoods");
		webtest.click("id=goods3");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='执行']");
//		设置活动商品金额
		webtest.type("name=regiment_price", "200");
//		设置库存量
		webtest.type("name=store_nums", "50");
//		设置最小购买数量
		webtest.type("name=limit_min_count", "1");
//		设置最多购买数量
		webtest.type("name=limit_max_count", "3");
//		点击确定
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	添加特价商品
	@Test
	public void test_add6(){
		webtest.click("link=营销");
		webtest.click("link=营销活动");
		webtest.click("link=特价");
		webtest.click("link=添加特价");
//		设置活动标题
		webtest.type("name=name", "今日特价");
//		设置特价条件
		webtest.selectByValue("name=type", "4");
//		筛选
		webtest.selectByValue("name=brand_id", "3");
//		设置折扣
		webtest.type("name=award_value", "90");
//		点击确定
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	添加优惠券
	
	@Test
	public void test_add7(){
		webtest.click("link=营销");
		webtest.click("link=优惠券管理");
		webtest.click("link=优惠券列表");
		webtest.click("link=添加优惠券");
//		设置活动标题
		webtest.type("name=name", "满100减10元");
//		设置优惠券面额
		webtest.type("name=value", "10");
//		使用范围
		webtest.selectByValue("name=type", "0");
//		设置优惠券满足面额
		webtest.type("name=limit_sum", "100");
//		设置活动有效时间
		webtest.type("name=start_time", "2019-10-11 00:00:00");
		webtest.type("name=end_time", "2019-11-10 00:00:00");
//		兑换所需积分
		webtest.type("name=point", "100");
//		点击确定
		webtest.click("xpath=//button[@type='submit']");
	}

/*
 * 统计
 */
//	查看不同时间段内用户注册数量
	@Test
	public void test_show8(){
		webtest.click("link=统计");
		webtest.click("link=基础数据统计");
		webtest.click("link=用户注册统计");
//	          设置时间
		webtest.type("name=start", "2019-10-11");
		webtest.type("name=end", "2019-11-10");
//		点击查询
		webtest.click("xpath=//button[@type='button']");
	}
}

