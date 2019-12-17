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
		//加载模板文件(模板的路径)
		conf.setDirectoryForTemplateLoading(new File(dir));
		// 加载模板
		Template template = conf.getTemplate("/freemarkerDemo.ftl");
		// 定义数据
		
		Map root = new HashMap();
        root.put("world", "Hello World");
		// 定义输出
		Writer out = new FileWriter(dir + "/freemarker.html");
		template.process(root, out);
		System.out.println("转换成功");
		out.flush();
		out.close();
	}

}


