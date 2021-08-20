interface interface_A{
	void funcA();
	default void funcC(){
		System.out.println("Я ДЕФОЛТ ФУНКЦИЯ XXX");
		
	}
	static void funcSTATIC(){
		System.out.println("Я СТАТИЧЕСКАЯ ФУНКЦИЯ");
	}
}

interface interface_B extends interface_A{
	void funcB();
	default void funcC(){
		interface_A.super.funcC();
		System.out.println("Я ДЕФОЛТ ФУНКЦИЯ");
	}
	
}

interface interface_C{

}

class Interface implements interface_B{
		public void funcA(){
			System.out.println("Я ФУНКЦИЯ ИНТЕРФЕЙСА А");
		}
		public void funcB(){
			System.out.println("Я ФУНКЦИЯ ИНТЕРФЕЙСА B");
		}
		
		public static int dibil(int x){
			return x*x;
		}
}

class Interface2 extends Interface implements interface_A{
	public static int dibil(int x){
			return x*x*x;
		}
}


public class InterfaceTest {
	public static void main(String ... args){
		Interface i = new Interface();
		i.funcB();
		i.funcC();
		interface_A.funcSTATIC();
		
		Interface2 i2 = new Interface2();
		System.out.println(i2.dibil(50));
		System.out.println(Interface.dibil(2));
		System.out.println(Interface2.dibil(2));
		
		interface_A superLink;
		
		superLink = i2;
		superLink.funcC();
		
		interface_A inf = new interface_A(){
			public void funcA(){}
		};
		
		inf.funcC();
	}
}