import java.util.Scanner;

public class B{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		String inputString = input.nextLine();
		String[] numsString = inputString.split(" ");
		long x = Long.parseLong(numsString[0]);
		long y = Long.parseLong(numsString[1]);

		int count = 0;
	
		long gcd = EGCD(x,y);
		long lcm = LCM(x,y);
		
		
		if(x != 0 && x <= y && y <= 1_000_000_000_000L){
			if(lcm > y || lcm < x){
				
			}
			else{
				count++;
				while((y % 2) != 1){
					x*=2; y/=2;		
					if((x == y*2) || (y == x/2))
						break;
					if((EGCD(x,y) != gcd) || LCM(x,y) != lcm){
						break;
					}
					count++;			
				}
			}
		}else{}
		System.out.println(count*2);
	}
	
	public static long EGCD(long x, long y){
		return y == 0 ? x : EGCD(y,x % y);
	}
	
	public static long LCM(long x,long  y){
		return x / EGCD(x,y) * y;
	}	
}

