import java.io.*;
import java.net.*;

public class DailyAdviceClient{
	
	public void go(){
		int y = 0;
		
		
		try{
			Socket s = new Socket("127.0.0.1", 4242);
			
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			//BufferedReader reader = new BufferedReader(streamReader);
			 while (y != 10) {
           int x = streamReader.read();
           System.out.print((char)x);
		   y++;
       }
			
			
			
			streamReader.close();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
	
}