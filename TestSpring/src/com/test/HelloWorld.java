package com.test;

public class HelloWorld extends ParentHelloWorld{
	  private String message;

	   public void setMessage(String message){
	      this.message  = message;
	   }
	   public void init()
	   {
		   System.out.print("init method");
	   }
	   public void destroy()
	   {
		   System.out.print("destroy ne");
	   }
	   public void getMessage(){
	      System.out.println("Your Message : " + message + x);
	   }
}
