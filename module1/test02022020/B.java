import java.io.*;

public class B{
	public static void main(String[] args){
		int sum = 0;
		BufferedReader input = null; 
		BufferedWriter output = null;
		
			try{
				input = new BufferedReader(new FileReader(new File("input.txt")));
				String inputString = input.readLine();
				input.close();
				
				String[] numsString = inputString.split(" ");
				sum = (Integer.parseInt(numsString[0])) + (Integer.parseInt(numsString[1]));
				
			}catch(IOException ex){
				ex.printStackTrace();
			}finally{
				try{
					input.close();
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}

			try{
				output = new BufferedWriter(new FileWriter(new File("output.txt")));
				String outputString = Integer.toString(sum);
				output.write(outputString);
				
			}catch(IOException ex){
				ex.printStackTrace();
			}finally{
				try{
					output.close();
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
		}
}