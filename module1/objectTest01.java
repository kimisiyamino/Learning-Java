import java.util.*;

public class objectTest01{
	public static void main(String[] args){
		Object box01 = new Object();
		Object box02 = new Object();
		
		ArrayList<Object> superBox = new ArrayList<Object>();
		
		superBox.add(box01);
		superBox.add(box02);
		
		
		System.out.println(superBox.get(0).hashCode());
		System.out.println(superBox.get(1).getClass());
		System.out.println(superBox.get(0).toString());
		System.out.println(superBox.get(0).equals(superBox.get(1)));
		
		//System s = new System();
		
		Object box03 = new ObjectGovno();
		
		/*if(box03 instanceof ObjectGovno){
			ObjectGovno box03_f = (ObjectGovno)box03;
			box03_f.glhf();
		}*/
		
		ObjectGovno box03_f = null;
		
		if(box03 instanceof ObjectGovno){
			box03_f = (ObjectGovno)box03;
		}
		
		box03_f.glhf();
		
		((ObjectGovno)box03).glhf();
		
	}
}

class ObjectGovno {
	public void glhf(){
		System.out.println("GL HF");
	}
}