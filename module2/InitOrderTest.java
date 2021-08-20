public class InitOrderTest{
	public static void main(String[] args){
		//new InitOrderB();
		InitOrderB.InitOrderB_inner1 a = new InitOrderB.InitOrderB_inner1();
		System.out.println(a.getY());
	}
}

class InitOrderA{
	public int x = 1;
	public static int y = 1;
	
	public InitOrderA(){
		System.out.printf("This is constructor of class \"InitOrderA\"\nx = %d, y = %d\n\n", x, y);
	}
	{
		System.out.printf("This is non-static block of class \"InitOrderA\"\nx = %d, y = %d\n\n", x, y);
	}
	static{
		System.out.printf("This is static block of class \"InitOrderA\"\nx = , y = %d\n\n", y);
	}
}

class InitOrderB extends InitOrderA{
	public int x = 2;
	public static int y = 2;
	
	public InitOrderB(){
		System.out.printf("This is constructor of class \"InitOrderB\"\nx = %d, y = %d\n\n", x, y);
	}
	
	static{
		System.out.printf("This is static block of class \"InitOrderB\"\nx =, y = %d\n\n", y);
	}
	{
		System.out.printf("This is non-static block of class \"InitOrderB\"\nx = %d, y = %d\n\n", x, y);
	}
	
	public static class InitOrderB_inner1{
		{
			System.out.printf("This is static block of class \"InitOrderB_inner1\"\nx = , y = %d\n\n", y);
		}
		public InitOrderB_inner1(){
			System.out.printf("This is constructor of class \"InitOrderB_inner1\"\nx =, y = %d\n\n", y);
		}
		public int getY(){
			return y;
		}
		
	}
}