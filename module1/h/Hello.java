package h;

import java.util.Scanner;
/**
xxx
*/
public class Hello{
	
	public static void main(String[] args) {
		final int x = 10; // const
		var va = 9; // 
		boolean boolVar = true;
		byte by = 127;
		short sh = 32767;
		long lo = -9223372036854775808L;
		double db = 9223_372_036_854_775_808.0f;
		float fl = 9.0f;
		
		
		Scanner in = new Scanner(System.in);
		int numIn = in.nextInt();
		
		System.out.println("hello");
		System.out.println(db);
		
		System.out.println("Your enter: "+ numIn);
	}	
}