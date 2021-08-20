import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class BeatBox {
	
	JPanel mainPanel;						// Объявление Фоновой панели
	ArrayList<JCheckBox> checkboxList;		// Объявление Коллекции ArrayList<> для хранения Панелей с Флажками
	Sequencer sequencer;					// Объявление синтезатора
	Sequence sequence;						// Объявление последовательности
	Track track;							// Объявление Трека для последовательности
	JFrame theFrame;						// Объявление фрейма
	
		// Создание Массива String Названий Инструментов
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
		// Создание Массива int midi-Кодов инструментов
	int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
	
	
	public static void main(String[] args){	// Запуск программы
		new BeatBox().buildGUI();
	}
	
	public void buildGUI(){
		theFrame = new JFrame("Cyber BeatBox");						// Создание фрейма
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Закрыть на кнопку Крестик
		BorderLayout layout = new BorderLayout();								// Создание объекта Диспечера Компоновки BorderLayout
		JPanel background = new JPanel(layout);									// Создание панели с присвоением нашего диспечера
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	// Установить Границу: Пустая граница с отступом
		
		checkboxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		
		JButton start = new JButton("Start");
			start.addActionListener(new ActionListener(){  // MyStartListener
				@Override
				public void actionPerformed(ActionEvent a){
					buildTrackAndStart();
				}
			});
		buttonBox.add(start);
		
		JButton stop = new JButton("Stop");
			stop.addActionListener(new ActionListener(){ // MyStopListener
				@Override
				public void actionPerformed(ActionEvent a){
					sequencer.stop();
				}
			});
		buttonBox.add(stop);
		
		JButton clear = new JButton("Clear");
			clear.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent a){
					for(int i = 0; i < 256; i++){
						JCheckBox check = (JCheckBox)checkboxList.get(i);
						check.setSelected(false);
					}
					sequencer.stop();
				}
			});
		buttonBox.add(clear);
		
		JButton upTempo = new JButton("Tempo Up");
			upTempo.addActionListener(new ActionListener(){ // MyUpTempoListener
				@Override
				public void actionPerformed(ActionEvent a){
					float tempoFactor = sequencer.getTempoFactor();
					sequencer.setTempoFactor((float)(tempoFactor * 1.03));
				}
			});
		buttonBox.add(upTempo);
		
		JButton downTempo = new JButton("Tempo Down");
			downTempo.addActionListener(new ActionListener(){ // MyDownTempoListener
				@Override
				public void actionPerformed(ActionEvent a){
					float tempoFactor = sequencer.getTempoFactor();
					sequencer.setTempoFactor((float)(tempoFactor * 0.97));
				}
			});
		buttonBox.add(downTempo);
		
		JButton serializeIt = new JButton("serializeit");
			serializeIt.addActionListener(new ActionListener(){ // serializeIt
				@Override
				public void actionPerformed(ActionEvent a){
					boolean[] checkboxState = new boolean[256];
					
					for(int i = 0; i < 256; i++){
						JCheckBox check = (JCheckBox) checkboxList.get(i);
						if(check.isSelected()){
							checkboxState[i] = true;
						}
					}
					
					try{
						JFileChooser fileSerializ = new JFileChooser();
						fileSerializ.showSaveDialog(theFrame);
						
						FileOutputStream fileStream = new FileOutputStream(fileSerializ.getSelectedFile());
						ObjectOutputStream os = new ObjectOutputStream(fileStream);
						os.writeObject(checkboxState);
						os.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			});
		buttonBox.add(serializeIt);
		
		JButton restore = new JButton("restore");
			restore.addActionListener(new ActionListener(){ // restore
				@Override
				public void actionPerformed(ActionEvent a){
					boolean[] checkboxState = null;
					try{
						JFileChooser fileOpen = new JFileChooser();
						fileOpen.showOpenDialog(theFrame);
						
						FileInputStream fileIn = new FileInputStream(fileOpen.getSelectedFile());
						ObjectInputStream is = new ObjectInputStream(fileIn);
						checkboxState = (boolean[]) is.readObject();
						is.close();
					}catch(Exception ex){
						ex.printStackTrace();
					}
					
					for(int i = 0; i < 256; i++){
						JCheckBox check = (JCheckBox) checkboxList.get(i);
						if(checkboxState[i]){
							check.setSelected(true);
						}else{
							check.setSelected(false);
						}
					}
					
					sequencer.stop();
					buildTrackAndStart();
				}
			});
		buttonBox.add(restore);
		
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 16; i++){
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);
		
		theFrame.getContentPane().add(background);
		
		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);
		
		for (int i = 0; i < 256; i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		
		setUpMidi();
		
		theFrame.setBounds(50, 50, 300, 300);
		theFrame.pack();
		theFrame.setVisible(true);
	}
	
	public void setUpMidi(){
		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
			
		} catch(Exception e){e.printStackTrace();}
	}
	
	public void buildTrackAndStart(){
		int[] trackList = null;
		
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		
		for(int i = 0; i < 16; i++){
			trackList = new int[16];
			int key = instruments[i];
			
			for(int j = 0; j < 16; j++){
				JCheckBox jc = (JCheckBox) checkboxList.get(j + (16 * i));
				if(jc.isSelected()){
					trackList[j] = key;
				} else{
					trackList[j] = 0;
				}
			}
			
			makeTracks(trackList);
			//track.add(makeEvent(176, 1, 127, 0, 16));
		}
		
		track.add(makeEvent(192, 9, 1, 0, 16));
		try{
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch(Exception e){e.printStackTrace();}
	}
	
	public void makeTracks(int[] list){
		for(int i = 0; i < 16; i++){
			int key = list[i];
			
			if(key != 0){
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
	}
	
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception e){e.printStackTrace();}
		return event;
	}
}
