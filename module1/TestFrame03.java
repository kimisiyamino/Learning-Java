import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TestFrame03 implements MouseListener{
		
		static int cmdCount = 0;
		
		JFrame frame;
		JPanel panelA;
		JPanel panelB;
	    //JLabel label;
		
		DrawTestPanel paintTest;
		
		
		public static void main(String[] args){
			TestFrame03 F = new TestFrame03();
			F.start();
			System.out.printf("%04d Выход...%n", ++cmdCount);
		} 
		
		public void start(){
				System.out.printf("%04d Создание фрейма...%n", ++cmdCount);
			frame = new JFrame("App");
			panelA = new JPanel();
			panelB = new JPanel();
				System.out.printf("%04d Настройка фрейма...%n", ++cmdCount);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setUndecorated(false);
			
				System.out.printf("%04d Создание кнопок...%n", ++cmdCount);
			JButton colorButton01 = new JButton("ЦВЕТ 1");
			colorButton01.addActionListener(new colorButtonListener01());
			JButton colorButton02 = new JButton("ЦВЕТ 2");
			colorButton02.addActionListener(new colorButtonListener02());
					
					
					
					
				System.out.printf("%04d Создание панели рисования...%n", ++cmdCount);
			paintTest = new DrawTestPanel();
		
			
			
				System.out.printf("%04d Размещение кнопок...%n", ++cmdCount);
			panelA.add(colorButton01);
			panelA.add(colorButton02);
			frame.getContentPane().add(BorderLayout.SOUTH, panelA);

			//frame.getContentPane().add(paintTest);
			frame.add(paintTest);
			
			paintTest.addMouseListener(this);
			
			
			frame.setResizable(false);
			frame.setSize(1024, 768);
			frame.setVisible(true);
		}
		
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}	
		public void	mouseClicked(MouseEvent e){
			System.out.printf("%04d Клик мыши по объекту...%n", ++cmdCount);
		}		
		
	class colorButtonListener01 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			System.out.printf("%04d Кнопка 01... %n", ++cmdCount);
			frame.repaint();		
		}
	}
	class colorButtonListener02 implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			System.out.printf("%04d Кнопка 02... %n", ++cmdCount);
			//frame.repaint();		
		}
	}
	class DrawTestPanel extends JPanel{
		public void paintComponent(Graphics g){
			
			randomCOLOR randColor = new randomCOLOR();
			Graphics2D  g2d = (Graphics2D) g;
			
			System.out.printf("%04d Рисование 1 ...%n", ++TestFrame03.cmdCount);
			
			g.setColor(Color.black);
			g.fillRect(0,0, this.getWidth(), this.getHeight());
			
			g.setColor(Color.white);
			g.fillRect(20,20, 100, 140);
			g.setColor(Color.blue);
			g.fillOval(40,40, 20,20);
			g.setColor(Color.red);
			g.fillOval(60,60, 20,20);
			g.setColor(Color.orange);
			g.fillOval(80,80, 20,20);
			g.setColor(Color.green);
			g.fillOval(100,100, 20,20);
			
			GradientPaint gradient = new GradientPaint(200, 200, new Color(102, 255, 181), 340, 340, new Color(255, 102, 184));
			g2d.setPaint(gradient);
			g.fillOval(200,200, 150,150);
			
			GradientPaint gradient02 = new GradientPaint(500, 200, randColor.getStartColor(), 650, 340, randColor.getEndColor());
			g2d.setPaint(gradient02);
			g.fillOval(500,200, 150,150);		
				super.repaint();
		}		
	}

	class randomCOLOR{
		private  int r = (int)(Math.random()*255);
		private  int gC = (int)(Math.random()*255);
		private  int b = (int)(Math.random()*255);
			
		Color startColor = new Color(r,gC,b);
			
		private  int r2 = (int)(Math.random()*255);
		private  int gC2 = (int)(Math.random()*255);
		private  int b2 = (int)(Math.random()*255);
			
		Color endColor = new Color(r2,gC2,b2);
			
		public Color getStartColor(){
				return startColor;
			}
		public Color getEndColor(){
				return endColor;
			}
	}
	
}

	