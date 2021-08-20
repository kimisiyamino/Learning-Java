public class BitwiseOperation{
	public static void main(String[] args){
		int x = 0b11111111111111111111111111111111;
		x<<=32;
		System.out.println(x);
		x = x >>> 1;
		System.out.println(x);
	
		
		System.out.println(x);
		x = x >> 1;
		System.out.println(x);
		x = x >>> 1;
		System.out.println(x);
	}
}