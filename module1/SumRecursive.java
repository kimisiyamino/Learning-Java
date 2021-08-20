import java.util.LinkedList;

public class SumRecursive{
	public static void main(String[] args){
		int[] arr = {2312, 214, 13423, 2134234, 1214 , 231};
		int sumArrR = sumR(arr, arr.length);
		int sumArrC = sumC(arr);
		System.out.println(sumArrR);
		System.out.println(sumArrC);
		
	
	}
	public static int sumR(int[] arr, int len){
		if(len == 2)	return arr[0] + arr[1];
		else			return arr[len-1] + sumR(arr, len-1);
	}
	public static int sumC(int[] arr){
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum+=arr[i];
		return sum;
	}
	
}