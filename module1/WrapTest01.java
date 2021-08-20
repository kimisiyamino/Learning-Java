public class WrapTest01{
	Integer i=1;
	int j;
	
	public static void main(String[] args){
		WrapTest01 w = new WrapTest01();
		
		// Boolean b = new Boolean(true);  УСТАРЕЛО
		
		Boolean b = true;
	
	
		if(b){
			System.out.println("gg");
		}
		b = false;
		w.go();
	}
	
	public void go(){
		j = i;
		System.out.println(i);
		System.out.println(j);
	}
}