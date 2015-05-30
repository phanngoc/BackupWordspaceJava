package com.test;

import java.util.HashMap;
import java.util.Map;

public class TypeMap {
  Map<String,Object> memap = new  HashMap<String, Object>();
  public Object getMemap(String key){
	  return memap.get(key);
  }
  public void setMemap(Object map){
	  this.memap.put("Monday", map);
  }
}
