public class Thread_test implements Runnable{
	Thread newThread;
	String nameThread;
	
	Thread_test(String nameThread){
		this.nameThread = nameThread;
		newThread = new Thread(this, nameThread);
		newThread.start();
	}
	
	public static void main(String[] args){
		Thread mainThread = Thread.currentThread();
		mainThread.setName("Главный поток");
		System.out.println(mainThread);
		Thread_test t2 = new Thread_test("Второй поток");
		Thread_test t3 = new Thread_test("Третий поток");
		try{
			t2.newThread.join();
			t2.newThread.sleep(5000);
			t3.newThread.join();
		}catch(Exception e) {}
		System.out.println("Выполнение главного потока...");
	}
	
	@Override
	public void run(){
		System.out.println("Выполнение потока..." + nameThread);
		
	}
	
}