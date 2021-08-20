public class Program000{

	public static void main(String[] args){
		int x = 1;
		boolean iff = false;
		System.out.print(iff);
		
		while(x == 1){
			System.out.println(x);
			iff = true;
			System.out.print("В цикле " + iff);
			break;
		}
		
		if(iff == false)
			System.out.print("Цикл был пройден");
		else
			System.out.print("Цикл не был пройден");
		
		System.out.print(iff);
		
	}
	
}