package com.edu.guoxiaoli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class testFreemarker {

	public static void main(String[] args) throws IOException, TemplateException {
		// TODO Auto-generated method stub
		String dir="F:\\eclipse\\project-train\\src\\com\\edu\\guoxiaoli";
		Configuration conf = new Configuration();
		//����ģ���ļ�(ģ���·��)
		conf.setDirectoryForTemplateLoading(new File(dir));
		// ����ģ��
		Template template = conf.getTemplate("/freemarkerDemo.ftl");
		// ��������
		
		Map root = new HashMap();
        root.put("world", "Hello World");
		// �������
		Writer out = new FileWriter(dir + "/freemarker.html");
		template.process(root, out);
		System.out.println("ת���ɹ�");
		out.flush();
		out.close();
	}

}


