class AAAAA{
	
	public void printClass(){
		System.out.println("AAAAA");
	}
	public void onlyA(){
		System.out.println("Only A");
	}
}
class BBBBB extends AAAAA{
	
	public void printClass(){
		System.out.println("BBBBB");
	}
}




class AAA_AAA{
	public static void main(String ... args){
		AAAAA a = new AAAAA(); // Родитель
		BBBBB b = new BBBBB(); // Потомок
		AAAAA c = new BBBBB(); // Супер родителе-потомк
		
		Object link;
		
		b.printClass();
		c.printClass();
		c.onlyA();
		System.out.println(c.getClass());
		
		AAAAA d = (AAAAA)c;
		d = a;
		d.printClass();
		
		link = a;
		a.printClass();
		link = b;
		b.printClass();
		link = c;
		c.printClass();
	}
}

