import java.io.*;
import java.util.*;

public class testCanvas{
	int[][] field;
	String line2;
	String[] s;
	ArrayList<String> ss = new ArrayList<String>();
	
	public static void main(String[] args) {
		new testCanvas().go();
	}
	
	public void go(){
		String line = null;
		String line2 = null;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("setup.txt")));
			int count = 0;
			while((line = reader.readLine()) != null){
				//add(line);
				System.out.println(line);
			
				ss.add(line);
				//line2 = line2.concat(line);
			}
			System.out.println(ss);
			System.out.println(ss.size());
		}catch(IOException e){e.printStackTrace();}

		
	}
	
	public void add(String line){
		line2 = "";
		line2 = line2.concat(line);
		System.out.println(line2);
		
	}
	
	public void creatField(){
		String[] rows = line2.split(" ");
		
		int height = rows.length;
		char[] ch = rows[0].toCharArray();
		int width = ch.length;
		
		
		field = new int[height][width];
		
		for(int h = 0; h < height; h++){
			ch = rows[h].toCharArray();
			width = ch.length;
			for(int w = 0; w < width; w++){
				field[h][w]= (int)ch[w];
			}
		}
		
		
		
		
		//int height = rows.length;
		//System.out.println(height + "" + c);
	}
	// public void startGeneration(){
		// int Life;
		// for(int i = 0; i < N; i++){
			// System.out.print("\n");
			// for(int j = 0; j < M; j++){
				
				// if(Life == 1){
					// System.out.print(dote);
					// boolField[i][j] = Life;
				// }else{
					// System.out.print(blank);
					// boolField[i][j] = Life;
				// }
			// }
		// }	
	// }

}