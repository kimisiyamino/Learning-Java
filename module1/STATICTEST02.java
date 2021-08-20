public class STATICTEST02{
	public static void main(String[] args){
		System.out.println(Foooo.x);
		Foooo5 f5 = new Foooo5();
		f5.go(5);
		System.out.println(Foooo5.x);
		Foooo6.go(666);
	}
}

class Foooo {
	static int x;
	final static int Y;
	

	public void go(){
		System.out.println(x);
		
	}
	static{
		x = 100; Y=0;
	}
}

class Foooo5 {
	static final int x = 12;
	
	public void go(final int x){
		System.out.println(x);
		System.out.println(this.x);
	}
}

class Foooo6 {
	int x = 12;
	
	public static void go(final int x){
		System.out.println(x);
	}
}
