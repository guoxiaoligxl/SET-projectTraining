package lixuan;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.utils.ReadProperties;

@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class LoginTest extends BaseTest{
	String url="/index.php?controller=ucenter&action=index";
	 @BeforeMethod
	 //登录
	  public void login() throws InterruptedException, IOException{
		 String login_url="/index.php?controller=site&action=index";
		//打开页面
		  webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		  //点击
		  Thread.sleep(1000);
		  webtest.click("link=登录");
		  //输入
		  webtest.type("name=login_info", "chenmeng");
		  webtest.type("name=password", "lixuan");
		  Thread.sleep(1000);
		  webtest.click("class=input_submit");
		  Assert.assertTrue(webtest.ifContains("chenmeng"));
	 }
	 @Test(priority=2)
	 //个人中心之交易记录之我的订单
	 public void wodedingdan() throws InterruptedException, IOException{
		 String login_url="/index.php?controller=ucenter&action=index";
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		 Thread.sleep(1000);
		 webtest.click("link=我的订单");
		 Assert.assertTrue(webtest.ifContains("订单状态"));
	 }
	 @Test(priority=3)
	//个人中心之交易记录之我的积分
	 public void wodejifen() throws InterruptedException, IOException{
		 String login_url="/index.php?controller=ucenter&action=index";
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		 Thread.sleep(1000);
		 webtest.click("link=我的积分");
		 Assert.assertTrue(webtest.ifContains("积分日期"));
	 }
	 @Test(priority=4)
		//个人中心之交易记录之我的优惠券
		 public void wodeyouhuiquan() throws InterruptedException, IOException{
		 	String login_url = "/index.php?controller=ucenter&action=index";
		 	webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
			Thread.sleep(1000);
			webtest.click("link=我的优惠券");
			Assert.assertTrue(webtest.ifContains("面值"));
		 }
	//数据驱动
	 @DataProvider(name="test1")
	 public Object[][] createData1() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","zhandian");
	 }
	 @Test(priority=5,dataProvider="test1")
	 //站点建议 7条
	 public void myselfjianyi(String title,String content) throws InterruptedException, IOException{
		 String login_url="/index.php?controller=ucenter&action=index";
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		 Thread.sleep(1000);
		 webtest.click("link=站点建议");
		 Thread.sleep(1000);
		 webtest.type("name=title",title);
		 Thread.sleep(1000);
		 webtest.type("name=content",content);
		 Thread.sleep(1000);
		 webtest.click("class=input_submit");
		 Assert.assertTrue(webtest.ifContains("你好"));
		 
	 }
	 @Test(priority=6)
	 //售后服务
	 public void shouhoufuwu() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=售后服务");
		 Assert.assertTrue(webtest.ifContains("退款订单"));
		 Thread.sleep(1000);
		 webtest.click("link=我的换货");
		 Assert.assertTrue(webtest.ifContains("换货订单"));
		 Thread.sleep(1000);
		 webtest.click("link=我的维修");
		 Assert.assertTrue(webtest.ifContains("维修订单"));
	 }
	 @Test(priority=7)
	 //商品咨询
	 public void shangpinzixun() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=商品咨询");
		 Assert.assertTrue(webtest.ifContains("内容"));
	}
	 @Test(priority=8)
	 //商品评价
	 public void shangpinpingjia() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=商品评价");
		 Thread.sleep(1000);
		 Assert.assertTrue(webtest.ifContains("购买时间"));
		 webtest.click("link=已评价");
		 Thread.sleep(1000);
		 Assert.assertTrue(webtest.ifContains("评论时间"));
	 }
	 @Test(priority=9)
	 //短信息
	 public void duanxinxi() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=短信息");
		 Assert.assertTrue(webtest.ifContains("标题"));
	 }
	 @Test(priority=10)
	 //收藏夹
	 public void shoucangjia() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=收藏夹");
		 Assert.assertTrue(webtest.ifContains("收藏夹")); 
	 }
	 @Test(priority=11)
	 //交易记录
	 public void jiaoyijilu() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=帐户余额");
		 Thread.sleep(1000);
		 Assert.assertTrue(webtest.ifContains("事件")); 
	 }
	 
	 
	 @DataProvider(name="test2")
	 public Object[][] createData2() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","tixian");
	 }
	 @Test(priority=12,dataProvider="test2")
	 //提现申请  amount不变，正确的一条，name英文一条，name特殊符号一条，note特殊符号一条，note英文一条，共5条
	 public void tixianshenqing(String name,String note) throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=帐户余额");
		 Thread.sleep(1000);
		 webtest.click("link=提现申请");
		 Thread.sleep(1000);
		 webtest.type("name=name",name);
		 Thread.sleep(1000);
		 webtest.type("name=amount","200");
		 Thread.sleep(1000);
		 webtest.type("name=note",note);
		 Thread.sleep(1000);
		 webtest.click("class=input_submit");
		 Thread.sleep(1000);
		 webtest.click("link=在线充值");
		 webtest.type("name=recharge","1000");
		 webtest.click("class=input_submit");
		 Thread.sleep(1000); 
		 Assert.assertTrue(webtest.ifContains("200")); 
	 }
	//数据驱动
	 @DataProvider(name="test3")
	 public Object[][] createData3() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","address");
	 }
	 @Test(dataProvider="test3",priority=13)
	 //地址管理之添加地址（8条）
	 public void myselfaddaddress(String accept_name,String province,String city,String area,
			 String address,String mobile,String telphone,String zip) throws InterruptedException, IOException{
//		添加地址
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=地址管理");
		 Thread.sleep(1000);
		 webtest.click("class=new_address_btn");
		 Thread.sleep(1000);
		 Thread.sleep(1000);
//		 webtest.enterFrame("OpenaddressWindow");
		 webtest.enterFrame(0);
		 Thread.sleep(1000);
		 webtest.type("name=accept_name",accept_name);
		 webtest.type("name=province",province);
		 Thread.sleep(1000);
		 webtest.type("name=city",city);
		 Thread.sleep(1000);
		 webtest.type("name=area",area);
		 Thread.sleep(1000);
		 webtest.type("name=address",address);
		 webtest.type("name=mobile",mobile);
		 webtest.type("name=telphone",telphone);
		 webtest.type("name=zip",zip);
		 webtest.leaveFrame();
		 webtest.click("xpath=//button[@type='button']");
		 Assert.assertTrue(webtest.ifContains("李璇")); 
	 }
	 
	 @Test(priority=14)
	 //地址管理之删除地址
	 public void deleteaddress() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=地址管理");
		 Thread.sleep(1000);
		 webtest.click("xpath=//div[3]/section[2]/div/section/section/table/tbody/tr[3]/td[6]/a[2]");
		 Thread.sleep(1000);
		 webtest.click("class=aui_state_highlight");
	 }

	 @Test(priority=15)
	 //个人资料
	 public void myselfchangeaddress() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=个人资料");
		 Thread.sleep(1000);
		 webtest.type("name=true_name","李璇");
		 Thread.sleep(1000);
		 webtest.type("name=province", "天津市");
		 Thread.sleep(1000);
		 webtest.type("name=city", "市辖区");
		 Thread.sleep(1000);
		 webtest.type("name=area", "河东区");
		 Thread.sleep(1000);
		 webtest.type("name=contact_addr","嗯嗯嗯"); 
		 Thread.sleep(1000);
		 webtest.click("xpath=//input[@value='保存修改']");
	 }
	 
	//数据驱动
	 @DataProvider(name="test4")
	 public Object[][] createData4() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","fapiao");
	 }
	 @Test(priority=16,dataProvider="test4")
	 //发票管理之新增发票(6个)
	 public void fapiaoguanli(String company_name,String taxcode,String address,
			 String telphone,String bankname,String bankno,String type) throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=发票管理");
		 Thread.sleep(1000);
		 webtest.click("class=new_address_btn");
		 Thread.sleep(1000);
		 webtest.enterFrame(0);
		 Thread.sleep(1000);
		 webtest.type("name=company_name",company_name);
		 webtest.type("name=taxcode",taxcode);
		 Thread.sleep(1000);
		 webtest.type("name=address",address);
		 Thread.sleep(1000);
		 webtest.type("name=telphone",telphone);
		 Thread.sleep(1000);
		 webtest.type("name=bankname",bankname);
		 webtest.type("name=bankno",bankno);
		 webtest.type("name=type",type);
		 webtest.leaveFrame();
		 webtest.click("xpath=//button[@type='button']");
		 Assert.assertTrue(webtest.ifContains("河北师范大学")); 
	 }
	 @Test(priority=17)
	 //发票管理之删除发票
	 public void deletefapiao() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(2000);
		 webtest.click("link=发票管理");
		 Thread.sleep(1000);
		 webtest.click("xpath=//div[3]/section[2]/div/section/section/table/tbody/tr[2]/td[4]/a[2]/i");
		 Thread.sleep(1000);
		 webtest.click("class=aui_state_highlight");
	 }
	 
	//数据驱动
	 @DataProvider(name="test5")
	 public Object[][] createData5() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","password");
	 }
	 @Test(priority=18,dataProvider="test5")
	 //修改密码(2条)
	 public void exchangepw(String fpassword,String password,String repassword) throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=修改密码");
		 Thread.sleep(1000);
		 webtest.type("name=fpassword", fpassword);
		 webtest.type("name=password", password);
		 webtest.type("name=repassword", repassword);
		 webtest.click("class=input_submit");
	 }
	 
	//数据驱动
	 @DataProvider(name="test6")
	 public Object[][] createData6() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","getdian");
	 }
	 @Test(priority=19,dataProvider="test6")
	 //申请开店(6个)
	 public void opendian(String seller_name,String password,String repassword,String true_name,String phone
			 ,String mobile,String email,String province,String city,String area,String address) throws InterruptedException{
		 webtest.click("link=申请开店");
		 Thread.sleep(1000);
		 webtest.type("name=seller_name",seller_name);
		 webtest.type("name=password",password);
		 webtest.type("name=repassword",repassword);
		 webtest.type("name=true_name",true_name);
		 webtest.type("xpath=//input[@type='file']","C:\\Users\\李璇\\Pictures\\Saved Pictures\\timg.jpg");
		 webtest.type("name=phone",phone);
		 webtest.type("name=mobile",mobile);
		 webtest.type("name=email",email);
		 webtest.type("name=province",province);
		 webtest.type("name=city",city);
		 webtest.type("name=area",area);
		 webtest.type("name=address",address);
		 webtest.click("class=input_submit");
		 Assert.assertTrue(webtest.ifContains("申请成功！请耐心等待管理员的审核"));
	 }
	 @Test(priority=20)
	 //商家管理、使用帮助的点击
	 public void shangjiaguanli() throws InterruptedException{
		 webtest.click("link=商家管理");
		 Thread.sleep(1000);
		 webtest.click("link=网站首页");
		 Thread.sleep(1000);
		 webtest.click("link=使用帮助");
	 }
	 @Test(priority=21)
	 //搜索框的搜索
	 public void search() throws InterruptedException{
		 webtest.type("name=word", "真皮女包");
		 webtest.click("class=search_submit");
	 }
		@Test(priority=22)
		//加入购物车
		public void add1() throws InterruptedException{
			webtest.click("xpath=//div[3]/section[3]/div/div[2]/a[2]/img");
//				webtest.click("class=reduce");
			webtest.click("class=add");
			webtest.click("class=add");
			webtest.click("xpath=//span[text()='加入购物车']");
		}
	 @Test(priority=23)
	 //购物车结算
	 public void jiesuan() throws InterruptedException{
		 webtest.click("class=go_cart");
		 Thread.sleep(1000);
		 webtest.click("class=gopay_btn");
		 webtest.type("name=message","加急加急");
		 webtest.click("name=taxes");
		 webtest.type("name=invoice_id","河北师范大学");
		 Thread.sleep(1000);
		 webtest.click("class=cart_topay_btn");
		 Thread.sleep(1000);
		 webtest.click("class=gobank_pay_btn");
	 }
		@Test(priority=24)
		//加入购物车
		public void add2() throws InterruptedException{
			webtest.click("xpath=//div[3]/section[3]/div/div[2]/a[2]/img");
//				webtest.click("class=reduce");
			webtest.click("class=add");
			webtest.click("class=add");
			webtest.click("xpath=//span[text()='加入购物车']");
		}
	 @Test(priority=25)
	 //清空购物车
	 public void qingkong() throws InterruptedException{
		 webtest.click("class=go_cart");
		 Thread.sleep(1000);
		 webtest.click("class=clear_cart_btn");
		 Thread.sleep(1000);
		 webtest.click("class=aui_state_highlight");
	 }
	 @Test(priority=26)
	 //继续购物
	 public void jixugouwu() throws InterruptedException{
		 webtest.click("class=go_cart");
		 Thread.sleep(1000);
		 webtest.click("class=go_back_btn");
	 }
	 @Test(priority=27)
	 //全部商品点击
	 public void allshangpn() throws InterruptedException{
		 webtest.click("link=家用电器");
		 webtest.click("link=首 页");
		 webtest.click("link=大家电");
		 webtest.click("link=首 页");
		 webtest.click("link=食品饮料");
		 webtest.click("link=首 页");
		 webtest.click("link=进口食品");
		 webtest.click("link=首 页");
		 webtest.click("link=家具");
		 webtest.click("link=首 页");
		 webtest.click("link=卧室家具");
		 webtest.click("link=首 页");
		 webtest.click("link=服装");
		 webtest.click("link=首 页");
		 webtest.click("link=男装");
		 webtest.click("link=首 页");
		 webtest.click("link=女装");
	 }

	 @Test(priority=28)
	 //轮播图下面图标点击
	 public void tubiao() throws InterruptedException, IOException{
		 String login1="/index.php?controller=site&action=sitemap";
		 String login2="/index.php?controller=site&action=seller";
		 String login3="/index.php?controller=site&action=brand";
		 String login4="/index.php?controller=site&action=sale";
		 String login5="/index.php?controller=site&action=help_list";
		 String login6="/index.php?controller=site&action=tags";
		 webtest.click("link=公 告");
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login1);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login2);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login3);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login4);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login5);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login6);
		 webtest.click("link=资 讯");
	 }
	@Test(priority=29)
	//进口食品价格范围输入
	public void foodcart() throws InterruptedException, IOException{
		webtest.click("link=进口食品");
		webtest.type("name=min_price","1000");
		webtest.type("name=max_price","2000");
		webtest.click("link=确定");
	}

}

