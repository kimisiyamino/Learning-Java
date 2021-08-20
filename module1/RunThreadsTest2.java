
public class RunThreadsTest2 implements Runnable{
	static Thread gamma;
	
	public static void main(String[] args){
		RunThreadsTest2 runner = new RunThreadsTest2();
		RunThreadsTest2 runner2 = new RunThreadsTest2();
		RunThreadsTest2 runner3 = new RunThreadsTest2();
		Thread alpha = new Thread(runner);
		Thread beta = new Thread(runner2);
		gamma = new Thread(runner3);
		alpha.setName("ALPHA");
		beta.setName("BETA");
		gamma.setName("GAMMA");
		alpha.start();
		beta.start();
		gamma.start();
	}
	
	
	public void run(){
	
			for(int i = 0; i < 25; i++){
				
				try{
			gamma.sleep(2000);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			
			/*if(Thread.currentThread().getName() == "GAMMA"){
			try{
			Thread.sleep(5000);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			}*/
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread: "  + " "  + threadName);
		}
	}
	
}