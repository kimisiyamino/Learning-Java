class OuterClass{
	public void Outerfun(){
			System.out.println("Я обычная функция внешнего класса");
		}
	
	public static void OuterStaticFun(){
		System.out.println("Я статическая функция внешнего класса");
	}

	private class NestedInnerClass{
		public void NonStaticfun(){
			System.out.println("Я обычная функция вложенного класса");
			OuterStaticFun();
			Outerfun();
		}
	}
	
	public static class StaticNestedClass{
		public void NonStaticFun_staticClass(){
			System.out.println("Я обычная функция вложенного static класса");
			OuterStaticFun();
		
		}
		public static void staticFun_staticClass(){
			System.out.println("Я статическая функция вложенного static класса");
			OuterStaticFun();
			StaticNestedClass2.staticFun_staticClass2();
		}
	}
	
	static class StaticNestedClass2{
		public void NonStaticFun_staticClass(){
			System.out.println("Я обычная функция вложенного static класса");
			OuterStaticFun();
		
		}
		public static void staticFun_staticClass2(){
			System.out.println("Я статическая функция вложенного static класса 2");
			OuterStaticFun();

		}
	}
}



class TestClasses{
	public static void main(String[] args){
	
		
		
	}
}