class GetterSetter{
	private String Name;
	private int Age;
	
	public void setName(String n){
		Name = n;
	}
	public String getName(){
		return Name;
	}
	public void setAge(int a){
		Age = a;
	}
	public int getAge(){
		return Age;
	}

}
public class GetterSetterTest01{
	public static void main(String[] args){
		String[] Names = new String[10];
		int[] Ages = new int[10];
		
		GetterSetter GS1 = new GetterSetter();
		GetterSetter GS2 = new GetterSetter();
		
		GS1.setName("имя1");
		Names[0] = GS1.getName();
		
		GS1.setAge(999);
		Ages[0] = GS1.getAge();
		
		GS2.setName("имя2");
		Names[1] = GS2.getName();
		
		GS2.setAge(888);
		Ages[1] = GS2.getAge();
		
		if(Names.length == Ages.length){
			for(int i =0; i<Names.length; i++){
				System.out.println(Names[i] + "\t\t" + Ages[i]);
				
			}
			for(String ii : Names){
				System.out.println(ii + "\t\t");
			}
		}

	}
}