public class identityTest{
	public static void main(String[] args){
		String x = new String();
		String y;
		String z = new String("123");
	
		String a = "a";
		String b = new String("a");
		
		
		
		
		b = "a";
	
		x = "123";
		y = "123";
		
		System.out.println(x.hashCode());
		System.out.println(y.hashCode());
		System.out.println(z.hashCode());
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		System.out.println(x == y); // true
		System.out.println(z == y); // false		(сравнивает ссылки, НО!  пулстрок (String pool)
		System.out.println(z.equals(y)); //  true	(сравнивает идентичность)
		System.out.println(z == x); 
		System.out.println(a == b); 
		System.out.println(a.equals(b)); 
		
		
		
		String ff = "vfdvfd";
		System.out.println(ff instanceof String);
		
	}
}