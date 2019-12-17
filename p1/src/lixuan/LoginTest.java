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
	 //��¼
	  public void login() throws InterruptedException, IOException{
		 String login_url="/index.php?controller=site&action=index";
		//��ҳ��
		  webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		  //���
		  Thread.sleep(1000);
		  webtest.click("link=��¼");
		  //����
		  webtest.type("name=login_info", "chenmeng");
		  webtest.type("name=password", "lixuan");
		  Thread.sleep(1000);
		  webtest.click("class=input_submit");
		  Assert.assertTrue(webtest.ifContains("chenmeng"));
	 }
	 @Test(priority=2)
	 //��������֮���׼�¼֮�ҵĶ���
	 public void wodedingdan() throws InterruptedException, IOException{
		 String login_url="/index.php?controller=ucenter&action=index";
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		 Thread.sleep(1000);
		 webtest.click("link=�ҵĶ���");
		 Assert.assertTrue(webtest.ifContains("����״̬"));
	 }
	 @Test(priority=3)
	//��������֮���׼�¼֮�ҵĻ���
	 public void wodejifen() throws InterruptedException, IOException{
		 String login_url="/index.php?controller=ucenter&action=index";
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		 Thread.sleep(1000);
		 webtest.click("link=�ҵĻ���");
		 Assert.assertTrue(webtest.ifContains("��������"));
	 }
	 @Test(priority=4)
		//��������֮���׼�¼֮�ҵ��Ż�ȯ
		 public void wodeyouhuiquan() throws InterruptedException, IOException{
		 	String login_url = "/index.php?controller=ucenter&action=index";
		 	webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
			Thread.sleep(1000);
			webtest.click("link=�ҵ��Ż�ȯ");
			Assert.assertTrue(webtest.ifContains("��ֵ"));
		 }
	//��������
	 @DataProvider(name="test1")
	 public Object[][] createData1() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","zhandian");
	 }
	 @Test(priority=5,dataProvider="test1")
	 //վ�㽨�� 7��
	 public void myselfjianyi(String title,String content) throws InterruptedException, IOException{
		 String login_url="/index.php?controller=ucenter&action=index";
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login_url);
		 Thread.sleep(1000);
		 webtest.click("link=վ�㽨��");
		 Thread.sleep(1000);
		 webtest.type("name=title",title);
		 Thread.sleep(1000);
		 webtest.type("name=content",content);
		 Thread.sleep(1000);
		 webtest.click("class=input_submit");
		 Assert.assertTrue(webtest.ifContains("���"));
		 
	 }
	 @Test(priority=6)
	 //�ۺ����
	 public void shouhoufuwu() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=�ۺ����");
		 Assert.assertTrue(webtest.ifContains("�˿��"));
		 Thread.sleep(1000);
		 webtest.click("link=�ҵĻ���");
		 Assert.assertTrue(webtest.ifContains("��������"));
		 Thread.sleep(1000);
		 webtest.click("link=�ҵ�ά��");
		 Assert.assertTrue(webtest.ifContains("ά�޶���"));
	 }
	 @Test(priority=7)
	 //��Ʒ��ѯ
	 public void shangpinzixun() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=��Ʒ��ѯ");
		 Assert.assertTrue(webtest.ifContains("����"));
	}
	 @Test(priority=8)
	 //��Ʒ����
	 public void shangpinpingjia() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=��Ʒ����");
		 Thread.sleep(1000);
		 Assert.assertTrue(webtest.ifContains("����ʱ��"));
		 webtest.click("link=������");
		 Thread.sleep(1000);
		 Assert.assertTrue(webtest.ifContains("����ʱ��"));
	 }
	 @Test(priority=9)
	 //����Ϣ
	 public void duanxinxi() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=����Ϣ");
		 Assert.assertTrue(webtest.ifContains("����"));
	 }
	 @Test(priority=10)
	 //�ղؼ�
	 public void shoucangjia() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=�ղؼ�");
		 Assert.assertTrue(webtest.ifContains("�ղؼ�")); 
	 }
	 @Test(priority=11)
	 //���׼�¼
	 public void jiaoyijilu() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=�ʻ����");
		 Thread.sleep(1000);
		 Assert.assertTrue(webtest.ifContains("�¼�")); 
	 }
	 
	 
	 @DataProvider(name="test2")
	 public Object[][] createData2() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","tixian");
	 }
	 @Test(priority=12,dataProvider="test2")
	 //��������  amount���䣬��ȷ��һ����nameӢ��һ����name�������һ����note�������һ����noteӢ��һ������5��
	 public void tixianshenqing(String name,String note) throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=�ʻ����");
		 Thread.sleep(1000);
		 webtest.click("link=��������");
		 Thread.sleep(1000);
		 webtest.type("name=name",name);
		 Thread.sleep(1000);
		 webtest.type("name=amount","200");
		 Thread.sleep(1000);
		 webtest.type("name=note",note);
		 Thread.sleep(1000);
		 webtest.click("class=input_submit");
		 Thread.sleep(1000);
		 webtest.click("link=���߳�ֵ");
		 webtest.type("name=recharge","1000");
		 webtest.click("class=input_submit");
		 Thread.sleep(1000); 
		 Assert.assertTrue(webtest.ifContains("200")); 
	 }
	//��������
	 @DataProvider(name="test3")
	 public Object[][] createData3() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","address");
	 }
	 @Test(dataProvider="test3",priority=13)
	 //��ַ����֮��ӵ�ַ��8����
	 public void myselfaddaddress(String accept_name,String province,String city,String area,
			 String address,String mobile,String telphone,String zip) throws InterruptedException, IOException{
//		��ӵ�ַ
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=��ַ����");
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
		 Assert.assertTrue(webtest.ifContains("���")); 
	 }
	 
	 @Test(priority=14)
	 //��ַ����֮ɾ����ַ
	 public void deleteaddress() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=��ַ����");
		 Thread.sleep(1000);
		 webtest.click("xpath=//div[3]/section[2]/div/section/section/table/tbody/tr[3]/td[6]/a[2]");
		 Thread.sleep(1000);
		 webtest.click("class=aui_state_highlight");
	 }

	 @Test(priority=15)
	 //��������
	 public void myselfchangeaddress() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=��������");
		 Thread.sleep(1000);
		 webtest.type("name=true_name","���");
		 Thread.sleep(1000);
		 webtest.type("name=province", "�����");
		 Thread.sleep(1000);
		 webtest.type("name=city", "��Ͻ��");
		 Thread.sleep(1000);
		 webtest.type("name=area", "�Ӷ���");
		 Thread.sleep(1000);
		 webtest.type("name=contact_addr","������"); 
		 Thread.sleep(1000);
		 webtest.click("xpath=//input[@value='�����޸�']");
	 }
	 
	//��������
	 @DataProvider(name="test4")
	 public Object[][] createData4() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","fapiao");
	 }
	 @Test(priority=16,dataProvider="test4")
	 //��Ʊ����֮������Ʊ(6��)
	 public void fapiaoguanli(String company_name,String taxcode,String address,
			 String telphone,String bankname,String bankno,String type) throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=��Ʊ����");
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
		 Assert.assertTrue(webtest.ifContains("�ӱ�ʦ����ѧ")); 
	 }
	 @Test(priority=17)
	 //��Ʊ����֮ɾ����Ʊ
	 public void deletefapiao() throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(2000);
		 webtest.click("link=��Ʊ����");
		 Thread.sleep(1000);
		 webtest.click("xpath=//div[3]/section[2]/div/section/section/table/tbody/tr[2]/td[4]/a[2]/i");
		 Thread.sleep(1000);
		 webtest.click("class=aui_state_highlight");
	 }
	 
	//��������
	 @DataProvider(name="test5")
	 public Object[][] createData5() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","password");
	 }
	 @Test(priority=18,dataProvider="test5")
	 //�޸�����(2��)
	 public void exchangepw(String fpassword,String password,String repassword) throws InterruptedException, IOException{
		 webtest.open(ReadProperties.getPropertyValue("base_url")+url);
		 Thread.sleep(1000);
		 webtest.click("link=�޸�����");
		 Thread.sleep(1000);
		 webtest.type("name=fpassword", fpassword);
		 webtest.type("name=password", password);
		 webtest.type("name=repassword", repassword);
		 webtest.click("class=input_submit");
	 }
	 
	//��������
	 @DataProvider(name="test6")
	 public Object[][] createData6() throws IOException{
		 ExcelDataProvider provider = new ExcelDataProvider();
		 return provider.getTestDataByExcel("E:\\add.xlsx","getdian");
	 }
	 @Test(priority=19,dataProvider="test6")
	 //���뿪��(6��)
	 public void opendian(String seller_name,String password,String repassword,String true_name,String phone
			 ,String mobile,String email,String province,String city,String area,String address) throws InterruptedException{
		 webtest.click("link=���뿪��");
		 Thread.sleep(1000);
		 webtest.type("name=seller_name",seller_name);
		 webtest.type("name=password",password);
		 webtest.type("name=repassword",repassword);
		 webtest.type("name=true_name",true_name);
		 webtest.type("xpath=//input[@type='file']","C:\\Users\\���\\Pictures\\Saved Pictures\\timg.jpg");
		 webtest.type("name=phone",phone);
		 webtest.type("name=mobile",mobile);
		 webtest.type("name=email",email);
		 webtest.type("name=province",province);
		 webtest.type("name=city",city);
		 webtest.type("name=area",area);
		 webtest.type("name=address",address);
		 webtest.click("class=input_submit");
		 Assert.assertTrue(webtest.ifContains("����ɹ��������ĵȴ�����Ա�����"));
	 }
	 @Test(priority=20)
	 //�̼ҹ���ʹ�ð����ĵ��
	 public void shangjiaguanli() throws InterruptedException{
		 webtest.click("link=�̼ҹ���");
		 Thread.sleep(1000);
		 webtest.click("link=��վ��ҳ");
		 Thread.sleep(1000);
		 webtest.click("link=ʹ�ð���");
	 }
	 @Test(priority=21)
	 //�����������
	 public void search() throws InterruptedException{
		 webtest.type("name=word", "��ƤŮ��");
		 webtest.click("class=search_submit");
	 }
		@Test(priority=22)
		//���빺�ﳵ
		public void add1() throws InterruptedException{
			webtest.click("xpath=//div[3]/section[3]/div/div[2]/a[2]/img");
//				webtest.click("class=reduce");
			webtest.click("class=add");
			webtest.click("class=add");
			webtest.click("xpath=//span[text()='���빺�ﳵ']");
		}
	 @Test(priority=23)
	 //���ﳵ����
	 public void jiesuan() throws InterruptedException{
		 webtest.click("class=go_cart");
		 Thread.sleep(1000);
		 webtest.click("class=gopay_btn");
		 webtest.type("name=message","�Ӽ��Ӽ�");
		 webtest.click("name=taxes");
		 webtest.type("name=invoice_id","�ӱ�ʦ����ѧ");
		 Thread.sleep(1000);
		 webtest.click("class=cart_topay_btn");
		 Thread.sleep(1000);
		 webtest.click("class=gobank_pay_btn");
	 }
		@Test(priority=24)
		//���빺�ﳵ
		public void add2() throws InterruptedException{
			webtest.click("xpath=//div[3]/section[3]/div/div[2]/a[2]/img");
//				webtest.click("class=reduce");
			webtest.click("class=add");
			webtest.click("class=add");
			webtest.click("xpath=//span[text()='���빺�ﳵ']");
		}
	 @Test(priority=25)
	 //��չ��ﳵ
	 public void qingkong() throws InterruptedException{
		 webtest.click("class=go_cart");
		 Thread.sleep(1000);
		 webtest.click("class=clear_cart_btn");
		 Thread.sleep(1000);
		 webtest.click("class=aui_state_highlight");
	 }
	 @Test(priority=26)
	 //��������
	 public void jixugouwu() throws InterruptedException{
		 webtest.click("class=go_cart");
		 Thread.sleep(1000);
		 webtest.click("class=go_back_btn");
	 }
	 @Test(priority=27)
	 //ȫ����Ʒ���
	 public void allshangpn() throws InterruptedException{
		 webtest.click("link=���õ���");
		 webtest.click("link=�� ҳ");
		 webtest.click("link=��ҵ�");
		 webtest.click("link=�� ҳ");
		 webtest.click("link=ʳƷ����");
		 webtest.click("link=�� ҳ");
		 webtest.click("link=����ʳƷ");
		 webtest.click("link=�� ҳ");
		 webtest.click("link=�Ҿ�");
		 webtest.click("link=�� ҳ");
		 webtest.click("link=���ҼҾ�");
		 webtest.click("link=�� ҳ");
		 webtest.click("link=��װ");
		 webtest.click("link=�� ҳ");
		 webtest.click("link=��װ");
		 webtest.click("link=�� ҳ");
		 webtest.click("link=Ůװ");
	 }

	 @Test(priority=28)
	 //�ֲ�ͼ����ͼ����
	 public void tubiao() throws InterruptedException, IOException{
		 String login1="/index.php?controller=site&action=sitemap";
		 String login2="/index.php?controller=site&action=seller";
		 String login3="/index.php?controller=site&action=brand";
		 String login4="/index.php?controller=site&action=sale";
		 String login5="/index.php?controller=site&action=help_list";
		 String login6="/index.php?controller=site&action=tags";
		 webtest.click("link=�� ��");
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login1);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login2);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login3);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login4);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login5);
		 webtest.open(ReadProperties.getPropertyValue("base_url")+login6);
		 webtest.click("link=�� Ѷ");
	 }
	@Test(priority=29)
	//����ʳƷ�۸�Χ����
	public void foodcart() throws InterruptedException, IOException{
		webtest.click("link=����ʳƷ");
		webtest.type("name=min_price","1000");
		webtest.type("name=max_price","2000");
		webtest.click("link=ȷ��");
	}

}


