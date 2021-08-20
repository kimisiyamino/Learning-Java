import java.util.Arrays;

public class QuicjSortTest{

	public static void main(String[] args){
		int[] array = {2,1}; 
		qsort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void qsort(int[] array, int L, int R){
		int pivot = array.length / 2;
		
		int temp = 0;
		
		while(L < R){
			while(array[L] < pivot){
				L++;
			}
			while(array[R] > pivot){
				R--;
			}	
			
			temp = array[L];
			array[L] = array[R];
			array[R] = temp;
			
			L++;
			R--;		
		}	//{0, 1 , 3.., 5!, 2 , 4}
		
		if(0 != L)
			qsort(array, 0, L);
		if(array.length != 1)
			qsort(array, L+1, array.length- L-1 );
	}
}

