public class Memory_HeapStack {
 
    public static void main(String[] args) { // строка 1
        int i=1; // строка 2
        Object object = new Object(); // строка 3
        Memory_HeapStack memory = new Memory(); // строка 4
        memory.exMethod(object); // строка 5
    } // строка 9
 
    private void exMethod(Object param) { // строка 6
        String string = param.toString(); // строка 7
        System.out.println(string );
    } // строка 8
 
}