package bom.test1;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Test6 {

    public static class InnerClass {

        public static void foo() {
        }
    }
    public static void main(String arg[])
    {
    	Test6.InnerClass m = new Test6.InnerClass();   
    }
}