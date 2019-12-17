package azhouqianqian;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.utils.ReadProperties;

/*
 * 5��
 */
@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class ExchangePoints extends BaseTest{
/*
 * ͨ�����ֶһ�ģ�飬�ύ��Ʒ����
 */
	@Test
	//��ת����Ʒ����ҳ
	public void test1() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("xpath=//h3[text()='�һ�����']");
//		����
		Assert.assertTrue(webtest.ifContains("����һ�����"));
	}
/*
 * �ύ��������
 */	
	
	@Test
	//ʹ�û�����������1ƿ����
	public void test2() throws InterruptedException, IOException{
//		��¼
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=��¼");
		webtest.type("name=login_info", "zhouqian");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='��¼']");
//		�ص���ҳ
		webtest.click("link=��ҳ");
		webtest.click("xpath=//h3[text()='�һ�����']");
		Assert.assertTrue(webtest.ifContains("����һ�����"));
//		��������
		webtest.click("id=buyNowButton");
		Assert.assertTrue(webtest.ifContains("��д�˶Զ�����Ϣ"));
//		�ύ����
		webtest.click("xpath=//span[text()='ȷ�������ύ����']");
		Assert.assertTrue(webtest.ifContains("�������ύ"));
	}
	
/*
 * �޸ĵ�ַ
 */
	@Test
	//ʹ�û�����������1ƿ����
	public void test3() throws InterruptedException, IOException{
//		��¼
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=��¼");
		webtest.type("name=login_info", "zhouqian");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='��¼']");
//		�ص���ҳ
		webtest.click("link=��ҳ");
		webtest.click("xpath=//h3[text()='�һ�����']");
		Assert.assertTrue(webtest.ifContains("����һ�����"));
//		��������
		webtest.click("id=buyNowButton");
		Assert.assertTrue(webtest.ifContains("��д�˶Զ�����Ϣ"));
//		�޸ĵ�ַ
		webtest.click("xpath=//span[contains(text(),'�޸ĵ�ַ')]");
		Thread.sleep(3000);
		webtest.enterFrame("OpenaddressWindow");
		webtest.typeAndClear("name=address", "�ӱ�ʦ����ѧ");
		webtest.leaveFrame();
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.ifContains("�ӱ�ʦ����ѧ"));
//		�ύ����
		webtest.click("xpath=//span[text()='ȷ�������ύ����']");
		Assert.assertTrue(webtest.ifContains("�������ύ"));
	}
	
	/*
	 * �޸�����
	 */
		@Test
		//ʹ�û�����������2ƿ����
		public void test4() throws InterruptedException, IOException{
//			��¼
			webtest.open(ReadProperties.getPropertyValue("base_url"));
			webtest.click("link=��¼");
			webtest.type("name=login_info", "zhouqian");
			webtest.type("name=password", "123456");
			webtest.click("xpath=//input[@value='��¼']");
//			�ص���ҳ
			webtest.click("link=��ҳ");
			webtest.click("xpath=//h3[text()='�һ�����']");
			Assert.assertTrue(webtest.ifContains("����һ�����"));
//			������һ��������һ��������һ
			webtest.click("id=buyAddButton");
			webtest.click("id=buyAddButton");
			webtest.click("id=buyReduceButton");
//			��������
			webtest.click("id=buyNowButton");
			Assert.assertTrue(webtest.ifContains("��д�˶Զ�����Ϣ"));
//			�ύ����
			webtest.click("xpath=//span[text()='ȷ�������ύ����']");
			Assert.assertTrue(webtest.ifContains("�������ύ"));
		}
		
/*
 * ��ʾ�û����ֲ���
 */
		@Test
		public void test5() throws InterruptedException, IOException{
//			��¼
			webtest.open(ReadProperties.getPropertyValue("base_url"));
			webtest.click("link=��¼");
			webtest.type("name=login_info", "lixuan");
			webtest.type("name=password", "123456");
			webtest.click("xpath=//input[@value='��¼']");
//			�ص���ҳ
			webtest.click("link=��ҳ");
			webtest.click("xpath=//h3[text()='�һ�����']");
			Assert.assertTrue(webtest.ifContains("����һ�����"));
//			��������
			webtest.click("id=buyNowButton");
			Assert.assertTrue(webtest.ifContains("�û����ֲ���"));
			
		}
}


