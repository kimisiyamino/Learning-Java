public class instanceTest{
	public static void main(String[] args){
			new instance().start();
	}
}

class instance{
	public void start(){
		/* A a1 = new A();
		B b1 = new B();
		C c1 = new C();
		
	
		System.out.println(a1 instanceof A);
		System.out.println(b1 instanceof A);
		System.out.println(c1 instanceof A);
		
		System.out.println(b1 instanceof B);
		System.out.println(c1 instanceof C);
		
		System.out.println(a1.getClass());
		
		a1 = c1;
		
		System.out.println(a1.getClass()); */
		
		
		Object obj = new C();
		
		System.out.println(obj.getClass());
		System.out.println(obj.toString());
		System.out.println(obj instanceof B);
		System.out.println(obj instanceof Object);
		//obj.secret();
		//obj.printClassA();
		
/* 		C c = new C();
		
		System.out.println(c.getClass());
		System.out.println(c.toString());
		System.out.println(c instanceof B);
		System.out.println(c instanceof Object); */
		
		
		System.out.println("         ---         ---");
		
		A a = (A)obj;
		
		System.out.println(a.getClass());		// A
		System.out.println(a.toString());		// classA=4534645
		System.out.println(a instanceof C);		// false
		System.out.println(a instanceof Object);// true
		a.printClassA();
		//a.secret();
		
		
		Object o = a;
		
		System.out.println("         ---         --- ==== ");
		
		System.out.println(o.getClass());		// A
		System.out.println(o.toString());		// classA=4534645
		System.out.println(o instanceof C);		// false
		System.out.println(o instanceof Object);
		o.printClassA();
		 
	}
}


class A{
	
	public String toString(){
		return "toString A";
	}
	
	public void printClassA(){
		System.out.println("printClassA");
	}
	
	private void secretA(){
		System.out.println("SECRET !@");
	}
}

class B extends A{
}

class C extends B{
	
	public String secret(){
		return "secret";
	}
	
	public String toString(){
		return "toString C";
	}
}