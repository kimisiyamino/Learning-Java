import javax.sound.midi.*;		// sequncer, track, ShortMessage
import java.io.*;				// ????
import javax.swing.*;			// jframe
import java.awt.*;				// events

public class MiniMusicPlayer3{
	
	static JFrame f = new JFrame("Music Player");		// Создаём окно
	static MyDrawPanel ml;								// Создаём панель отрисовки
	
	public static void main(String[] args){
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();	// Объект программы
		mini.go();										// Старт программы
	}
	
	public void setUpGui(){
		ml = new MyDrawPanel();				// Создаём панель отрисовки
		f.setContentPane(ml);				// Фрейм: ??????
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1920, 1080);
		f.setBounds(30, 30, 300, 300);		// Фрейм: ?????
		f.setVisible(true);					// Фрейм: видим
	}
	
	public void go(){
		setUpGui();							// Вызов предыдущего метода (настроек, SETUP)
		
		try{
			Sequencer sequncer = MidiSystem.getSequencer(); 			// Получить синт
			sequncer.open();											// Открыть синт
			sequncer.addControllerEventListener(ml, new int[] {127});	// Добавляем слушателя ml (панель рисования), 
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);				// Создаем последовательность (Тип разделения времени, Расрешение Синхронизации)
			Track track = seq.createTrack();							// Создаём и добавляем трек в последовательность
			
			int r = 0;
			for(int i = 0; i<50000; i+=4){
				r = (int)((Math.random()*70)+10);
				track.add(makeEvent(144, 1, r, 100, i));				// Тип сообщения / Канал / Нота / скорость,сила / tick(для MidiEvent)
				track.add(makeEvent(176, 1, 127, 0, i));				// СТРОЧКА ДЛЯ СЛУШАТЕЛЯ
				track.add(makeEvent(128, 1, r, 100, i+2));				// 144 - start, 128 - end, 176 - ControllerEvent, 192- change instrument
			}
			
			sequncer.setSequence(seq);									// Добавляем последовательность с треком внутри (внутри мессадж)
			sequncer.start();										    // Запускаем музыку
			sequncer.setTempoInBPM(1500);								// Добавляем темп
		}catch (Exception ex){ex.printStackTrace();}						// Исключение для класса Sequencer
	}
	
	public MidiEvent makeEvent(int comd, int chan, int note, int attack, int tick){ // Метод упращения создания звука
		MidiEvent event = null;
		try{
			ShortMessage message = new ShortMessage();
			message.setMessage(comd, chan, note, attack);
			event = new MidiEvent(message, tick);
		}catch(Exception e){}	
		return event;
	}
	
	class MyDrawPanel extends JPanel implements ControllerEventListener{
		boolean msg = false;
		
		public void controlChange(ShortMessage event){
			msg = true;
			repaint();
		}
		
		public void paintComponent(Graphics g){
			if(msg){
				Graphics2D g2d = (Graphics2D)g;
				
				int r = (int)((Math.random()*250));
				int gr=	(int)((Math.random()*250));
				int b =	(int)((Math.random()*250));
				
				g2d.setColor(new Color(r, gr, b));
				
				int ht		= (int)((Math.random()*120)+10);
				int width	= (int)((Math.random()*120)+10); 
				int x		= (int)((Math.random()*1900)+10); 
				int y		= (int)((Math.random()*800)+10);
				
				g2d.fillRect(x, y, ht, width);
				msg = false;
			}
		}
	}
}