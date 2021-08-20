import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TestFrame02 implements ActionListener, MouseListener{
	JButton button;
	JButton button02;
	MyDrawPanel01 ppp;
	JFrame frame;
	public static void main(String[] args){
		TestFrame02 gui = new TestFrame02();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame("Новое окно"); // Новое окно
		button = new JButton("Кнопка");
		button02 = new JButton("Кнопка2");
		ppp = new MyDrawPanel01();

		//
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Нажатие на крестик
		frame.setUndecorated(false);						  // Убрать "Свернуть, развернуть, закрыть" ?
		
	//	frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 		    // Максимальный размер
		frame.setSize(1024, 768);					  		  // Размер
		frame.setResizable(true);							  // Менять размер

		frame.setVisible(true);	  	 						  // Видимость
		//
		
		button.addActionListener(this);
		button02.addActionListener(this);
		//frame.addMouseListener(this);
		frame.addMouseListener(this);
		
		
		frame.getContentPane().add(BorderLayout.WEST, button); // Добавить кнопку
		frame.getContentPane().add(BorderLayout.EAST, button02);
		
		
		
	
	}
	
	
	
	
	
	// Обработчик Событий
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	public void	mouseClicked(MouseEvent e){
		//button.setText("ЛОЛ");
		//button02.setText("ЛОЛ");
		frame.getContentPane().add(ppp);
	}		
	// Обработчик Событий
	public void actionPerformed(ActionEvent event){
		
		
		String s = button.getText();
		if(s == "Зопка")
			button.setText("Носёлёзек");
		if(s == "Носёлёзек")
			button.setText("Зопка");
	}
		
		
	
}

class MyDrawPanel01 extends JPanel{
	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(20,50,100,100);
		
	}
	
}
