package azhouqianqian;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

/*
 * 10个
 */
@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class HomeElectricity extends BaseTest{
/*
 *跳转页面
 */

	@Test
//	跳转到家用电器商品搜索页 
	public void test_jump1() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("xpath=//div[3]/section[7]/header/a");
		Assert.assertTrue(webtest.ifContains("家用电器"));
	}
	
	@Test
//	跳转到家用电器“大家电”商品展示模块
	public void test_jump2() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("xpath=//div[3]/section[7]/header/nav/ul/li[1]/a");
		Assert.assertTrue(webtest.ifContains("大家电"));
	}
	
	@Test
//	跳转到家用电器“生活电器”商品展示模块
	public void test_jump3(){
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("xpath=//div[3]/section[7]/header/nav/ul/li[2]/a");
		Assert.assertTrue(webtest.ifContains("生活电器"));
	}
	
	@Test
//	跳转到家用电器“厨房电器”商品展示模块
	public void test_jump4(){
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("xpath=//div[3]/section[7]/header/nav/ul/li[3]/a");
		Assert.assertTrue(webtest.ifContains("厨房电器"));
	}
	
/*
 * 不同价格区间显示不同商品
 */
	
	@Test
//	3000-4999
	public void test_sort1_money() throws IOException{
//		进入商品搜索页
		webtest.open(ReadProperties.getPropertyValue("base_url"));
//		webtest.click("xpath=//div[3]/section[7]/header/a");
		webtest.clickForList("link=更多>", 2);
		Assert.assertTrue(webtest.ifContains("家用电器"));
		webtest.click("link=3000-4999");
		Assert.assertTrue(webtest.ifContains("3879"));
	}
	
	@Test
//	自定义区间（3500-3900）
	public void test_sort2_money() throws IOException{
//		进入商品搜索页
		webtest.open(ReadProperties.getPropertyValue("base_url"));
//		webtest.click("xpath=//div[3]/section[7]/header/a");
		webtest.clickForList("link=更多>", 2);
		Assert.assertTrue(webtest.ifContains("家用电器"));
		webtest.type("name=min_price","3500");
		webtest.type("name=max_price","3900");
		webtest.clickForList("tag=button", 1);
		Assert.assertTrue(webtest.ifContains("3879"));
	}
	
	@Test
//	跳转到家用电器“大家电”商品展示模块 按照销量降序排列
	public void test_order1() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.clickForList("link=更多>", 2);
		Assert.assertTrue(webtest.ifContains("家用电器"));
		webtest.click("link=大家电");
		Assert.assertTrue(webtest.ifContains("大家电"));
		webtest.click("link=销量");
	}
	
	@Test
//	跳转到家用电器“厨房电器“商品展示模块 按照价格升序排列
	public void test_order2() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.clickForList("link=更多>", 2);
		Assert.assertTrue(webtest.ifContains("家用电器"));
		webtest.click("link=厨房电器");
		Assert.assertTrue(webtest.ifContains("厨房电器"));
		webtest.click("link=价格");
	}
	
	@Test
//	跳转到家用电器“生活电器”商品展示模块 按照评分升序排列
	public void test_order3() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.clickForList("link=更多>", 2);
		Assert.assertTrue(webtest.ifContains("家用电器"));
		webtest.click("link=生活电器");
		Assert.assertTrue(webtest.ifContains("生活电器"));
		webtest.click("link=评分");
	}
	
	@Test
//	自定义区间（3500-3900）按照最新上架顺序降序排列
	public void test_order4() throws IOException{
//		进入商品搜索页
		webtest.open(ReadProperties.getPropertyValue("base_url"));
//		webtest.click("xpath=//div[3]/section[7]/header/a");
		webtest.clickForList("link=更多>", 2);
		Assert.assertTrue(webtest.ifContains("家用电器"));
		webtest.type("name=min_price","3500");
		webtest.type("name=max_price","3900");
		webtest.clickForList("tag=button", 1);
		Assert.assertTrue(webtest.ifContains("3879"));
		webtest.click("link=最新上架");
	}
}


