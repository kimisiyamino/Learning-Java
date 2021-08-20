// synchronized

class BankAccount{
	private int balance = 100;
	
	public int getBalance(){
		return balance;
	}
	
	public void withdraw(int amount){
		balance-= amount; 
	}
}


public class RyanAndMonicaJob implements Runnable{
	private BankAccount account = new BankAccount();
	
	public void run(){
		for(int i = 0; i < 10; i++){
			makeWithdraw(10);
			if(account.getBalance() < 0){
				System.out.println("Превышение лимита!");
			}
		}
	}
	
	public synchronized void makeWithdraw(int amount){
		if(account.getBalance() >= amount){
			System.out.println(Thread.currentThread().getName() + "Собирается снять деньги");
			try{
				System.out.println(Thread.currentThread().getName() + " идёт спать");
				Thread.sleep(500);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " просыпается");
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName() + " заканчивает транзакцию. Бабло- " + account.getBalance());
			
		}else{
			System.out.println("Для клиента " + Thread.currentThread().getName() + " недостаточно денег");
		}
	}
	
	public static void main(String[] args){
		RyanAndMonicaJob theJob = new RyanAndMonicaJob();
		
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob);
		
		one.setName("Ryan");
		two.setName("Monica");
		
		one.start();
		two.start();
	}
}