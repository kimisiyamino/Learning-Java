import java.util.Scanner;

public class C{
	public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			String inputString = input.nextLine();
			
			String[] numsString = inputString.split(" ");
			
			int x = Integer.parseInt(numsString[0]);
			int y = Integer.parseInt(numsString[1]);
			
			System.out.println(x + y);
			
		}
}