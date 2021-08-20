import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestFrame05_animation {
	
	int x = 70;
	int y = 70;
	JFrame frame;
	MyDrawPanel_anim paint;
	boolean on;
	
	public static void main(String[] args){new TestFrame05_animation();}
	public TestFrame05_animation(){
		
		frame = new JFrame("game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton buttonUp = new JButton("Вверх");
		JButton buttonDown = new JButton("Вниз");
		JButton buttonLeft = new JButton("Влево");
		JButton buttonRight = new JButton("Вправо");
		
		paint = new MyDrawPanel_anim();
		
		//buttonRight.addActionListener(new MyDrawPanel_anim());
		buttonRight.addActionListener(new buttonRightListener());
		
		//buttonUp.addActionListener(new MyDrawPanel_anim());
		buttonUp.addActionListener(new buttonUpListener());
		
	//	buttonDown.addActionListener(new MyDrawPanel_anim());
		buttonDown.addActionListener(new buttonDownListener());
		
	//	buttonLeft.addActionListener(new MyDrawPanel_anim());
		buttonLeft.addActionListener(new buttonLeftListener());
		
		
		frame.getContentPane().add(paint);
		
		frame.getContentPane().add(BorderLayout.NORTH, buttonUp);
		frame.getContentPane().add(BorderLayout.SOUTH, buttonDown);
		frame.getContentPane().add(BorderLayout.WEST, buttonLeft);
		frame.getContentPane().add(BorderLayout.EAST, buttonRight);
		frame.setSize(1024, 768);
		frame.setResizable(false);
		frame.setVisible(true);
		
		System.out.printf("message");
	}	
	
	class buttonRightListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.printf("Ход ВПРАВО%n");
			for(int i = 0; i < 10; i++){
				x++;
				paint.repaint();
			}
		}
	}
	
	class buttonUpListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.printf("Ход ВВЕРХ%n");
			for(int i = 0; i < 10; i++){
				y--;
				paint.repaint();
			}
		}
	}
	
	class buttonDownListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.printf("Ход ВНИЗ%n");
			for(int i = 0; i < 10; i++){
				y++;
				paint.repaint();
			}
		}
	}
	
	class buttonLeftListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.printf("Ход ВЛЕАВО%n");
			for(int i = 0; i < 10; i++){
				x--;
				paint.repaint();
			}
		}
	}
	class MyDrawPanel_anim extends JPanel implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			on = true;
			frame.repaint();
		}
		public void paintComponent(Graphics g){
		//	if(on){
				g.setColor(Color.white);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
				g.setColor(Color.green);
				g.fillOval(x, y, 40, 40);
			//}
		}	
	}
}

