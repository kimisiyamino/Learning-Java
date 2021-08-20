import java.util.LinkedList;
import java.util.List;

/*

addFirst() / offerFirst()	добавляет элемент в начало списка
addLast() / offerLast()	добавляет элемент в конец списка
removeFirst() / pollFirst()	удаляет первый элемент из начала списка
removeLast() / pollLast()	удаляет последний элемент из конца списка
getFirst() / peekFirst()	получает первый элемент
getLast() / peekLast()	получает последний элемент

add(E e)	Appends the specified element to the end of this list.
add(int index, E element)	Inserts the specified element at the specified position in this list.

remove()	Retrieves and removes the head (first element) of this list.
remove(int index)	Removes the element at the specified position in this list.
boolean remove(Object o)	Removes the first occurrence of the specified element from this list, if it is present.

get(int index)	Returns the element at the specified position in this list.
getFirst() Returns the first element in this list.
getLast() Returns the last element in this list.

set(int index, E element)	Replaces the element at the specified position in this list with the specified element.
size() Returns the number of elements in this list.

clear() Removes all of the elements from this list.
Object	clone() Returns a shallow copy of this LinkedList.
boolean	contains(Object o) Returns true if this list contains the specified element.

*/



public class LinkedListTest{
	public static void main(String[] args){
		LinkedList<String> linkListS = new LinkedList<String>();
		linkListS.add(new String("one"));
		linkListS.add(new String("two"));
		linkListS.add(new String("three"));
		linkListS.add(new String("four"));
		linkListS.add(new String("five"));
		
		LinkedList<Integer> linkListI = new LinkedList<Integer>();
		linkListI.add(45645);
		linkListI.add(234234);
		linkListI.add(45634);
		linkListI.add(32423423);
		linkListI.add(464565487);
		linkListI.add(234324);
		
		LinkedList<Integer> linkListICopy = (LinkedList)linkListI.clone();
	
		
		int sizeS = sizeList(linkListS, 0);
		System.out.println(sizeS);
		int sizeI = sizeList(linkListI, 0);
		System.out.println(sizeI);
		
		sortList(linkListICopy,sizeI);
		System.out.println(linkListICopy);
		sortList2(linkListI, sizeI);
		System.out.println(linkListI);
		
		int max = binarySearch(linkListI, size);
		System.out.println(max);
		
	}
	
	public static int sizeList(List list, int n){
		try{
			if(list.get(n) != null) return sizeList(list, ++n);
		}catch(IndexOutOfBoundsException e){
			return n;
		}
		return 0;
	}
	
	// Selection sort
	public static List sortList(List linkListI, int size){
		for(int i = 0; i < size; i++){
			int min = ((int)linkListI.get(i));
			int index = i;
			for(int j = i+1; j < size; j++){
				if(min > ((int)linkListI.get(j))){
					min = ((int)linkListI.get(j));
					index = j;
				}
			}
			int temp = ((int)linkListI.get(i));
			linkListI.set(i, min);
			linkListI.set(index, temp);
		}
		return linkListI;
	}
	
	// Insertion sort
	public static List sortList2(List linkListI, int size){
		System.out.println("Sorting: ");
		for(int i = 1; i < size; i++){
			int temp = (int)linkListI.get(i);
			int j = i - 1;
			while(j >= 0 && temp < (int)linkListI.get(j)){
				linkListI.set(j+1, linkListI.get(j));
				linkListI.set(j, temp);
				j--;
			}	
		}
		return linkListI;
	}
	
	public static int binarySearch(List sortedlinkList, int size, int maxElement){
		int left = 0;
		int right = size - 1;
		
		int middle = (left+rigth)/2;
		
	}
	
	public static int maxValueRecursive(){
		
	}
}