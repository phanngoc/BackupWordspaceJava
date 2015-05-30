package com.common;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException; 

import com.opensymphony.xwork2.ActionSupport;

public class UploadFile extends ActionSupport{
   private File my1File;
   private String my1FileContentType;
   private String my1FileFileName;
   private String destPath;

   public String execute()
   {
      /* Copy file to a safe location */
      destPath = "C:/work/";

      try{
     	 System.out.println("Src File name: " + my1File);
     	 System.out.println("Dst File name: " + my1FileFileName);
     	    	 
     	 File destFile  = new File(destPath, my1FileFileName);
    	 FileUtils.copyFile(my1File, destFile);
  
      }catch(IOException e){
         e.printStackTrace();
         return ERROR;
      }

      return SUCCESS;
   }
   public File getMyFile() {
      return my1File;
   }
   public void setMyFile(File myFile) {
      this.my1File = myFile;
   }
   public String getMyFileContentType() {
      return my1FileContentType;
   }
   public void setMyFileContentType(String myFileContentType) {
      this.my1FileContentType = myFileContentType;
   }
   public String getMyFileFileName() {
      return my1FileFileName;
   }
   public void setMyFileFileName(String myFileFileName) {
      this.my1FileFileName = myFileFileName;
   }
}