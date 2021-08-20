//		8	10	16
//		o	d	x
//			f	a

//		char		string	boolean
//		   c		    s		    b

// 		new line
//		     n

// %%
import java.util.Date;

public class FormatTest{
	public static void main(String[] args){

		Boolean b = true;
		String s = String.format(" %b", b);
		
		System.out.printf("%s%n%<S%n",s);
		
		Double d = -12384423.2342352345d;
		System.out.printf("%1$0 ,17.3f%n",d);
		System.out.printf("%2$S, %1$.1f%n",d,s);
	
		System.out.printf(String.format("%tc %n%n", new Date()));
		
		Date date = new Date();
		System.out.printf("%tr%n%<tA%n%<tB%n%<td%n%<tH:%<tM%n%<Tp%n", date);
		System.out.printf("%tD, %<tF", date);
		
	}
}