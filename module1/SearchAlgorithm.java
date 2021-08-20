public class SearchAlgorithm{
	public static void main(String[] args){
		int[] arr = {2,5,3,7,0};
		
		insertionSort(arr);
		
	
	}
		// Линейный поиск
		/*
			Метод перебоора всех элементов.
		*/
	public static int linearSearch(int arr[], int elementToSearch) {
		for(int i = 0; i < arr.length; i++){
			if(elementToSearch == arr[i]){
				return i;
			}
		}
		return -1;	
	}
		// Бинарный поиск (двоичный)
		/*
			Метод перебоора всех элементов.
		*/
	
	public static int binarySearch(int arr[], int elementToSearch) {

		int firstIndex = 0;
		int lastIndex = arr.length - 1;
		
		while(firstIndex <= lastIndex) {
			int middleIndex = (firstIndex + lastIndex) / 2;
			// если средний элемент - целевой элемент, вернуть его индекс
			if (arr[middleIndex] == elementToSearch) {
				return middleIndex;
			}
				// если средний элемент меньше
				// направляем наш индекс в middle+1, убирая первую часть из рассмотрения
			else if (arr[middleIndex] < elementToSearch)
				firstIndex = middleIndex + 1;

				// если средний элемент больше
				// направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
			else if (arr[middleIndex] > elementToSearch)
				lastIndex = middleIndex - 1;

		}
		return -1;
	
	
	}
	
	public static void bubbleSort(int[] array) {  
		boolean sorted = false;
		int temp;
		while(!sorted) {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i+1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					sorted = false;
				}
			}
		}
	}
	public static void insertionSort(int[] array) {  
		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int j = 0;
			for( j = i - 1; j >= 0 && current < array[j]; j--) 
				array[j+1] = array[j];
				
			
			 // в этой точке мы вышли, так что j так же -1 
			 // или в первом элементе, где текущий >= a[j]
			array[j+1] = current;
			
		
		}
			for(int x =0; x < array.length; x++)
				System.out.println(array[x]);
		
		/*
			1; 1 < 
		*/
		
	
		
	
		
	}
		
	
}