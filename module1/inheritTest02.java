import java.util.*;

public class inheritTest02{
	public static void main(String[] args){
		Pistols[] p = new Pistols[2];
		
		Deagle deagle01 = new Deagle();
		
		Pistols Gl = new Glock();
		
		Gl.Shot();
		
		p[0] = deagle01;
		p[1] = new Glock();
		
		for(Pistols pCheck: p){
			pCheck.Shot();
		}
		
		// System.out.println(p[0].x); ОШИБКА, ПРИВАТНЫЙ ЭЛЕМЕНТ, НЕ НАСЛЕДОВАН

		p[0].Shot();
		
	//	p[0].GET_X(); ОШИБКА. Отсутствие в родительском (абстрактном) классе метода GET_X (Ошибка типа, p[0] - ссылка типа Pistols (в пистолс нет метода get.x) 
	//	(Deagle)p[0].GET_X();
		System.out.println("===      ((Deagle)p[0]).GET_X(): ");
		((Deagle)p[0]).GET_X();
		
			
		System.out.println("===      deagle01.GET_X: ");
		deagle01.GET_X();
		System.out.println("===      deagle01.sentX(): ");
		deagle01.sentX();
		System.out.println("===     deagle01.Shot(): ");
		deagle01.Shot();
		
		Pistols Mega = new MegaDeagle();
		Mega.Shot(); 
		// Mega.Shot2(); ОШИБКА. Отсутствие в родительском (абстрактном) классе метода Shot2
		
		MegaDeagle Mega2 = new MegaDeagle();
		Mega2.Shot();
		Mega2.Shot2();
		
		
		R r = new R8();
		r.Shot();
		r.SuperShot();
		// r.SuperShot2(); ОШИБКА. Отсутствие в родительском классе метода SuperShot2
		
		R8 r8 = new R8();
		r8.SuperShot2();
		
		Pistols_RW[] rwrw = new Pistols_RW[4];
			rwrw[0] = new R();
			rwrw[1] = new W();
			rwrw[2] = new R8();
			rwrw[3] = new W8();
		
		for(Pistols_RW rwCheck: rwrw){
			rwCheck.Shot();
		}
		
		
		ArrayList<Pistols_RW> rwrw2 = new ArrayList<Pistols_RW>();		
			rwrw2.add(rwrw[0]);
			rwrw2.add(rwrw[1]);
			rwrw2.add(rwrw[2]);
			rwrw2.add(rwrw[3]);
		
		for(Pistols_RW rwCheck2: rwrw2){
			rwCheck2.Shot();
		}
		
	}	
}

abstract class Pistols {
	abstract void Shot();
	private int x = 0;
	private double x_d;
	
	final void sentX(){
		System.out.println("ГЛАВНЫЙ КЛАСС Final Test");
	}
	
	public int message(int y){
		System.out.println("Я ГЛАВНЫЙ КЛАСС");
		x = y;
		return x;
	}
	public double message(double y){
		System.out.println("Я ГЛАВНЫЙ КЛАСС");
		x = (int)y;
		return x;
	}
	public double message(double y, boolean b){
		System.out.println("Я ГЛАВНЫЙ КЛАСС");
		x_d = y;
		return x_d;
	}
}
class Deagle extends Pistols{
	
	public void Shot(){
		System.out.println("Deagle SHOT!");
	}
	
	public void GET_X(){
		System.out.println(message(5));
		System.out.println(message(5.0));
		System.out.println(message(7.9575465346, false));
		sentX();
	}
	
}
class Glock extends Pistols{
	
	public void Shot(){
		System.out.println("Glock SHOT!");
	}
	
}
class MegaDeagle extends Deagle{
	public void Shot(){
		super.Shot();
			System.out.println("MegaDeagle SHOT!");
		
	}
	public void Shot2(){
		super.Shot();
			System.out.println("MegaDeagle SHOT2!");
		
	}
//	public sentX(){		System.out.println("sent");} Ошиька , Final Метод
	
}

abstract class Pistols_RW {
	abstract void Shot();
}

class R extends Pistols_RW{
	public void Shot(){
		System.out.println("Shot R class");
	}
	public void SuperShot(){}
}

class W extends Pistols_RW{
	public void Shot(){
		System.out.println("Shot W class");
	}
}

class R8 extends R{
	public void Shot(){
		System.out.println("Shot R8 - 200");
	}
	
	public void SuperShot(){
		System.out.println("SuperShot R8 - 200");
	}
	public void SuperShot2(){
		System.out.println("SuperShot2 R8 - 200");
	}
}
class W8 extends W{
	public void Shot(){
		System.out.println("Shot W8 - 100");
	}
}
