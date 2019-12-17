package com.edu.guoxiaoli;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.FailedLoginException;

import freemarker.template.Configuration;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class JMailListener extends TestListenerAdapter{
  
//所有测试用例执行执行该后方法
  @Override
  public void onFinish(ITestContext testContext){
	  StringBuilder str=new StringBuilder();
	  ITestNGMethod[] method=this.getAllTestMethods();
	  str.append("一共执行了"+method.length+"条测试用例\n");
	  List<ITestResult> fail=this.getFailedTests();
	  List<ITestResult> pass=this.getPassedTests();
	  List<ITestResult> skip=this.getSkippedTests();
	  str.append("一共失败了"+fail.size()+"条测试用例\n");
	  str.append("一共成功了"+pass.size()+"条测试用例\n");
	  str.append("跳过了"+skip.size()+"条测试用例\n");
	  for(ITestResult f:fail){
		  str.append(f.getInstanceName()+"-"+f.getName());
	  }
	  for(ITestResult p:pass){
		  str.append(p.getInstanceName()+"-"+p.getName());
	  }
	  for(ITestResult s:skip){
		  str.append(s.getInstanceName()+"-"+s.getName());
	  }
	  System.out.println(str.toString());	
	  
	  String dir="F:\\eclipse\\project-train\\src\\com\\edu\\guoxiaoli";
	  Configuration conf = new Configuration();
		try {
			conf.setDirectoryForTemplateLoading(new File(dir));
			Template template = conf.getTemplate("/mailDemo.ftl");
			Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
	        String date = sdf.format(d);
	        System.out.println(date);
			Map contain = new HashMap();
			contain.put("method", method.length);
	        contain.put("fail", fail.size());
	        contain.put("pass", pass.size());
	        contain.put("skip", skip.size());
	        contain.put("date", date);
			Writer out = new FileWriter(dir + "/email.html");
			
			Writer sWriter=new StringWriter();
	        template.process(contain, sWriter);
	        String resulthtml = sWriter.toString();
	        System.out.println(sWriter.toString());

	        template.process(contain, out);
			System.out.println("发送成功");
			out.flush();
			out.close();
			JavaMail send = new JavaMail();
			send.sendMail(resulthtml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
}


