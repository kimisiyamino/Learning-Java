public class interfaceTest{
	public static void main(String[] args){
			//new ClassA().start();
	}
}


interface interfaceA{
	void func01();
	
}

abstract class ClassA implements interfaceA{
	public void startA(){
		System.out.println("startA");
	}
}

class ClassB extends ClassA{
	public void startB(){
		System.out.println("startB");
	}
	
	@Override
	public void func01(){
		
	}
}