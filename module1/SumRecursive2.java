

public class SumRecursive2{
	public static void main(String[] args){
		Integer[] arr = {1,2,3};
		System.out.println(sumArray(arr));
	}
	
	static int sumArray(Integer[] array){
        return sumArray(0, array); // 0, {0, 10, 20, 50, 60, 80};
    }
}
	