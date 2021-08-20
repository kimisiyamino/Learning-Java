class Dog {
	int size;
	String breed;
	String name;	
	void bark(){
		System.out.println("Гав! Гав!");		
	}
}

class DogTest {
	public static void main(String[] args){	
		Dog Gosha = new Dog();
		Gosha.size = 100;
		Gosha.bark();
		
	}
}