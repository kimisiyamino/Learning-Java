class objectLinkTest_1{
	
}

public class objectLinkTest{
	static  void m(objectLinkTest_1 a1, objectLinkTest_1 a2){
		a1 = a2;
		System.out.println("method");
		System.out.println(a1);
		System.out.println(a2);
	}
	public static void main(String[] args){
		objectLinkTest_1 a1 = new objectLinkTest_1();
		objectLinkTest_1 a2 = new objectLinkTest_1();
		System.out.println("start");
		System.out.println(a1);
		System.out.println(a2);
		m(a1, a2);
		System.out.print(a1 == a2);
		System.out.println("final");
		System.out.println(a1);
		System.out.println(a2);
	}
}