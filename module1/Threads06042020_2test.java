class Threads06042020_2t{
	boolean isGet = false;
	public synchronized void funcPrint2(Thread t){
		System.out.println("1 METHOD II  " + t.getName());
		System.out.println("2 METHOD II  " + t.getName());
		System.out.println("3 METHOD II  " + t.getName());
		System.out.println("4 METHOD II  " + t.getName());
		System.out.println("5 METHOD II  " + t.getName());
		
		try{
			while(!isGet){
			wait();
		}
		}catch(InterruptedException e){
			
		}
		
		notify();
		System.out.println("ЗАБРАЛ");
		isGet = false;
	}
	
	public synchronized void funcPrint1(Thread t){
		System.out.println("1 METHOD I  "+ t.getName());
		System.out.println("2 METHOD I  "+ t.getName());
		System.out.println("3 METHOD I  "+ t.getName());
		System.out.println("4 METHOD I  "+ t.getName());
		System.out.println("5 METHOD I  "+ t.getName());
		
		try{
			while(isGet){
			wait();
		}
		}catch(InterruptedException e){}
		
		notify();
		System.out.println("Отправил");
		isGet = true;
	}
}

class Threads06042020_22t implements Runnable{
	Threads06042020_2t q;
	public Threads06042020_22t(Threads06042020_2t q){
		this.q = q;
	}
	
	public void run(){
		try{
			Thread.sleep(1000);
			q.funcPrint1(Thread.currentThread());
			q.funcPrint2(Thread.currentThread());
		}catch(Exception e){
			
		}
		
	}
}


public class Threads06042020_2test{
	public static void main(String[] args){
		Threads06042020_2t q = new Threads06042020_2t();
		
		Runnable r1 = new Threads06042020_22t(q);
		Runnable r2 = new Threads06042020_22t(q);
		
		Thread t1 = new Thread(r1, "ПОТОК ГОША");
		Thread t2 = new Thread(r2, "ПОТОК РОША");
		
		t1.start();
		t2.start();
	}
}