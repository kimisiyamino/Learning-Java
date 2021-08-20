import java.util.Scanner;

public class StringFormatTest{
	
	 
	
	public static void main(String[] args){
			
		while(true){
			long input;		
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the number: ");
			try{
				input = scanner.nextLong();
			}catch(Exception e){
				System.out.println("Error!\n");
				continue;
			}
			//int num = 475;
			String stringNum = Long.toString(input);
			
			if(stringNum.length() > 10){
				System.out.println("Error!\n");
				continue;
			}
			
			if(stringNum.length() < 10){
				stringNum = String.format("%010d", input);
			}
			
			StringBuilder formatString = new StringBuilder();
			
			formatString.append("+")
						.append(getCountryRussianCode())
						.append("(")
						.append(stringNum.charAt(0))
						.append(stringNum.charAt(1))
						.append(stringNum.charAt(2))
						.append(")")
						.append(stringNum.charAt(3))
						.append(stringNum.charAt(4))
						.append(stringNum.charAt(5))
						.append("-")
						.append(stringNum.charAt(6))
						.append(stringNum.charAt(7))
						.append("-")
						.append(stringNum.charAt(8))
						.append(stringNum.charAt(9));
			
			
			System.out.println("Number: " + formatString + "\n");
		}
	}
	
	public static int getCountryRussianCode(){
		return 7;
	}
}