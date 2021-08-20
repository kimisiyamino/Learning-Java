public class StringMethods{
	public static void main(String[] args){
		String string1 = "a, b, c, d, e, f, g, h, i, j";
		String string2 = "a, b, c, d, e, f, g, h, i, j";
		String string3 = "rgnnrignfdzgnaourgn;kzjek gzfldgnrzfrgnmzd lkngfldzkgnl'zk";
		StringBuffer string4 = new StringBuffer("a, b, c, d, e, f, g, h, i, j");
		
		char[] ch1 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
		
		char character 		= string1.charAt(3);					// char	charAt (int index);						// Получить символ
		int compare			= string1.compareTo(string2);			// int		compareTo (String anotherString);			// Сравнить строки // -N, 0, +N (string1 меньше/больше/равен string2
		int compareIgnore	= string1.compareToIgnoreCase(string2);	// int		compareToIgnoreCase (String anotherString);	// Сравнить строки (compareTo) + (toLowerCase)
		String stringConcat	= string1.concat(string2).concat("X");	// String	concat(String str)						// Конкатенация строк
		
			// еще о конкатенации
			String stringOperatorConcat	= string1 + string2;
					// то же что и :
			String stringRealConcat = new StringBuilder().append(string1).append(string2).toString();
				// null строки
			String stringNull = null;
			//String stringConcatWithNull = stringNull.concat(string1);	// NullPointerException
			String stringOperatorConcatWithNull = stringNull + string1;	// successful concat
		
		boolean contain 	= string3.contains("ur");									// boolean	contains (CharSequence s);				// Проверяет, есть ли в строке данные символы
		boolean contequals1	= string1.contentEquals(string2);							// boolean	contentEquals (CharSequence cs);			// Проверяет, равны ли строки (Только содерджимое и последовательность)
		boolean contequals2	= string1.contentEquals(string4);							// boolean	contentEquals (StringBuffer sb);
		String copyValueOf1 = ""; copyValueOf1 = copyValueOf1.copyValueOf(ch1);			// String 	copyValueOf(Char[] data)					// Массив символов char[ ] to String
		String copyValueOf2	= ""; copyValueOf2 = copyValueOf2.copyValueOf(ch1, 6, 5);	// String	copyValueOf(Char[] data, int offset, int value)	// Массив символов char[ ] to String от индекса 6, с длинной 5 (Массив, подмассив, длинна подмассива)
		
		int length 			= string1.length(); 										// int		length ();								// Длинна строки
		
		
		
		

		System.out.println(copyValueOf2);
	}
}