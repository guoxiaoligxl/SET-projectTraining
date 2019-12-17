package zhangfan;

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
public class BackStageTest extends BaseTest{
	@DataProvider(name="addGoods")
	public Object[][] createData1() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "goods");
	}
	@DataProvider(name="goodsId")
	public Object[][] createData2() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "goodsid");
	}
	@DataProvider(name="modelId")
	public Object[][] createData3() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "modelid");
	}
	@DataProvider(name="modelName")
	public Object[][] createData4() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "modelname");
	}
	@DataProvider(name="sizeList")
	public Object[][] createData5() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "sizelist");
	}
	@DataProvider(name="brandList")
	public Object[][] createData6() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "brandlist");
	}
	@DataProvider(name="classificationList")
	public Object[][] createData7() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "classificationlist");
	}
	@DataProvider(name="goodsClassificationList")
	public Object[][] createData8() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\data.xlsx", "goodsclassificationlist");
	}
	@BeforeMethod
		//后台登录
	public void testBackstageLogin() throws IOException{
//		BaseUrl base=new BaseUrl();
//		webtest.open(base.getBaseUrl());
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=后台管理");
		webtest.type("name=admin_name","admin");
		webtest.type("name=password", "123456");
		webtest.type("name=captcha","111" );
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("admin"));
	}
	@Test(dataProvider="addGoods")
	//添加商品列表(4)
	public void testAddGoods(String goodsname,String point,String sort,String exp,String goodsno,String storenum,String marketprice,String sellprice){
		webtest.click("link=商品");
		//点击添加按钮
		webtest.click("link=添加");
		webtest.type("name=name", goodsname);
		webtest.typeAndClear("name=point",point);
		webtest.typeAndClear("name=sort", sort);
		webtest.typeAndClear("name=exp", exp);
		webtest.typeAndClear("name=_goods_no[0]",goodsno);
		webtest.typeAndClear("name=_store_nums[0]",storenum);
		webtest.typeAndClear("name=_market_price[0]", marketprice);
		webtest.typeAndClear("name=_sell_price[0]",sellprice);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains(goodsname));
	}
	@Test(dataProvider="goodsId")
	//批量下架(3)
	public void testBatchOperation(String id1,String id2){
		webtest.click("link=商品");
		//选中批量操作的商品
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		//点击下拉列表
		webtest.clickForList("tag=button",2);
		//选择下架
		webtest.click("link=下架");
		//点击确定
		webtest.click("class=aui_state_highlight");
		Assert.assertTrue(webtest.ifContains("下架"));
	}
	@Test(dataProvider="goodsId")
	//批量待审(3)
	public void testLotPending(String id1,String id2){
		//点击商品按钮
		webtest.click("link=商品");
		//选中批量操作的商品
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		//点击下拉列表
		webtest.clickForList("tag=button",2);
		//选择待审
		webtest.click("link=待审");
		//点击确定
		webtest.click("class=aui_state_highlight");
		
		Assert.assertTrue(webtest.ifContains("待审"));
	}
	@Test(dataProvider="goodsId")
	//商品共享(3)
	public void testShareGoods(String id1,String id2){
		//点击商品按钮
		webtest.click("link=商品");
		//选中批量操作的商品
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		//点击下拉列表
		webtest.clickForList("tag=button",2);
		//选择商品共享
		webtest.click("link=商品共享");
	}
	
	
	
	@Test(dataProvider="goodsId")
	public void testEdit(String id1,String id2) throws InterruptedException{
		webtest.click("link=商品");
		//选中批量操作的商品
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		
		//点击批量编辑的按钮
		webtest.click("link=批量编辑");
		webtest.enterFrame("Opengoods_setting");
		//点击设置分类
		webtest.click("xpath=//input[@type='radio']");
		webtest.type("xpath=//input[@name='market_price']","10");
	}
	
	
	@Test
	//查看商品分类的分类列表
	public void testClassificationList(){
		//点击商品按钮
		webtest.click("link=商品");
		//点击商品分类按钮
		webtest.click("xpath=//span[text()='商品分类']");
		webtest.click("link=分类列表");
		Assert.assertTrue(webtest.ifContains("分类名称"));
	}
	@Test(dataProvider="goodsClassificationList")
	//添加商品分类(4)
	public void addClassificationList(String name) throws InterruptedException{
		//点击商品按钮
		webtest.click("link=商品");
		//点击商品分类按钮
		webtest.click("xpath=//span[text()='商品分类']");
		//点击添加分类按钮
		webtest.click("link=添加分类");
		//填写分类名称
		webtest.type("xpath=//input[@type='text']",name);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains(name));
	}
	@Test
	//查看品牌分类
	public void testViewBrandClassification(){
		webtest.click("link=商品");
		webtest.click("xpath=//span[text()='品牌']");
		webtest.click("link=品牌分类");
		Assert.assertTrue(webtest.ifContains("分类名称"));

	}
	@Test(dataProvider="classificationList")
	//添加品牌分类(4)
	public void addBrandClassification(String name){
		webtest.click("link=商品");
		webtest.click("xpath=//span[text()='品牌']");
		webtest.click("link=品牌分类");
		webtest.click("link=添加分类");
		webtest.type("xpath=//input[@name='name']",name);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains(name));

	}
	@Test
	//查看品牌列表
	public void testViewBrandList(){
		webtest.click("link=商品");
		webtest.click("xpath=//span[text()='品牌']");
		webtest.click("link=品牌列表");
		Assert.assertTrue(webtest.ifContains("品牌名称"));

	}
	@Test(dataProvider="brandList")
	//添加品牌列表(4)
	public void addBrandList(String brandname,String url){
		//点击商品按钮
		webtest.click("link=商品");
		//点击品牌按钮
		webtest.click("xpath=//span[text()='品牌']");
		//点击品牌列表按钮
		webtest.click("link=品牌列表");
		//点击添加品牌
		webtest.click("link=添加品牌");
		//输入品牌名称和网址
		webtest.type("xpath=//input[@name='name']",brandname);
		webtest.type("xpath=//input[@name='url']",url);
		//点击确定按钮
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains(brandname));
	}
	@Test
	//查看模型列表
	public void testViewModelList(){
		webtest.click("link=商品");
		webtest.click("xpath=//span[text()='模型']");
		webtest.click("link=模型列表");
	}
	@Test(dataProvider="modelName")
	//添加模型(4)
	public void addModelList(String name){
		webtest.click("link=商品");
		webtest.click("xpath=//span[text()='模型']");
		webtest.click("link=模型列表");
		webtest.click("link=添加模型");
		webtest.type("xpath=//input[@name='model_name']",name);
		webtest.click("xpath=//button[@type='submit']");
	}
	@Test(dataProvider="modelId")
	//批量删除模型列表(3)
	public void testBatchDeletionModelList(String id1,String id2){
		webtest.click("link=商品");
		webtest.click("xpath=//span[text()='模型']");
		webtest.click("link=模型列表");
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		webtest.clickForList("tag=a",35);
		webtest.click("xpath=//button[text()='确定']");
	}
	@Test
	//查看规格列表(4)
	public void testViewSizeList(){
		webtest.click("link=商品");
		webtest.click("xpath=//span[text()='模型']");
		webtest.click("link=规格列表");
		Assert.assertTrue(webtest.ifContains("规格名称"));
	}
	@Test(dataProvider="sizeList")
	//添加规格列表(5)
	public void testAddSizeList(String name,String show,String data){
		webtest.click("link=商品");
		webtest.click("xpath=//span[text()='模型']");
		webtest.click("link=规格列表");
		webtest.clickForList("tag=a",33);
		webtest.enterFrame("OpenaddSpecWin");
		webtest.type("xpath=//input[@name='name']",name);
		webtest.click("xpath=//button[@class='btn btn-default']");
		webtest.type("xpath=//input[@name='showText[]']",show);
		webtest.type("xpath=//input[@name='valueData[]']",data);
		webtest.leaveFrame();
		webtest.click("xpath=//button[@class=' aui_state_highlight']");

	}
	
}


