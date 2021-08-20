public class TestBoats{
	public static void main(String[] args){
		Boat b1 = new Boat(); // +
		Sailboat b2 = new Sailboat(); // +
		Rowboat b3 = new Rowboat(); // +
		 
		b2.setLenght(32);
		b1.getLength(); //
		b3.move(); //
		b1.move(); //
	}
}

 class Boat{ // +
	private int length; // +
	
	public void setLenght(int len){ // +
		length = len;
	}
	public int getLength(){
		return length; // +
	}
	public void move(){
		System.out.println("Поднять паруса!"); 
	}
}

 class Sailboat extends Boat{
	public void move(){
		System.out.print("Дрейф Дрейф ");
	}
}

 class Rowboat extends Sailboat{
	public void rowTheBoat(){
		System.out.println("Давай, Наташа!");
	}
}