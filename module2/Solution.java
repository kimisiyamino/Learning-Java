

import java.io.*;
import java.util.Arrays;

/* 
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream standard = System.out;
        InputStream standardInput = System.in;

        ByteArrayOutputStream bbbb = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bbbb);
        System.setOut(ps);
        testString.printSomething();

        byte[] bytes = bbbb.toByteArray();
		char[] chars = new char[bytes.length];
		
		for(int i = 0; i < bytes.length; i++){
				chars[i] = (char)bytes[i];
		}
		
		 String s = bbbb.toString();
		 s = s.replaceAll("te", "??");
		
		
		System.setOut(standard);
		
		System.out.println(s);
		

        //ByteArrayInputStream bytes =

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
