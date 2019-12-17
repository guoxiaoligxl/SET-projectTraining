package guoxiaoli;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class Demo extends BaseTest {
	
	@BeforeMethod()
	public void login1() throws InterruptedException {
		  webtest.open("http://localhost:8067/iWebShop5.6/");
		  webtest.click("link=��¼");
		  Thread.sleep(2000);
		  webtest.type("name=login_info","password");
		  webtest.type("name=password","123456");
		  webtest.click("class=input_submit");
		  webtest.click("link=��ҳ");
		  Thread.sleep(2000);
		  Assert.assertTrue(webtest.ifContains("password"));
	}
	
	@Test(priority=31)//ʳƷ���빺�ﳵ
	public void foodcart() throws InterruptedException, IOException{
		webtest.click("link=����ʳƷ");
		webtest.type("name=min_price","10");
		webtest.type("name=max_price","100");
		//webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=6");
		Thread.sleep(2000);
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='���빺�ﳵ']");
		Thread.sleep(2000);
		webtest.click("link=��ҳ");
		webtest.mouseoverElement("link=password");
		webtest.click("link=�˳���¼");
		Assert.assertTrue(webtest.ifContains("��ҳ"));
	}
	@Test(priority=32)//ʳƷ����
	public void foodbuy() throws InterruptedException, IOException{
		webtest.click("link=����ʳƷ");
		webtest.type("name=min_price","10");
		webtest.type("name=max_price","100");
		//webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=6");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='��������']");
		webtest.click("name=taxes");
		webtest.type("name=invoice_id","dx");
		webtest.click("xpath=//span[text()='ȷ�������ύ����']");
//		webtest.click("xpath=//span[text()='����֧��']");
//		Thread.sleep(2000);
//		webtest.enterFrame(0);
//		webtest.click("xpath=//button[@type='button']");
//		webtest.leaveFrame();
		webtest.click("link=��ҳ");
		Assert.assertTrue(webtest.ifContains("dx"));
	}
	
	@Test(priority=33)//�Ҿ߼��빺�ﳵ
	public void jiajucart() throws InterruptedException, IOException{
		webtest.click("link=��װ����");
		webtest.type("name=min_price","1000");
		webtest.type("name=max_price","5000");
		//webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=189");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='���빺�ﳵ']");
		Thread.sleep(2000);
		webtest.click("link=��ҳ");
		webtest.mouseoverElement("link=password");
		webtest.click("link=�˳���¼");
		Assert.assertTrue(webtest.ifContains("��ҳ"));
	}
	@Test(priority=34)//�Ҿ߹���
	public void jiajubuy() throws InterruptedException, IOException{
		webtest.click("link=��װ����");
		webtest.type("name=min_price","1000");
		webtest.type("name=max_price","5000");
		//webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=189");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='��������']");
		webtest.click("name=taxes");
		webtest.type("name=invoice_id","dx");
		webtest.click("xpath=//span[text()='ȷ�������ύ����']");
//		webtest.click("xpath=//span[text()='����֧��']");
//		Thread.sleep(2000);
//		webtest.enterFrame(0);
//		webtest.click("xpath=//button[@type='button']");
//		webtest.leaveFrame();
		webtest.click("link=��ҳ");
		webtest.mouseoverElement("link=password");
		webtest.click("link=�˳���¼");
		Assert.assertTrue(webtest.ifContains("dx"));
	}
	
	@Test(priority=35)//Ů�����빺�ﳵ
	public void bagcart() throws InterruptedException, IOException{
		webtest.click("link=Ů��");
		webtest.type("name=min_price","300");
		webtest.type("name=max_price","500");
//		webtest.click("onclick=priceLink();");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=48");
		//webtest.click("class=reduce");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='���빺�ﳵ']");
		Thread.sleep(2000);
		webtest.click("link=��ҳ");
		webtest.mouseoverElement("link=password");
		webtest.click("link=�˳���¼");
		Assert.assertTrue(webtest.ifContains("��ҳ"));
	}
	
	@Test(priority=36)//Ů������
	public void bagbuy() throws InterruptedException, IOException{
		webtest.click("link=Ů��");
		webtest.type("name=min_price","300");
		webtest.type("name=max_price","500");
		webtest.click("onclick=priceLink();");
		webtest.open(ReadProperties.getPropertyValue("base_url")+"/index.php?controller=site&action=products&id=48");
		webtest.click("class=add");
		webtest.click("xpath=//span[text()='��������']");
		Thread.sleep(2000);
		webtest.click("name=taxes");
		webtest.type("name=invoice_id","dx");
		webtest.click("xpath=//span[text()='ȷ�������ύ����']");
//		webtest.click("xpath=//span[text()='����֧��']");
//		Thread.sleep(2000);
//		webtest.enterFrame(0);
//		webtest.click("xpath=//button[@type='button']");
//		webtest.leaveFrame();
		webtest.click("link=��ҳ");
		webtest.mouseoverElement("link=password");
		webtest.click("link=�˳���¼");
		Assert.assertTrue(webtest.ifContains("dx"));
	}
	
	@Test(priority=37)//�����̨����
	public void backstage() throws InterruptedException{
		webtest.click("link=��̨����");
		webtest.type("name=admin_name","admin");
		webtest.type("name=password","123456");
		webtest.type("name=captcha","a");
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.ifContains("admin"));
	}
	
}





