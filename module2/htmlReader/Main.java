import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main{
	public static void main (String[] args) throws Exception{
		
		BufferedReader reader;
		String input, file;
		
		File files = new File("pages\\.");
		//System.out.println(files.isDirectory());
		
		if(!files.isDirectory()){
			files.mkdir();
		}
		
		int i = 0;
		if(files != null && files.listFiles().length != 0 && files.listFiles() != null){
			for( File f : files.listFiles()){
				if(f.getName().matches("\\w[a-zA-Z0-9-_]*\\.html"))
					System.out.println(++i + ". " + f.getName());
			}
		
			while(true){
				try{
					System.out.print("Enter file name: ");	
					input = new BufferedReader(new InputStreamReader(System.in)).readLine();
					if(input.equals("exit")){
							exit();
					}
					
					reader = new BufferedReader(new FileReader("pages\\" + input + ".html"));
					
					String templine = "";
					file = "";
					while((templine = reader.readLine()) != null ){
						//System.out.println(templine);	
						file += templine;
					}
					break;
				}catch(FileNotFoundException fileNotFoundException){
					System.out.println("File not found!");	
				}catch(IOException ioexception){
					System.out.println("Error!");
					ioexception.printStackTrace();
				}
			}
			
			
			//Pattern pattern = Pattern.compile("data-mp3=\"(https:.+\\.(mp3|ogg))");
			Pattern pattern = Pattern.compile("data-(mp3|ogg)=\"(https:.+?\\.(mp3|ogg))");
			Matcher matcher = pattern.matcher(file);
			
			ArrayList<String> list = new ArrayList<>();
			i = 0;
			while(matcher.find()){
				String temp = "";
				System.out.println(temp = String.format("%04d. ", ++i) + matcher.group(2));
				list.add(temp);
			}
			//System.out.println(list.toString());
			while(true){
				try{
						System.out.print("№: ");
						input = new BufferedReader(new InputStreamReader(System.in)).readLine();
						if(input.equals("exit")){
							exit();
						}
						int num = Integer.parseInt(input);
						System.out.println("Open: " + list.get(num-1).split(" ")[1]);
						Desktop.getDesktop().browse(new URI(list.get(num-1).split(" ")[1]));	
							
				}catch(NumberFormatException numberException){
						System.out.println("Not valid!");
				}catch(IndexOutOfBoundsException indexOutOfBoundsException){
						System.out.println("Not valid!");
				}catch(IOException ioexception){
						System.out.println("Error!");
						ioexception.printStackTrace();
				}catch(URISyntaxException uriexception){
						System.out.println("Error!");
						uriexception.printStackTrace();
				}
			}
		}else{
			System.out.println("Files not found!");
			exit();
		}
	}
	
	public static void exit(){
		System.out.println("Goodbye!");
		System.exit(0);
	}
}