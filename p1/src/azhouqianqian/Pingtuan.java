package azhouqianqian;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

/*
 * 5��
 */
@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class Pingtuan extends BaseTest {
	/*
	 *  ��ҳ��ת����(��ƴ����Ʒ)
	 */
	@Test()
	public void test_jump1() {
//		ƴ��ҳ����ת
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=����>");
//		����
		System.out.println(webtest.isElementPresent("xpath=//strong[contains(text(),'ƴ�Ż')]"));
		if (webtest.isElementPresent("xpath=//strong[contains(text(),'ƴ�Ż')]") == true) {
			assert true;
		} else {
			assert false : "��תʧ��";
		}
//		������һ��
		webtest.click("link=������һ������");
		Assert.assertTrue(webtest.ifContains("ƴ����Ʒ"));
	
	}
	
	@Test()
	public void test_jump2() {
//		ƴ��ҳ����ת
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=����>");
//		����
		System.out.println(webtest.isElementPresent("xpath=//strong[contains(text(),'ƴ�Ż')]"));
		if (webtest.isElementPresent("xpath=//strong[contains(text(),'ƴ�Ż')]") == true) {
			assert true;
		} else {
			assert false : "��תʧ��";
		}
//		��ת����վ��ҳ
		webtest.click("link=��վ��ҳ");
		Assert.assertTrue(webtest.ifContains("��ҳ"));
	}
	
	@Test()
	public void test_jump3() throws IOException {
//		ƴ��ҳ����ת
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=����>");
//		����
		System.out.println(webtest.isElementPresent("xpath=//strong[contains(text(),'ƴ�Ż')]"));
		if (webtest.isElementPresent("xpath=//strong[contains(text(),'ƴ�Ż')]") == true) {
			assert true;
		} else {
			assert false : "��תʧ��";
		}
//		��ת���ҵĶ���
		webtest.click("link=�ҵĶ���");
		Assert.assertTrue(webtest.ifContains("�ҵĶ���"));
	}
	
	@Test()
	public void test_jump4() {
//		ƴ��ҳ����ת
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("link=����>");
//		����
		System.out.println(webtest.isElementPresent("xpath=//strong[contains(text(),'ƴ�Ż')]"));
		if (webtest.isElementPresent("xpath=//strong[contains(text(),'ƴ�Ż')]") == true) {
			assert true;
		} else {
			assert false : "��תʧ��";
		}
//		��ת���ҵĹ��ﳵ
		webtest.click("link=�ҵĹ��ﳵ");
		Assert.assertTrue(webtest.ifContains("���ﳵ"));
	}
	
/*
 * ���Ź���
 */
	@Test()
	public void test_buy() throws IOException {
//		ƴ��ҳ����ת
//		��¼
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=��¼");
		webtest.type("name=login_info", "zhouqian");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='��¼']");
//		�ص���ҳ
		webtest.click("link=��ҳ");
//		����ƴ����Ʒҳ
		webtest.click("xpath=//h3[text()='����']");
		Assert.assertTrue(webtest.ifContains("����"));
//		������Ʒ����ҳ
		webtest.click("xpath=//span[text()='����']");
//		����ƴ��
		webtest.click("��Ҫ����");
//		�ύ����
		webtest.click("xpath=//span[text()='ȷ�������ύ����']");
		Assert.assertTrue(webtest.ifContains("�������ύ"));
		
	}
}


