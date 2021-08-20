import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestFrame04 {
	
	JFrame frame;
	JButton buttonStart;
	JLabel label01;
	JPanel panel01;
	paintTest01 pt01;
	paintTest01 oval01;
	paintTest01 oval02;
	Rectangle oval01Rect;
	Rectangle oval02Rect;
	boolean anim = false;
	
	int x = 100;
	int y = 100;
	
	public static void main(String[] args){new TestFrame04();
		}
	public TestFrame04(){
		frame = new JFrame("Окно");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oval01 = new paintTest01(Color.green);
		oval02 = new paintTest01(Color.blue);
		//pt01 = new paintTest01();
		//pt02 = new paintTest02();
		panel01 = new JPanel();
		
		buttonStart = new JButton("Старт");
		buttonStart.addActionListener(new StartListener());
		
		frame.setLayout(null);
		oval01.setBounds(100, 100, 50, 50);
		oval02.setBounds(300, 100, 70, 70);
		panel01.setBounds(500, 500, 70, 70);
		
		//frame.add(pt01);
		//frame.add(pt02);
		//frame.setContentPane(pt01);
		//frame.setContentPane(pt02);
		//frame.setLayout(null);
		panel01.add(buttonStart);
		frame.getContentPane().add(oval01);
		frame.getContentPane().add(oval02);
		frame.getContentPane().add(panel01);
		
		frame.setSize(1024, 768);
		frame.setResizable(false);
		frame.setVisible(true);
		
		oval01Rect = oval01.getBounds();
		oval02Rect = oval02.getBounds();
		
		
		if(anim == true){
			for(int i = 0; i < 130; i++){
				oval01.setBounds(oval01Rect.x++, oval01Rect.y++, 50, 50);
				oval01.repaint();
					try{
						Thread.sleep(50);
					}catch (Exception ex) {} 
			}
		}
		if(anim == true){
		for(int i = 0; i < 130; i++){
			oval02.setBounds(oval02Rect.x++, oval02Rect.y++, oval02Rect.width++, oval02Rect.height++);
			oval01.repaint();
			
			try{
				Thread.sleep(50);
			}catch (Exception ex) {} 
		}
		}
	}
	
	class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			frame.repaint();
			anim = true;
		}	
	}
	
	class paintTest01 extends JPanel{
		Color color;
		
		public paintTest01(Color color){
			this.color = color;
		}
		
		public void paint(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			g2d.setBackground(Color.black);
			g2d.setColor(color);
			g2d.fillOval(0, 0, this.getWidth(), this.getHeight());
		}

	}
}


class paintTest02 extends JPanel {
	public void paintComponent(Graphics g){
	
		
				Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}
} 