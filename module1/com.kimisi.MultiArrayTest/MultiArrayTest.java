
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiArrayTest{
	JFrame frame;
	paint p;
	
	JButton buttonStop;
	JLabel label; 
	
	int speed = 100;
	int x = 10;
	int y = 10;
	
	boolean startAnim = true;
	
	public static void main(String[] args){new MultiArrayTest();}
	public MultiArrayTest(){
		System.out.printf("Start program...");
		frame = new JFrame("Multidimensional Array");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.printf("Created buttons...");
		
		JButton buttonSpeedUp = new JButton("-");
		buttonSpeedUp.addActionListener(new buttonSpeedUpListener());
		
		JButton buttonSpeedDown = new JButton("+");
		buttonSpeedDown.addActionListener(new buttonSpeedDownListener());
		
		buttonStop = new JButton("STOP");
		buttonStop.addActionListener(new buttonStopListener());
		
		System.out.printf("Created panel...");
		JPanel panel = new JPanel();
		
		System.out.printf("Created paint...");
		p = new paint();
		
		label = new JLabel("Speed: " + speed);
		
		panel.add(label);
		panel.add(buttonSpeedUp);
		panel.add(buttonSpeedDown);
		panel.add(buttonStop);
		
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, p);

		//frame.setSize(1024, 768);
		frame.setVisible(true);		
		
	//	int[] array1D = {1,2,3,4,5}; // int[] array = new array[5];
		 // int[][] array = new array[2][5];
		
		
 	}
	
	class buttonSpeedUpListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			speed+=10;
			System.out.printf("Speed: %d%n", speed);
			label.setText("Speed: " + speed);
			frame.repaint();
		}
	}
	class buttonSpeedDownListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			speed-=10;
			System.out.printf("Speed: %d%n", speed);
			label.setText("Speed: " + speed);
			frame.repaint();
		}
	}
	
	class buttonStopListener implements ActionListener{
		boolean buttonCondition = false;
		
		public void actionPerformed(ActionEvent event){
			if(!buttonCondition){
				startAnim = false; buttonCondition = true;
				buttonStop.setText("START");
				System.out.printf("Stop animation...");
			}else{
				startAnim = true; buttonCondition = false;
				buttonStop.setText("STOP");
				frame.repaint();
				System.out.printf("Start animation...");
			}
			
		}
	}
	
	
	class paint extends JPanel {
		
		public Color randomColor(){
			int r = (int)((Math.random()*250));
			int gr=	(int)((Math.random()*250));
			int b =	(int)((Math.random()*250)); 
			return new Color(r, gr, b);
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);		// Вы всегда должны вызывать super.paintComponent() . Он отвечает за очистку фона панели до того, как вы сделаете свою собственную картину.
			System.out.println("paint");
			y = 0;
			 for(int row = 0; row < 100; row++){
				x=10;
				y+=10;
				for(int col = 0; col < 190; col++){
					g.setColor(randomColor());
					g.fillRect(x,y,10,10);
					g.setColor(Color.black);
					g.drawRect(x,y,10,10);
					x+=10;
				}
			} 
			if(startAnim){
				repaint();
			}
			try{
				Thread.sleep(speed);
			}catch (Exception ex){}
			
		}
	}
}