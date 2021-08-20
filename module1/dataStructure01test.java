class za{
	String name = "z";
	private static za z = new za();
	
	private za(){
	}
	
	public static za getZa(){
		return z;
	}
	
	public String toString(){
		return name;
	}
	
}


public class dataStructure01test{
	public static void main(String[] args){
		za z = za.getZa();
		
		System.out.println(z);
	}
}



