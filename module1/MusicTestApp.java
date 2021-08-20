import javax.sound.midi.*;

public class MusicTestApp{
	public static void main(String[] args){
		MusicTestApp app = new MusicTestApp();
		app.play();
	
	}
	
	public void play(){
		try{
			Sequencer player = MidiSystem.getSequencer(); // Получить синт
			player.open();								  // Открыть синт
			
			Sequence seq = new Sequence(Sequence.PPQ, 4); // Получить последовательность
			
			Track track = seq.createTrack(); // Запрашиваем трек у Sequence
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 44, 100); //(type of message, canal, note, speed/attack)
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 1, 100); //(type of message, canal, note, speed/attack)
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
			
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}