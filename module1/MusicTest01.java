import javax.sound.midi.*;

class MusicTest01{
	
	public void play(){
		try{
			Sequencer sequencer = MidiSystem.getSequencer();
			System.out.println("Мы получили синт");
		} catch (MidiUnavailableException ex){
			System.out.println("Сорян, какая то...");
		}
	}
	
	public void gg() throws AHUET {
		System.out.println("");
		throw new AHUET();
		
	}
	
	public static void main(String[] args) {
		MusicTest01 mt = new MusicTest01();
		mt.play();
		try{
			mt.gg();
		}catch(AHUET ex){}
		
		
	}
}

class AHUET extends Exception{}