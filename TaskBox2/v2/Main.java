import com.eleonoralion.Text;
import com.eleonoralion.Printer;

public class Main{
	public static void main(String[] args){
		Text text = new Text("Hello!");
		Printer printer = new Printer();
		printer.print(text);
	}
}