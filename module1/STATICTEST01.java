import static java.lang.System.out;

class STATICTEST_1{
	static String ss = "jhjgjh";
	private STATICTEST_1(){
		
	}
	public static void ggg(){
		System.out.println(Math.PI);
	}
	
}

public class STATICTEST01{
	static int x;
	int y;
	static int count;
	private STATICTEST01(int x, int y){
		super();
		this.x = x;
		this.y = y;
		count++;
		out.println("SYSTEM: START PROGRAM " + count);	
	}
	public static void main(String[] args){
		STATICTEST01 statictest01 = new STATICTEST01(10, 77);
		STATICTEST01 statictest02 = new STATICTEST01(20, 88);
		out.println(Math.random());		// Double, 0 - 1
		out.println(Math.random());
		STATICTEST_1.ggg();
		
		out.println(STATICTEST_1.ss.getClass());
		out.println(x);
		out.println(statictest01.x + " " + statictest01.y);
		out.println(statictest02.x + " " + statictest02.y);
		
		int[] arr = {1,2,3};
		out.println(arr[2]);
	}
	static{
		out.println("SYSTEM: LOAD PROGRAM");	
	}
}


