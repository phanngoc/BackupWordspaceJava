package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test1.TextEditor;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext  context = 
	             new ClassPathXmlApplicationContext("Beans.xml");

	      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	   //   obj.setMessage("Hello A");
	      obj.getMessage();
	      TextEditor te = (TextEditor) context.getBean("textEditor");

	      te.spellCheck();

	     // HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
	     // obj1.getMessage();
	      context.registerShutdownHook();
         // TypeMap typemap = (TypeMap)context.getBean("studentBean");
         // ((HelloWorld)typemap.getMemap("Monday")).getMessage();
         // System.out.print(typemap.getMemap("Monday"));

	   }
}
