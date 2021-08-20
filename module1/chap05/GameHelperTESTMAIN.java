import java.util.*;

public class GameHelperTESTMAIN{
	public static void main (String[] args){
		GameHelperTEST helperTest = new GameHelperTEST();
	   ArrayList<String> testsList = new ArrayList<String>();
	   int x = 3;
	   testsList = helperTest.placeDotCom(x);
	   System.out.println(testsList);
   }
}