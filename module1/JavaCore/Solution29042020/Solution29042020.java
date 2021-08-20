
class X{
	int x = 10;
	void print(){ System.out.println("X");}
	void printOnlyX(){ System.out.println("OnlyX");}
}

class Y extends X{
	int x = 20;
	void print(){ System.out.println("Y");}
}

public class Solution29042020 {
	public static void main(String[] args){
		//X object1 = new Y();
		//System.out.println(object1.x);
		//object1.print();
		
		X objectX = new X();
		Y objectY = new Y();
		
		X objectYinX = new Y();
		X objectSuper;
		
		objectX.print();
		objectY.print();
		System.out.println("Class X: " + objectX.x);
		System.out.println("Class Y: " + objectY.x);
		
		objectYinX.print();
		System.out.println("Class YinX: " + objectYinX.x);
		
		objectSuper = objectY;
		System.out.println("Class objectSuper (+y): " + objectSuper.x);
		objectSuper.print();
		objectSuper.printOnlyX();
		
	}

}