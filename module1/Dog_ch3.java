class Dog_ch3{
	String name;
	public static void main(String[] args){
		Dog_ch3 dog1 = new Dog_ch3();
		dog1.bark();
		dog1.name = "Bart";
		
		Dog_ch3[] myDogs = new Dog_ch3[3];
		
		myDogs[0] = new Dog_ch3();
		myDogs[1] = new Dog_ch3();
		myDogs[2] = dog1;
		
		myDogs[0].name = "Fred";
		myDogs[1].name = "George";
		
		System.out.print("The name of the last dog: ");
		System.out.println(myDogs[2].name);
		
		int x = 0;
		while(x<myDogs.length){
			myDogs[x].bark();
			x++;	
		}
		
		
		}
		
		public void bark(){
			System.out.println(name + " say: GAV!");
			
		}
		
	}


