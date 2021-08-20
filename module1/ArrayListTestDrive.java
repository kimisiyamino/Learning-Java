import java.util.ArrayList;

public class ArrayListTestDrive{
	public static void main(String[] args){
		ArrayList<Egg> myList = new ArrayList<Egg>();
	
		Egg s = new Egg();
		myList.add(s);
		
		Egg b = new Egg();
		myList.add(b);
		
		int theSize = myList.size();
			System.out.println("Размер myList: " + theSize);
			
		boolean isIn = myList.contains(s);
			System.out.println("В myList есть S?: " + isIn);
		isIn = myList.contains(b);
			System.out.println("В myList есть B?: " + isIn);
			
		int idx = myList.indexOf(s);
			System.out.println("Индекс S: " + idx);
		idx = myList.indexOf(b);
			System.out.println("Индекс B: " + idx);
		
		myList.remove(s);
		idx = myList.indexOf(b);
			System.out.println("Индекс B: " + idx);
		
		Egg h = new Egg();
		myList.add(1, h);
		idx = myList.indexOf(h);
			System.out.println("Индекс h: " + idx);
		idx = myList.indexOf(b);
			System.out.println("Индекс B: " + idx);
		idx = myList.indexOf(s);
			System.out.println("Индекс s: " + idx);
			
		System.out.println(myList.get(1));
		
		int[][] arOfar = new int[2][];
			arOfar[0] = new int[] {1,2,3,4,5};
			arOfar[1] = new int[] {6,7};
			System.out.println("4 " + arOfar[0][3]);
			System.out.println("7 " + arOfar[1][1]);
			
		ArrayList<String> myListString = new ArrayList<String>();
			String string1 = "string1";
			String string2 = "string2";
			myListString.add(string1);
			myListString.add(string2);
			System.out.println(myListString.get(1));
		
	}

}

//class Egg{
//	int EggZize;
//}