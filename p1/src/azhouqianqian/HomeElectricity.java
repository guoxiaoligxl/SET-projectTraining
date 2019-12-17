package azhouqianqian;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

/*
 * 10��
 */
@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class HomeElectricity extends BaseTest{
/*
 *��תҳ��
 */

	@Test
//	��ת�����õ�����Ʒ����ҳ 
	public void test_jump1() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("xpath=//div[3]/section[7]/header/a");
		Assert.assertTrue(webtest.ifContains("���õ���"));
	}
	
	@Test
//	��ת�����õ�������ҵ硱��Ʒչʾģ��
	public void test_jump2() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("xpath=//div[3]/section[7]/header/nav/ul/li[1]/a");
		Assert.assertTrue(webtest.ifContains("��ҵ�"));
	}
	
	@Test
//	��ת�����õ����������������Ʒչʾģ��
	public void test_jump3(){
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("xpath=//div[3]/section[7]/header/nav/ul/li[2]/a");
		Assert.assertTrue(webtest.ifContains("�������"));
	}
	
	@Test
//	��ת�����õ�����������������Ʒչʾģ��
	public void test_jump4(){
		webtest.open("http://localhost:8067/iWebShop5.6/");
		webtest.click("xpath=//div[3]/section[7]/header/nav/ul/li[3]/a");
		Assert.assertTrue(webtest.ifContains("��������"));
	}
	
/*
 * ��ͬ�۸�������ʾ��ͬ��Ʒ
 */
	
	@Test
//	3000-4999
	public void test_sort1_money() throws IOException{
//		������Ʒ����ҳ
		webtest.open(ReadProperties.getPropertyValue("base_url"));
//		webtest.click("xpath=//div[3]/section[7]/header/a");
		webtest.clickForList("link=����>", 2);
		Assert.assertTrue(webtest.ifContains("���õ���"));
		webtest.click("link=3000-4999");
		Assert.assertTrue(webtest.ifContains("3879"));
	}
	
	@Test
//	�Զ������䣨3500-3900��
	public void test_sort2_money() throws IOException{
//		������Ʒ����ҳ
		webtest.open(ReadProperties.getPropertyValue("base_url"));
//		webtest.click("xpath=//div[3]/section[7]/header/a");
		webtest.clickForList("link=����>", 2);
		Assert.assertTrue(webtest.ifContains("���õ���"));
		webtest.type("name=min_price","3500");
		webtest.type("name=max_price","3900");
		webtest.clickForList("tag=button", 1);
		Assert.assertTrue(webtest.ifContains("3879"));
	}
	
	@Test
//	��ת�����õ�������ҵ硱��Ʒչʾģ�� ����������������
	public void test_order1() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.clickForList("link=����>", 2);
		Assert.assertTrue(webtest.ifContains("���õ���"));
		webtest.click("link=��ҵ�");
		Assert.assertTrue(webtest.ifContains("��ҵ�"));
		webtest.click("link=����");
	}
	
	@Test
//	��ת�����õ�����������������Ʒչʾģ�� ���ռ۸���������
	public void test_order2() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.clickForList("link=����>", 2);
		Assert.assertTrue(webtest.ifContains("���õ���"));
		webtest.click("link=��������");
		Assert.assertTrue(webtest.ifContains("��������"));
		webtest.click("link=�۸�");
	}
	
	@Test
//	��ת�����õ����������������Ʒչʾģ�� ����������������
	public void test_order3() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.clickForList("link=����>", 2);
		Assert.assertTrue(webtest.ifContains("���õ���"));
		webtest.click("link=�������");
		Assert.assertTrue(webtest.ifContains("�������"));
		webtest.click("link=����");
	}
	
	@Test
//	�Զ������䣨3500-3900�����������ϼ�˳��������
	public void test_order4() throws IOException{
//		������Ʒ����ҳ
		webtest.open(ReadProperties.getPropertyValue("base_url"));
//		webtest.click("xpath=//div[3]/section[7]/header/a");
		webtest.clickForList("link=����>", 2);
		Assert.assertTrue(webtest.ifContains("���õ���"));
		webtest.type("name=min_price","3500");
		webtest.type("name=max_price","3900");
		webtest.clickForList("tag=button", 1);
		Assert.assertTrue(webtest.ifContains("3879"));
		webtest.click("link=�����ϼ�");
	}
}


