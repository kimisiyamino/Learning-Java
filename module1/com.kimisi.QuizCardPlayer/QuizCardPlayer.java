import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import QuizCardBuilder.QuizCardBuilder;
import QuizCardBuilder.QuizCard;

public class QuizCardPlayer{
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;
	
	public static void main(String[] args){
		QuizCardPlayer reader = new QuizCardPlayer();
		reader.go();
	}
	
	public void go(){
		// Создаём фрейм
		frame = new JFrame("Quiz Card Player");			
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);	// Font
		
		// Создаём текстовое поле 
		
		display = new JTextArea(10,20);						// TextArea 10 rows, 20 columns
		display.setFont(bigFont);							// set font
		display.setLineWrap(true);							// перенос строки +
		//display.setWrapStyleWord(true);					// перенос слов +
		display.setEditable(false);
		
		
			// скролл для текстовое поле 
		JScrollPane qScroller = new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		nextButton = new JButton("Show Question");
		mainPanel.add(qScroller);
		mainPanel.add(nextButton);
		
		nextButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(isShowAnswer){
					display.setText(currentCard.getAnswer());
					nextButton.setText("Next Card");
					isShowAnswer = false;
				}else{
					if(currentCardIndex < cardList.size()){	
						showNextCard();
					}else{
						display.setText("That was last card");
						nextButton.setEnabled(false);
					}	
				}
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		
		loadMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JFileChooser fileOpen = new JFileChooser();
				fileOpen.showOpenDialog(frame);
				loadFile(fileOpen.getSelectedFile());
			}
		});
		
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void loadFile(File file){
		cardList = new ArrayList<QuizCard>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line + "===СЧИТАНО");
				makeCard(line);
			}
			reader.close();
		}catch(IOException ex){
			System.out.println("couldn't read the cardList out");
			ex.printStackTrace();
		}
		showNextCard();
	}
	
	private void makeCard(String lineToParse){
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
		System.out.println("made a card");
	}
	
	private void showNextCard(){
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer = true;
	}
	
	
}