public class SelectionSort{
	public static void main(String[] args){
			int[] array = {5, 87, 1, 0, 55, 342123, 21423 ,52352, 523535, 2535};
			printArray(array);
			
			for (int i = 0 ; i < array.length - 1; i++){	//len=10, 0 - 9
				int min = i;								// least 0 
				for (int j = i + 1; j < array.length; j++){	// j 1			2
					if(array[j] < array[min]){				// if 87< 5?	1 < 5?-> 
						min = j;								
					}
				}
				
				int temp = array[i]; array[i] = array[min]; array[min] = temp; // SWAP
				
				printArray(array);
				
			}
			
			
			
	}
	
	public static void printArray(int [] arr){
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
}