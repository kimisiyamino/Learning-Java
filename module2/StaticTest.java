class A{
	public static void staticMethod1(){
		System.out.println("staticMethod1");
	}
	public static void staticMethod1(String string){
		System.out.println(string + "staticMethod1" );
	}

}
class B extends A{
	//@Override
	public static void staticMethod1(){
		System.out.println("overriden staticMethod1");
	}
	

}

public class StaticTest{
	public static void main(String[] args){
		
		A.staticMethod1();
		B.staticMethod1();
		
		B.staticMethod1("jj");
		A.staticMethod1("dd");
		
		
	}
}