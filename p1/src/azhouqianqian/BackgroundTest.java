package azhouqianqian;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.utils.ReadProperties;

/*
 * 16��
 */
@Listeners(com.edu.guoxiaoli.JMailListener.class)
public class BackgroundTest extends BaseTest {
	@BeforeMethod
	public void backLogin() throws IOException{
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.click("link=��̨����");
		webtest.type("name=admin_name", "admin");
		webtest.type("name=password", "123456");
		webtest.type("name=captcha", "123");
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("��������Ա"));
	}
/*
 * ��̨����
 */
	@Test
//	��Ӷ���(��ɸѡ����)
	public void testindent1(){
		webtest.click("link=����");
		webtest.click("link=��Ӷ���");
		webtest.click("link=�����Ʒ");
		webtest.click("xpath=//button[text()='ִ��']");
		webtest.enterFrame("OpensearchGoods");
		Assert.assertTrue(webtest.ifContains("2207667"));
		webtest.click("id=goods0");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='ִ��']");
		Assert.assertTrue(webtest.ifContains("2207667"));
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("������"));
	}
	@Test
//	��Ӷ���(�����Ʒ~��Ʒ����)
	public void testindent2(){
		webtest.click("link=����");
		webtest.click("link=��Ӷ���");
		webtest.click("link=�����Ʒ");
		webtest.enterFrame("OpensearchGoods");
		webtest.type("class=form-control","���");
		webtest.click("xpath=//button[text()='ִ��']");
		Assert.assertTrue(webtest.ifContains("2207667"));
		webtest.click("id=goods2");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='ִ��']");
		Assert.assertTrue(webtest.ifContains(" 2192019"));
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("������"));
	}
	
	@Test
//	��Ӷ���(�����Ʒ~ѡ����Ʒ����) ʧ��
	public void testindent3(){
		webtest.click("link=����");
		webtest.click("link=��Ӷ���");
		webtest.click("link=�����Ʒ");
//		�����һ��iframe
		webtest.enterFrame("OpensearchGoods");
//		ѡ����Ʒ����
		webtest.click("class=btn btn-default");
//		����ڶ���iframe
//		WebElement web = webtest.getWebElement("xpath=//iframe[contains(@name,'OpenartDialog')]");
//		webtest.TrendsenterFrame(webtest.getWebElement("xpath=//iframe[contains(@name,'OpenartDialog')]"));
		webtest.click("xpath=//span[@text='ʳƷ����']");
		
//		�˳��ڶ���iframe
		webtest.click("xpath=//button[text()='ȷ��']");
		Assert.assertTrue(webtest.ifContains("2207667"));
		webtest.leaveFrame();
//		���ִ��
		webtest.click("xpath=//button[text()='ִ��']");
//		�˳���һ��iframe
		webtest.click("id=goods2");
		webtest.leaveFrame();
		
		webtest.click("xpath=//button[text()='ִ��']");
		Assert.assertTrue(webtest.ifContains(" 2192019"));
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("������"));
	}
	
	@Test
//	��Ӷ���(�����Ʒ~������Ʒ�۸������޽���ɸѡ)
	public void testindent4(){
		webtest.click("link=����");
		webtest.click("link=��Ӷ���");
		webtest.click("link=�����Ʒ");
//		�����һ��iframe
		webtest.enterFrame("OpensearchGoods");
//		ѡ����Ʒ�۸�������
		webtest.type("name=search[seller_price_down]","500");
		webtest.type("name=search[seller_price_up]","550");
		webtest.click("xpath=//button[text()='ִ��']");
//		�˳���һ��iframe
		webtest.click("id=goods0");
		webtest.leaveFrame();
//		���ִ��
		webtest.click("xpath=//button[text()='ִ��']");
		Assert.assertTrue(webtest.ifContains(" 1523270"));
		webtest.click("xpath=//button[@type='submit']");
		Assert.assertTrue(webtest.ifContains("������"));
	}
	
	@Test
//	��Ӷ���(�����Ʒ~���ݴ������ڽ���ɸѡ)
	public void testindent5(){
		webtest.click("link=����");
		webtest.click("link=��Ӷ���");
		webtest.click("link=�����Ʒ");
//		�����һ��iframe
		webtest.enterFrame("OpensearchGoods");
//		ѡ����Ʒ�۸�������
		webtest.type("name=search[create_time_start]","2019-12-01");
		webtest.type("name=search[create_time_end]","2019-12-07");
//		�˳���һ��iframe
		webtest.leaveFrame();
//		���ִ��
		webtest.click("xpath=//button[text()='ִ��']");
		Assert.assertTrue(webtest.ifContains("�������Ʒ"));
	}
	
/*
 * ȫѡ
 */
	@Test
	public void testAll6(){
		webtest.click("link=����");
//		���ȫѡ
		webtest.click("link=ȫѡ");
	}
	
	
/*
 * ��̨ҳ����ʾ��ת
 */
	
	@Test
	public void Show_list7(){
//		����
		webtest.click("link=����");
		webtest.click("link=��Ӷ���");
		webtest.click("link=�˿������б�");
		webtest.click("link=���������б�");
		webtest.click("link=ά�������б�");
		webtest.click("link=���ݹ���");
		webtest.click("link=�տ");
		webtest.click("link=������");
		webtest.click("link=������");
		webtest.click("link=�˿");
		webtest.click("link=ά�޵�");
		webtest.click("link=������ַ");
		webtest.click("link=������ַ����");
//		Ӫ��
		webtest.click("link=Ӫ��");
		webtest.click("link=�����");
		webtest.click("link=������б�");
		webtest.click("link=Ӫ���");
		webtest.click("link=���ֶһ�");
		webtest.click("link=��ʱ����");
		webtest.click("link=ƴ��");
		webtest.click("link=�Ź�");
		webtest.click("link=�ؼ�");
		webtest.click("link=�Ż�ȯ����");
		webtest.click("link=�Ż�ȯ�б�");
//		ͳ��
		webtest.click("link=ͳ��");
		webtest.click("link=��������ͳ��");
		webtest.click("link=�û�ע��ͳ��");
		webtest.click("link=�˾�����ͳ��");
		webtest.click("link=���۽��ͳ��");
		webtest.click("link=��־������¼");
		webtest.click("link=��ֵ������¼");
		webtest.click("link=��̨������¼");
		webtest.click("link=�̻�����ͳ��");
		webtest.click("link=������ϸ�б�");
		webtest.click("link=�����������");
	}
	
/*
 * Ӫ��
 */
//	��ӻ
	@Test
	public void test_add1(){
		webtest.click("link=Ӫ��");
		webtest.click("link=��ӻ");
		webtest.type("name=name", "˫ʮһ��¥�");
//		���ûʱ��
		webtest.type("name=start_time", "2019-10-11 00:00:00");
		webtest.type("name=end_time", "2019-11-10 00:00:00");
//		ѡ������
		webtest.selectByValue("name=type","0");
//		���û���
		webtest.type("name=condition", "400");
//		ѡ������ʽ
		webtest.selectByValue("name=award_type", "1");
//		�����Żݽ��
		webtest.type("name=award_value","50");
//		���ȷ��
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	��ӻ��ֶһ��
	@Test
	public void test_add2(){
		webtest.click("link=Ӫ��");
		webtest.click("link=Ӫ���");
		webtest.click("link=���ֶһ�");
		webtest.click("link=��ӻ��ֶһ�");
//		���û����
		webtest.type("name=name", "���ֻ�����");
//		���û��Ʒ
		webtest.click("xpath=//button[text()='ѡ����Ʒ']");
		webtest.click("xpath=//button[text()='ִ��']");
		webtest.enterFrame("OpensearchGoods");
		webtest.click("id=goods3");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='ִ��']");
//		�������������
		webtest.type("name=point", "200");
//		���ȷ��
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	�����ʱ�����
	@Test
	public void test_add3(){
		webtest.click("link=Ӫ��");
		webtest.click("link=Ӫ���");
		webtest.click("link=��ʱ����");
		webtest.click("link=�����ʱ����");
//		���û����
		webtest.type("name=name", "������");
//		���ûʱ��
		webtest.type("name=start_time", "2019-10-11 00:00:00");
		webtest.type("name=end_time", "2019-11-10 00:00:00");
//		���û��Ʒ
		webtest.click("xpath=//button[text()='ѡ����Ʒ']");
		webtest.click("xpath=//button[text()='ִ��']");
		webtest.enterFrame("OpensearchGoods");
		webtest.click("id=goods3");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='ִ��']");
//		���������۸�
		webtest.type("name=award_value", "200");
//		���ȷ��
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	���ƴ��
	@Test
	public void test_add4(){
		webtest.click("link=Ӫ��");
		webtest.click("link=Ӫ���");
		webtest.click("link=ƴ��");
		webtest.click("link=���ƴ��");
//		���û����
		webtest.type("name=title", "ƴƴƴ");
//		���û��Ʒ
		webtest.click("xpath=//button[text()='�����Ʒ']");
		webtest.click("xpath=//button[text()='ִ��']");
		webtest.enterFrame("OpensearchGoods");
		webtest.click("id=goods3");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='ִ��']");
		webtest.type("name=assemble_price", "200");
//		���ó�������
		webtest.type("name=limit_nums", "3");
//		���ȷ��
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	����Ź�
	@Test
	public void test_add5(){
		webtest.click("link=Ӫ��");
		webtest.click("link=Ӫ���");
		webtest.click("link=�Ź�");
		webtest.click("link=����Ź�");
//		���û����
		webtest.type("name=title", "������");
//		���ûʱ��
		webtest.type("name=start_time", "2019-10-11 00:00:00");
		webtest.type("name=end_time", "2019-11-10 00:00:00");
//		���û��Ʒ
		webtest.click("xpath=//button[text()='�����Ʒ']");
		webtest.click("xpath=//button[text()='ִ��']");
		webtest.enterFrame("OpensearchGoods");
		webtest.click("id=goods3");
		webtest.leaveFrame();
		webtest.click("xpath=//button[text()='ִ��']");
//		���û��Ʒ���
		webtest.type("name=regiment_price", "200");
//		���ÿ����
		webtest.type("name=store_nums", "50");
//		������С��������
		webtest.type("name=limit_min_count", "1");
//		������๺������
		webtest.type("name=limit_max_count", "3");
//		���ȷ��
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	����ؼ���Ʒ
	@Test
	public void test_add6(){
		webtest.click("link=Ӫ��");
		webtest.click("link=Ӫ���");
		webtest.click("link=�ؼ�");
		webtest.click("link=����ؼ�");
//		���û����
		webtest.type("name=name", "�����ؼ�");
//		�����ؼ�����
		webtest.selectByValue("name=type", "4");
//		ɸѡ
		webtest.selectByValue("name=brand_id", "3");
//		�����ۿ�
		webtest.type("name=award_value", "90");
//		���ȷ��
		webtest.click("xpath=//button[@type='submit']");		
	}
	
//	����Ż�ȯ
	
	@Test
	public void test_add7(){
		webtest.click("link=Ӫ��");
		webtest.click("link=�Ż�ȯ����");
		webtest.click("link=�Ż�ȯ�б�");
		webtest.click("link=����Ż�ȯ");
//		���û����
		webtest.type("name=name", "��100��10Ԫ");
//		�����Ż�ȯ���
		webtest.type("name=value", "10");
//		ʹ�÷�Χ
		webtest.selectByValue("name=type", "0");
//		�����Ż�ȯ�������
		webtest.type("name=limit_sum", "100");
//		���û��Чʱ��
		webtest.type("name=start_time", "2019-10-11 00:00:00");
		webtest.type("name=end_time", "2019-11-10 00:00:00");
//		�һ��������
		webtest.type("name=point", "100");
//		���ȷ��
		webtest.click("xpath=//button[@type='submit']");
	}

/*
 * ͳ��
 */
//	�鿴��ͬʱ������û�ע������
	@Test
	public void test_show8(){
		webtest.click("link=ͳ��");
		webtest.click("link=��������ͳ��");
		webtest.click("link=�û�ע��ͳ��");
//	          ����ʱ��
		webtest.type("name=start", "2019-10-11");
		webtest.type("name=end", "2019-11-10");
//		�����ѯ
		webtest.click("xpath=//button[@type='button']");
	}
}

