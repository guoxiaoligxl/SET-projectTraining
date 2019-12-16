package guoxiaoli;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class Demo1 extends BaseTest{

	String login_url="/index.php?controller=admin&action=index";
	@Test(priority=41)//通过网址进入 后台管理登录页面
	public void login() throws InterruptedException, IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		webtest.type("name=admin_name","admin");
		webtest.type("name=password","123456");
		webtest.type("name=captcha","a");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.ifContains("admin"));
	}
	
	//系统
	//系统首页
	@Test(priority=42)
	public void xitong(){
		webtest.click("link=系统");
		webtest.click("link=首页");
	    Assert.assertTrue(webtest.ifContains("首页"));
	}
	
//	//网站设置内容
	@Test(priority=43)
	public void netset() throws InterruptedException{
		webtest.click("link=网站管理");
		webtest.click("link=网站设置");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@type='file']","D:\\pic\\second.jpg");
		webtest.type("name=master","23");
		webtest.type("name=qq","123456");
		webtest.type("name=email","guoxiaoligxl@126.com");
		webtest.type("name=mobile","15215215215");
		webtest.type("name=phone","123");
		webtest.type("name=address","90");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("90"));
	} 
	
	//使用数据驱动进行配送方式的添加
	@DataProvider(name="test1")
	public Object[][] createData1() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet2");
	}
	
	@Test(priority=44,dataProvider="test1")//添加配送方式
	public void delivery(String name,String first_price,String second_weight,
			String second_price,String sort,String description) throws InterruptedException{
		webtest.click("link=配送管理");
		webtest.click("link=配送方式");
		webtest.click("link=添加配送方式");
		webtest.type("name=name",name);
		webtest.type("name=first_price",first_price);
		webtest.type("name=second_weight",second_weight);
		webtest.type("name=second_price",second_price);
		webtest.type("name=sort",sort);
		webtest.click("xpath=//input[@value='1']");
		webtest.type("name=description",description);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("添加配送方式"));
	}
	
	//使用数据驱动进行物流公司的添加
		@DataProvider(name="test2")
		public Object[][] createData2() throws IOException{
			ExcelDataProvider provider=new ExcelDataProvider();
			return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet4");
		}
		
		@Test(priority=45,dataProvider="test2")//添加物流公司
		public void freight(String freight_type,String freight_name,String url,String sort) throws InterruptedException{
			webtest.click("link=配送管理");
			webtest.click("link=物流公司");
			webtest.click("link=添加物流公司");
			webtest.type("name=freight_type",freight_type);
			webtest.type("name=freight_name",freight_name);
			webtest.type("name=url",url);
			webtest.type("name=sort",sort);
			webtest.click("xpath=//button[@type='submit']");
			Assert.assertTrue(webtest.ifContains("物流公司"));
		}
	
	//使用数据驱动进行自动提点的添加
	@DataProvider(name="test3")
	public Object[][] createData3() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet3");
	}
	
	@Test(priority=46,dataProvider="test3")//添加自提点
	public void takeself(String name,String pic,String province,String city,
			String area,String address,String phone,String mobile,String sort) throws InterruptedException{
		webtest.click("link=配送管理");
		webtest.click("link=添加自提点");
		webtest.type("name=name",name);
		webtest.type("xpath=//input[@type='file']",pic);
		Thread.sleep(2000);
		webtest.type("name=province",province);
		Thread.sleep(2000);
		webtest.type("name=city",city);
		Thread.sleep(2000);
		webtest.type("name=area",area);
		Thread.sleep(2000);
		webtest.type("name=address",address);
		webtest.type("name=phone",phone);
		webtest.type("name=mobile",mobile);
		webtest.type("name=sort",sort);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("name"));
	}
	
	//工具
	//数据库
	@Test(priority=47)
	public void db(){
		webtest.click("link=工具");
		webtest.click("link=数据库还原");
		Assert.assertTrue(webtest.ifContains("数据库还原"));
	}
	
	//文章管理
	//使用数据驱动进行文章分类的添加
	@DataProvider(name="test4")
	public Object[][] createData4() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet5");
	}
	
	@Test(priority=48,dataProvider="test4")//添加文章分类
	public void addarticle(String name,String sort) throws InterruptedException{
		webtest.click("link=工具");
		webtest.click("link=文章管理");
		webtest.click("link=文章分类");
		webtest.click("link=添加分类");
		webtest.type("name=name",name);
		webtest.click("xpath=//input[@value='1']");
		webtest.type("name=sort",sort);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("name"));
	}
	
	
	//设置
	//设置的修改密码
	@DataProvider(name="test5")
	public Object[][] createData() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet6");
	}
	@Test(priority=49,dataProvider="test5")
	public void setpassowrd(String password,String repassword) throws InterruptedException {
		webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
		webtest.click("link=修改密码");
		Thread.sleep(2000);
		webtest.type("name=password",password);
		webtest.type("name=repassword",repassword);
		webtest.click("xpath=//button[@type='submit']");
	}
	
	//设置的后台首页
	@Test(priority=50)
	public void setback() throws InterruptedException{
		webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
		webtest.click("link=后台首页");
		Thread.sleep(2000);
	}
	
	//设置的商城首页
	@Test(priority=51)
	public void setshop() throws InterruptedException{
		webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
		webtest.click("link=商城首页");
		Thread.sleep(2000);
	}
	
	//设置的快速导航
		@Test(priority=52)
		public void setnav() throws InterruptedException{
			webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
			webtest.click("link=快速导航");
			Thread.sleep(2000);
			webtest.click("link=添加快速导航");
			webtest.type("name=naviga_name","其他");
			webtest.type("name=url","another/index");	
			webtest.click("xpath=//button[@type='submit']");
		}
	//设置的退出管理
	@Test(priority=53)
	public void setquit() throws InterruptedException {
		webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
		webtest.click("link=退出管理");
		Thread.sleep(2000);
		webtest.type("name=admin_name","admin");
		webtest.type("name=password","123456");
		webtest.type("name=captcha","a");
		webtest.click("xpath=//button[@type='submit']");
	}
}

