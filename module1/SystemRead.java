import java.util.Scanner;
public class SystemRead{
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		
		byte[] b = new byte[10];
		
		
		
		/*try{
			System.out.print(System.in.read(b));
		}catch(Exception e){
			e.printStackTrace();
		}
		for(byte c : b)
			System.out.println(c);*/
		
		/*Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(s);*/
		
		System.out.println("Time:" + (System.currentTimeMillis()-startTime));
	}
}