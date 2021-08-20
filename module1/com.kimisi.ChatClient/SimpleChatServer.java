import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleChatServer{
	
	ArrayList<PrintWriter> clientOutputStreams;
	
	public void go(){
		clientOutputStreams = new ArrayList<PrintWriter>();
		try{
			ServerSocket serverSock = new ServerSocket(5000);							// Создаём сервер
			
			while(true){
					
				Socket clientSocket = serverSock.accept();								// Создаём сокет и ждём подключения клиента
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());	// Получаем Отправной поток
				clientOutputStreams.add(writer);
				
				Thread t = new Thread(new ClientHandler(clientSocket));					// Запускаем новый стек
				t.start();
				System.out.println("got a connection");
			}
		}catch(Exception ex){ex.printStackTrace();}
		
	}
	
	public void tellEveryone(String message){
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext()){
			try{
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
	
	public static void main(String[] args){
		new SimpleChatServer().go();
	}
	
	
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		
		public ClientHandler(Socket clientSocket){
			try{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());	// Создаём входной поток
				reader = new BufferedReader(isReader);

			}catch(Exception ex){ex.printStackTrace();}
		}
		
		public void run(){
			String message;
			try{
				while((message = reader.readLine()) != null){
					System.out.println("read " + message);
					tellEveryone(message);
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
}