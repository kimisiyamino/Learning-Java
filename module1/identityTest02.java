public class identityTest02{
	public static void main(String[] args){
		System.out.println("\nОбъявлениее переменных:\n String a = \"a\";\n String b = new String(\"a\");");
		
		String a = "a";
		String b = new String("a");
		
		System.out.println("\n Хэшкод a: " + a.hashCode());
		System.out.println(" Хэшкод b: " + b.hashCode());
		
		System.out.println("\n a == b \t" +(a == b));
		System.out.println(" a.equals(b): \t" + (a.equals(b)));
		
		b = "a";
		System.out.println("\n   b = \"a\"; ");
		
		System.out.println("\n a == b \t" +(a == b));
		System.out.println(" a.equals(b): \t" + (a.equals(b)));
		///////////////////////////////////////////////////
		
		System.out.println("\nОбъявлениее переменных:\n String d = new String(\"b\");\n String d = new String(\"b\");");
		
		String c = new String("b");
		String d = new String("b");
		
		System.out.println("\n Хэшкод c: " + c.hashCode());
		System.out.println(" Хэшкод d: " + d.hashCode());
		
		System.out.println("\n c == d \t" +(c == d));
		System.out.println(" c.equals(d): \t" + (c.equals(d)));
		
		c = "b";
		System.out.println("\n   c = \"b\"; ");
		
		System.out.println("\n c == d \t" +(c == d));
		System.out.println(" c.equals(d): \t" + (c.equals(d)));
		
		d = "b";
		System.out.println("\n   d = \"b\"; ");
		
		System.out.println("\n c == d \t" +(c == d));
		System.out.println(" c.equals(d): \t" + (c.equals(d)));
		
	}
}