import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TestFrame01{
	public static void main(String[] args){
		JFrame frame = new JFrame("Лёха "); // Новое окно

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Нажатие на крестик
		frame.setUndecorated(false); // Убрать "Свернуть, развернуть, закрыть" ?
		
	//	frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Максимальный размер
		frame.setSize(1024, 768);	 // Размер
		frame.setResizable(false);	 // Менять размер
		
		frame.add(new Main(frame));
		
		frame.setVisible(true);	  	 // Видимость
	}
}



class Main extends JPanel implements ActionListener{
	
	Image img = new ImageIcon("2.png").getImage();
	
	Timer timer = new Timer(20, this);
	
	JFrame frame;
	
	public Main(JFrame frame) {
		this.frame = frame;
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0,frame.getWidth(), frame.getHeight(), null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	
}