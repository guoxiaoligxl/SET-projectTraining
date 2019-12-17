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
	@Test(priority=41)//ͨ����ַ���� ��̨�����¼ҳ��
	public void login() throws InterruptedException, IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		webtest.type("name=admin_name","admin");
		webtest.type("name=password","123456");
		webtest.type("name=captcha","a");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.ifContains("admin"));
	}
	
	//ϵͳ
	//ϵͳ��ҳ
	@Test(priority=42)
	public void xitong(){
		webtest.click("link=ϵͳ");
		webtest.click("link=��ҳ");
	    Assert.assertTrue(webtest.ifContains("��ҳ"));
	}
	
//	//��վ��������
	@Test(priority=43)
	public void netset() throws InterruptedException{
		webtest.click("link=��վ����");
		webtest.click("link=��վ����");
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
	
	//ʹ�����������������ͷ�ʽ�����
	@DataProvider(name="test1")
	public Object[][] createData1() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet2");
	}
	
	@Test(priority=44,dataProvider="test1")//������ͷ�ʽ
	public void delivery(String name,String first_price,String second_weight,
			String second_price,String sort,String description) throws InterruptedException{
		webtest.click("link=���͹���");
		webtest.click("link=���ͷ�ʽ");
		webtest.click("link=������ͷ�ʽ");
		webtest.type("name=name",name);
		webtest.type("name=first_price",first_price);
		webtest.type("name=second_weight",second_weight);
		webtest.type("name=second_price",second_price);
		webtest.type("name=sort",sort);
		webtest.click("xpath=//input[@value='1']");
		webtest.type("name=description",description);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("������ͷ�ʽ"));
	}
	
	//ʹ��������������������˾�����
		@DataProvider(name="test2")
		public Object[][] createData2() throws IOException{
			ExcelDataProvider provider=new ExcelDataProvider();
			return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet4");
		}
		
		@Test(priority=45,dataProvider="test2")//���������˾
		public void freight(String freight_type,String freight_name,String url,String sort) throws InterruptedException{
			webtest.click("link=���͹���");
			webtest.click("link=������˾");
			webtest.click("link=���������˾");
			webtest.type("name=freight_type",freight_type);
			webtest.type("name=freight_name",freight_name);
			webtest.type("name=url",url);
			webtest.type("name=sort",sort);
			webtest.click("xpath=//button[@type='submit']");
			Assert.assertTrue(webtest.ifContains("������˾"));
		}
	
	//ʹ���������������Զ��������
	@DataProvider(name="test3")
	public Object[][] createData3() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet3");
	}
	
	@Test(priority=46,dataProvider="test3")//��������
	public void takeself(String name,String pic,String province,String city,
			String area,String address,String phone,String mobile,String sort) throws InterruptedException{
		webtest.click("link=���͹���");
		webtest.click("link=��������");
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
	
	//����
	//���ݿ�
	@Test(priority=47)
	public void db(){
		webtest.click("link=����");
		webtest.click("link=���ݿ⻹ԭ");
		Assert.assertTrue(webtest.ifContains("���ݿ⻹ԭ"));
	}
	
	//���¹���
	//ʹ�����������������·�������
	@DataProvider(name="test4")
	public Object[][] createData4() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet5");
	}
	
	@Test(priority=48,dataProvider="test4")//������·���
	public void addarticle(String name,String sort) throws InterruptedException{
		webtest.click("link=����");
		webtest.click("link=���¹���");
		webtest.click("link=���·���");
		webtest.click("link=��ӷ���");
		webtest.type("name=name",name);
		webtest.click("xpath=//input[@value='1']");
		webtest.type("name=sort",sort);
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("name"));
	}
	
	
	//����
	//���õ��޸�����
	@DataProvider(name="test5")
	public Object[][] createData() throws IOException{
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("D:\\kejian\\softwaretest\\shixun\\login.xlsx","sheet6");
	}
	@Test(priority=49,dataProvider="test5")
	public void setpassowrd(String password,String repassword) throws InterruptedException {
		webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
		webtest.click("link=�޸�����");
		Thread.sleep(2000);
		webtest.type("name=password",password);
		webtest.type("name=repassword",repassword);
		webtest.click("xpath=//button[@type='submit']");
	}
	
	//���õĺ�̨��ҳ
	@Test(priority=50)
	public void setback() throws InterruptedException{
		webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
		webtest.click("link=��̨��ҳ");
		Thread.sleep(2000);
	}
	
	//���õ��̳���ҳ
	@Test(priority=51)
	public void setshop() throws InterruptedException{
		webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
		webtest.click("link=�̳���ҳ");
		Thread.sleep(2000);
	}
	
	//���õĿ��ٵ���
		@Test(priority=52)
		public void setnav() throws InterruptedException{
			webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
			webtest.click("link=���ٵ���");
			Thread.sleep(2000);
			webtest.click("link=��ӿ��ٵ���");
			webtest.type("name=naviga_name","����");
			webtest.type("name=url","another/index");	
			webtest.click("xpath=//button[@type='submit']");
		}
	//���õ��˳�����
	@Test(priority=53)
	public void setquit() throws InterruptedException {
		webtest.click("xpath=//div[2]/header/nav/div/ul/li[9]/a/i");
		webtest.click("link=�˳�����");
		Thread.sleep(2000);
		webtest.type("name=admin_name","admin");
		webtest.type("name=password","123456");
		webtest.type("name=captcha","a");
		webtest.click("xpath=//button[@type='submit']");
	}
}


