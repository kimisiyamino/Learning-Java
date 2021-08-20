public class STATICTEST03{

	static int value = 8;
	static void click(){
		if (value % 4 == 0)
			value /=2;
		else
			value +=3;
	}
	
	public static void main(String[] args){
		System.out.println("СТАРТ: x = " + value);
		for(int i=0; i <=3;i++){
			click();
			System.out.println("ЦИКЛ " + i + " : x = " + value);
		}
		System.out.print(value);
	}
}