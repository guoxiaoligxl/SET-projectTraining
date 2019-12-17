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
		//��̨��¼
	public void testBackstageLogin() throws IOException{
//		BaseUrl base=new BaseUrl();
//		webtest.open(base.getBaseUrl());
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=��̨����");
		webtest.type("name=admin_name","admin");
		webtest.type("name=password", "123456");
		webtest.type("name=captcha","111" );
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("admin"));
	}
	@Test(dataProvider="addGoods")
	//�����Ʒ�б�(4)
	public void testAddGoods(String goodsname,String point,String sort,String exp,String goodsno,String storenum,String marketprice,String sellprice){
		webtest.click("link=��Ʒ");
		//�����Ӱ�ť
		webtest.click("link=���");
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
	//�����¼�(3)
	public void testBatchOperation(String id1,String id2){
		webtest.click("link=��Ʒ");
		//ѡ��������������Ʒ
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		//��������б�
		webtest.clickForList("tag=button",2);
		//ѡ���¼�
		webtest.click("link=�¼�");
		//���ȷ��
		webtest.click("class=aui_state_highlight");
		Assert.assertTrue(webtest.ifContains("�¼�"));
	}
	@Test(dataProvider="goodsId")
	//��������(3)
	public void testLotPending(String id1,String id2){
		//�����Ʒ��ť
		webtest.click("link=��Ʒ");
		//ѡ��������������Ʒ
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		//��������б�
		webtest.clickForList("tag=button",2);
		//ѡ�����
		webtest.click("link=����");
		//���ȷ��
		webtest.click("class=aui_state_highlight");
		
		Assert.assertTrue(webtest.ifContains("����"));
	}
	@Test(dataProvider="goodsId")
	//��Ʒ����(3)
	public void testShareGoods(String id1,String id2){
		//�����Ʒ��ť
		webtest.click("link=��Ʒ");
		//ѡ��������������Ʒ
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		//��������б�
		webtest.clickForList("tag=button",2);
		//ѡ����Ʒ����
		webtest.click("link=��Ʒ����");
	}
	
	
	
	@Test(dataProvider="goodsId")
	public void testEdit(String id1,String id2) throws InterruptedException{
		webtest.click("link=��Ʒ");
		//ѡ��������������Ʒ
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		
		//��������༭�İ�ť
		webtest.click("link=�����༭");
		webtest.enterFrame("Opengoods_setting");
		//������÷���
		webtest.click("xpath=//input[@type='radio']");
		webtest.type("xpath=//input[@name='market_price']","10");
	}
	
	
	@Test
	//�鿴��Ʒ����ķ����б�
	public void testClassificationList(){
		//�����Ʒ��ť
		webtest.click("link=��Ʒ");
		//�����Ʒ���ఴť
		webtest.click("xpath=//span[text()='��Ʒ����']");
		webtest.click("link=�����б�");
		Assert.assertTrue(webtest.ifContains("��������"));
	}
	@Test(dataProvider="goodsClassificationList")
	//�����Ʒ����(4)
	public void addClassificationList(String name) throws InterruptedException{
		//�����Ʒ��ť
		webtest.click("link=��Ʒ");
		//�����Ʒ���ఴť
		webtest.click("xpath=//span[text()='��Ʒ����']");
		//�����ӷ��ఴť
		webtest.click("link=��ӷ���");
		//��д��������
		webtest.type("xpath=//input[@type='text']",name);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains(name));
	}
	@Test
	//�鿴Ʒ�Ʒ���
	public void testViewBrandClassification(){
		webtest.click("link=��Ʒ");
		webtest.click("xpath=//span[text()='Ʒ��']");
		webtest.click("link=Ʒ�Ʒ���");
		Assert.assertTrue(webtest.ifContains("��������"));

	}
	@Test(dataProvider="classificationList")
	//���Ʒ�Ʒ���(4)
	public void addBrandClassification(String name){
		webtest.click("link=��Ʒ");
		webtest.click("xpath=//span[text()='Ʒ��']");
		webtest.click("link=Ʒ�Ʒ���");
		webtest.click("link=��ӷ���");
		webtest.type("xpath=//input[@name='name']",name);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains(name));

	}
	@Test
	//�鿴Ʒ���б�
	public void testViewBrandList(){
		webtest.click("link=��Ʒ");
		webtest.click("xpath=//span[text()='Ʒ��']");
		webtest.click("link=Ʒ���б�");
		Assert.assertTrue(webtest.ifContains("Ʒ������"));

	}
	@Test(dataProvider="brandList")
	//���Ʒ���б�(4)
	public void addBrandList(String brandname,String url){
		//�����Ʒ��ť
		webtest.click("link=��Ʒ");
		//���Ʒ�ư�ť
		webtest.click("xpath=//span[text()='Ʒ��']");
		//���Ʒ���б�ť
		webtest.click("link=Ʒ���б�");
		//������Ʒ��
		webtest.click("link=���Ʒ��");
		//����Ʒ�����ƺ���ַ
		webtest.type("xpath=//input[@name='name']",brandname);
		webtest.type("xpath=//input[@name='url']",url);
		//���ȷ����ť
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains(brandname));
	}
	@Test
	//�鿴ģ���б�
	public void testViewModelList(){
		webtest.click("link=��Ʒ");
		webtest.click("xpath=//span[text()='ģ��']");
		webtest.click("link=ģ���б�");
	}
	@Test(dataProvider="modelName")
	//���ģ��(4)
	public void addModelList(String name){
		webtest.click("link=��Ʒ");
		webtest.click("xpath=//span[text()='ģ��']");
		webtest.click("link=ģ���б�");
		webtest.click("link=���ģ��");
		webtest.type("xpath=//input[@name='model_name']",name);
		webtest.click("xpath=//button[@type='submit']");
	}
	@Test(dataProvider="modelId")
	//����ɾ��ģ���б�(3)
	public void testBatchDeletionModelList(String id1,String id2){
		webtest.click("link=��Ʒ");
		webtest.click("xpath=//span[text()='ģ��']");
		webtest.click("link=ģ���б�");
		webtest.click("xpath=//input[@value='"+id1+"']");
		webtest.click("xpath=//input[@value='"+id2+"']");
		webtest.clickForList("tag=a",35);
		webtest.click("xpath=//button[text()='ȷ��']");
	}
	@Test
	//�鿴����б�(4)
	public void testViewSizeList(){
		webtest.click("link=��Ʒ");
		webtest.click("xpath=//span[text()='ģ��']");
		webtest.click("link=����б�");
		Assert.assertTrue(webtest.ifContains("�������"));
	}
	@Test(dataProvider="sizeList")
	//��ӹ���б�(5)
	public void testAddSizeList(String name,String show,String data){
		webtest.click("link=��Ʒ");
		webtest.click("xpath=//span[text()='ģ��']");
		webtest.click("link=����б�");
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


