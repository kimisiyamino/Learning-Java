public class inheritTest01{
	public static void main(String[] args){
		Weapons wep = new Weapons();
		Weapons hev = new HeavyWeapons();
		Weapons drob = new Shotgun();
		
		
		drob.Shot();
		
		HeavyWeapons hv = new Shotgun();
		HeavyWeapons hvv = new HeavyWeapons();
		
		
	}
	
}

// Родителя Родителя вызвать нельзя!
//	Решение: обход в родителе через super, но возможно ошибка в дизаёне проектирования наследования 
// Вызвать из ребёнка метод родителя, имея переопределённый метод родителя нельзя! 
//	Решение: Писать новый метод ??? (Добавление нового метода в ребёнка ???)  // 


class Weapons{
	int x = 0;
	public void Shot(){
		System.out.println("БАХ, ГЛАВНЫЙ КЛАСС");
	}
}

class HeavyWeapons extends Weapons{
	public void Shot(){
		
		System.out.println("БУУХ, ХЭВИ ВЕАПОН");
	}
	public void SuperShot(){
		super.Shot();
	}
}

class Shotgun extends HeavyWeapons{
	public void Shot(){
		super.SuperShot();
		
		this.super.Shot();
		System.out.println("ДРОБАШ БУДУУМС" + x);
		
	}
	
	
}