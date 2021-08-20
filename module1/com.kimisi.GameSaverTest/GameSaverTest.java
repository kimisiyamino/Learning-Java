/*
transient - несерелизуем
*/

import java.io.*; // Serializable
//					ObjectOutputStream		FileOutputStream
//					ObjectInputStream		FileInputStream

import javax.swing.*;

public class GameSaverTest{
	public static void main(String[] args){
		GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "knuckle"});
		GameCharacter two = new GameCharacter(200, "Troll", new String[] {"fists", "axe"});
		GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});
		
		try{
			// FileOutputStream fileStream = new FileOutputStream("game.gg");
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("game.gg"));
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
			os.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		one = null;
		two = null;
		three = null;
		
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("game.gg"));
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			GameCharacter threeRestore = (GameCharacter) is.readObject();
			is.close();
			
			
			System.out.println("Type 1: " + oneRestore.getType() + "\n\tPower: " + oneRestore.getPower() + "\n\tWeapon: " + oneRestore.getWeapons());
			System.out.println("Type 2: " + twoRestore.getType()+ "\n\tPower: " + twoRestore.getPower() + "\n\tWeapon: " + twoRestore.getWeapons());
			System.out.println("Type 3: " + threeRestore.getType()+ "\n\tPower: " + threeRestore.getPower() + "\n\tWeapon: " + threeRestore.getWeapons());
			System.out.println("justVar: " + oneRestore.nonSer + twoRestore.nonSer + threeRestore.nonSer);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		try{
			//FileReader reader = new FileReader("cfg.txt");
			//reader.read();
			//reader.close();
			
			FileWriter writer = new FileWriter("ЗАЮША.txt");
			for(int i = 0; i <=100; i++)
			writer.write("зяюся зопа ");
			writer.close();
			
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}
}

class GameCharacter extends JComponent{
	transient String nonSer = "NonSerializable";
	int power;
	String type;
	String[] weapons;
	
	public GameCharacter(int p, String t, String[] w){
		power = p;
		type = t;
		weapons = w;
		
	}
	
	public int getPower(){
		return power;
	}
	
	public String getType(){
		return type;
	}
	
	public String getWeapons(){
		String weaponList = "";
		for(int i = 0; i < weapons.length; i++){
			weaponList+=weapons[i]+" ";
		}
		return weaponList;
	}
}