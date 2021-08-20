package QuizCardBuilder;

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import QuizCardBuilder.QuizCard;

public class QuizCardBuilder{
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;
	
	public static void main(String[] args){
		QuizCardBuilder builder = new QuizCardBuilder();
		builder.go();
	}
	
	public void go(){
		// Создаём фрейм
		frame = new JFrame("Quiz Card Builder");			
		JPanel mainPanel = new JPanel();
		
		// Создаём текстовое поле 1
		Font bigFont = new Font("sanserif", Font.BOLD, 24);	// Font
		question = new JTextArea(6,20);						// TextArea 6 rows, 20 columns
		question.setLineWrap(true);							// перенос строки +
		question.setWrapStyleWord(true);					// перенос слов +
		question.setFont(bigFont);							// set font
			// скролл для текстовое поле 1
		JScrollPane qScroller = new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// Создаём текстовое поле 2
		answer = new JTextArea(6,20);					// TextArea 6 rows, 20 columns
		answer.setLineWrap(true);						// перенос строки +
		answer.setWrapStyleWord(true);					// перенос слов +
		answer.setFont(bigFont);	
			// скролл для текстовое поле 2
		JScrollPane aScroller = new JScrollPane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		
		cardList = new ArrayList<QuizCard>();
		
		JLabel qLabel = new JLabel("Question:");
		JLabel aLabel = new JLabel("Answer:");
		
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
			// LISTENER nextButton
		nextButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				QuizCard card = new QuizCard(question.getText(), answer.getText());
				cardList.add(card);
				clearCard();
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		
			// LISTENER newMenuItem
		newMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				cardList.clear();
				clearCard();
			}
		});
			// LISTENER saveMenuItem
		saveMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				QuizCard card = new QuizCard(question.getText(), answer.getText());
				cardList.add(card);
				
				JFileChooser fileSave = new JFileChooser();
				fileSave.showSaveDialog(frame);
				saveFile(fileSave.getSelectedFile());
			}
		});
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void clearCard(){
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
	
	public void saveFile(File file){
		try{
			//BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			FileWriter writer = new FileWriter(file);
			for(QuizCard card : cardList){
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");
			}
			writer.close();
			
		}catch(IOException ex){
			System.out.println("couldn't write the cardList out");
			ex.printStackTrace();
		}
	}
	
}

