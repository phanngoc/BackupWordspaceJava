package com.common;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;


public class WelcomUserAction extends ActionSupport{
	  
	private String username;
 
	public String getUsername() {
		return username;
	} 
  
	public void setUsername(String username) {
		this.username = username;
	}
 
	// all struts logic here
	public String execute() {
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String,Object> context = new HashMap<String,Object>();
		context.put("key1", "sdsds");
		context.put("key2", "sdsds1111");
		stack.push(context);
		 if ("bombay".equals(username))
	      {
	         return "success";
	      }else{
	         return "deny";  
	      }

	}
}
