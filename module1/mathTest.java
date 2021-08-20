import java.lang.Math;

public class mathTest{
	public static void main(String[] args){
		// Рандом из двух чисел от 2 до 3
		System.out.println((int)((Math.random()*2)+2));
		// Абсолютное число  50.0
		System.out.println(Math.abs(-50.0));
		// Округление до ближайшего 45
		System.out.println(Math.round(44.6f));
		// Меньшее из двух 3
		System.out.println(Math.min(3, 50));
		// Большее из двух 50
		System.out.println(Math.max(3, 50));	
		
		// Корень из числа 2.0+1
		System.out.println(Math.sqrt(4)+1);
		// Куб из.. 5.0
		System.out.println(Math.cbrt(125));
		// Возвести в корень 16.0
		System.out.println(Math.pow(4,2));
		
		// Округление вниз 0.0 (if -0.9 floor = -1)
		System.out.println(Math.floor(0.9));
		// Округление вверх 1.0 (if -0.9 ceil = 0)
		System.out.println(Math.ceil(0.1));
		
		// Косинус	0.5403023058681398
		System.out.println(Math.cos(1));
		// Синус 		0.8414709848078965
		System.out.println(Math.sin(1));
		// Тангенс 	1.5574077246549023
		System.out.println(Math.tan(1));
		// Арк косинус 	0.0
		System.out.println(Math.acos(1));
		// Арк синус 		1.5707963267948966
		System.out.println(Math.asin(1));
		// Арк тангенс	 0.7853981633974483
		System.out.println(Math.atan(1));
		
		// Пи 3.141592653589793
		System.out.println(Math.PI);
		
		System.out.println(Math.IEEEremainder(0,0));
		System.out.println(Math.IEEEremainder(1,0));
		System.out.println(Math.IEEEremainder(0.0,2));
		System.out.println(Math.IEEEremainder(1,0));
		System.out.println(Math.IEEEremainder(15,2)); (a-b) * n = (15-2 * 1)
		System.out.println(Math.IEEEremainder(9,2));
		System.out.println(Math.IEEEremainder(233142,3));
		
	}
}