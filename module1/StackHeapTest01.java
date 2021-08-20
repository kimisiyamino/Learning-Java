public class StackHeapTest01{
	public static void main(String[] args){
		StartPr start = new StartPr();
		start.start();
	}

	
}

class StartPr{
	public void start(){
		Object ho = newHeapObject();	
		System.out.println(((HeapObject)ho).x);
	}
		
	public Object newHeapObject(){
		HeapObject ho = new HeapObject();
		ho.x = 777;
		return ho;
	}
}
 

class HeapObject{
	public int x = 999;
	
}

