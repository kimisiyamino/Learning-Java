class threadTtTtTt implements Runnable{
	
	Thread thread;
	static int count;
	int num;
	int sleep;
	
	public threadTtTtTt(int sl){
		thread = new Thread(this);
		num = ++count;
		sleep = sl;
	}
	
	public void run(){
		for(int i = 0; i < 10; i++){
			try{
				System.out.println("Я поток номер " + num);
				thread.sleep(sleep);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		try{
			
			thread.sleep(sleep);
			Threads06042020.synch();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		synchronized(this){
			run2();
		}
		
		System.out.println("== == == == ЗАВЕРШЕНИЕ ПОТОКА " + num);
	}
	public void run2(){
		System.out.println("SYNCH4.0 управляет Thread # " + Thread.currentThread());
	}
}

public class Threads06042020 {
		
		
	public static void main(String[] args){
		Threads06042020 t = new Threads06042020();
		
		threadTtTtTt t1 = new threadTtTtTt(500);
		threadTtTtTt t2 = new threadTtTtTt(500);
		threadTtTtTt t3 = new threadTtTtTt(500);
		
		System.out.println("== == == == СТАРТ ПОТОКА 1");
		t1.thread.start();
		System.out.println("== == == == СТАРТ ПОТОКА 2");
		t2.thread.start();
		System.out.println("== == == == СТАРТ ПОТОКА 3");
		t3.thread.start();
		
		try{
			System.out.println("== == == == ЖДЁМ ПОТОКs");
			
			t3.thread.join();
			t2.thread.join();
			t1.thread.join();
			System.out.println("== == == == хуец");
			//Thread.currentThread().join();
		}catch(InterruptedException e){
		}
		
		Thread mainThread = Thread.currentThread();
		System.out.println("== == == == ЗАВЕРШЕНИЕ ГЛАВНОГО ПОТОКА");
		
	}
	
	synchronized public static void synch(){
		for(int i = 0; i < 10; i++){
			System.out.println("SYNCHoм управляет Thread # " + Thread.currentThread());
		}
	}
	
	public void synch2(){
		synchronized(this){
			System.out.println("SYNCH2.0 управляет Thread # " + Thread.currentThread());
		}
		System.out.println("NO_SYNCH2.0 управляет Thread # " + Thread.currentThread());
			
	}
}