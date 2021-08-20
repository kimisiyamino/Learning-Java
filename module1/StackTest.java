import java.util.Scanner;

class Stack{
	private int count = -1;
	private int[] stck;
	
	public Stack(){
		stck = new int[10];
	}
	
	public Stack(int size){
		stck = new int[size];
	}
	
	public int getSize(){
		System.out.println("Размер стека " + stck.length);
		return stck.length;
	}
	public int getTop(){
		System.out.println("Текущая вершина " + (count+1) + " из " + stck.length);
		return count + 1;
	}
	
	
	// Вытащить верхний элемент из стека и удалить
	public int pull(){
		if(count > -1){
			int temp = stck[count];
			System.out.println("Значение " + temp + " индекса " + count + " покинуло стек");
			stck[count--] = 0;
			getTop();
			return temp;
		}else{
			System.out.println("Стек пуст");
			return 0;
		}
	}
	
	// Получить значение 
	public int get(int index){
		if(index <= count && index > -1){
			System.out.println("Индекс " + index + ", значение " + stck[index]);
			return stck[index];
		}else{
			System.out.println("Отстутствует значение");
			return 0;
		}
	}
	
	// Вставить в стек
	public void put(int obj){
		if(count < stck.length - 1){ 
			stck[++count] = obj;
			System.out.println("В элемент " + count + " добавлено " + obj);
		}else{
			System.out.println("Стек полон!");
		}
	}
	
	// Печать стека
	public void print(){
		if(count==-1){
			System.out.println("Стек пуст");
		}else{
			System.out.println("\tStack: ");
			for(int i = stck.length - 1; i >= 0; i--){
				System.out.println("{" + i + "}" + " " + stck[i]);
			}
			System.out.print("\n");
		}
	}
}

class StackTest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		Stack s = new Stack(30);
		s.getTop();
		s.print();
		
		s.put(1);
		s.put(2);
		s.put(3);
		s.put(4);
		
		s.get(1);
		s.get(0);
		s.get(6);
		s.get(-999);
		
		s.print();
		
		int[] arr = new int[3];
		
		for(int i : arr)
			i = s.pull();
		
		s.print();
		
		s.put(666);
		s.put(777);
		s.put(888);
		
		s.getSize();
		s.getTop();
		
		//s.pull();
	}
}