import java.io.*;

public class TestIO{
	public static void main(String[] args){
		TestIO_start start = new TestIO_start();
		start.saveFile();
		start.loadFile();
	}
}

class TestIO_start implements Serializable{
	
	static final long serialVersionUID = -8576628613570949274L;
	
	public void loadFile(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("TestIO.n"));
			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line + "===СЧИТАНО");
				
			}
			reader.close();
		}catch(IOException ex){
			System.out.println("couldn't read the cardList out");
			ex.printStackTrace();
		}
	}
		
	public void saveFile(){
		try{
			//BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			FileWriter writer = new FileWriter("TestIO.n");
			writer.write("mess1\n");
			writer.write("mess2\n");
			writer.write("mess3\n");
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
		
}