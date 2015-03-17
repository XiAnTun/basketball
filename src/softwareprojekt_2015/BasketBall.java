package softwareprojekt_2015;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BasketBall {

	private int width = 200;
	private int height = 200;
	private int y = height/2;
	private int x = width/2;
	private int v=0;
	private int v2= 0; //geschwingikeit in x richtung
	private int r=10;
	private int r2= 5;
	
	public static void main(String[] args) {
		
		final BasketBall b = new BasketBall();
		final BasketBall b2 = new BasketBall();
		JPanel panel = new JPanel() {
			
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.DARK_GRAY);
				g.fillOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
				g.fillOval(b2.x-b2.r2+100, b2.y-b2.r2+100, 2*b2.r2, 2*b2.r2);
			}
			
		};
		JPanel p1 = new JPanel();
		JFrame frame = new JFrame();
		p1.setSize(350,350);
		frame.add(p1);
		frame.add(panel);
		panel.setSize(b.width, b.height);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1.setBackground(Color.pink);
		frame.setBackground(Color.yellow);
		
		
		while (true) {
			b.simulate();
			b2.simulate2();
			panel.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void simulate() {
		
		y = y - v;
		v = v - 2;
		if (y >= 350 - r) {
			v = -v;	}
		
		if(y <= r) {
			v = 0;
		}
	}
	
	//ball der zur seite "faellt"
public void simulate2() {
	
		x = x + v2;
		v2 = 200*(v2 - 1);
		
		if (x >= 350-r2) {
			v2 = -v2;
		}
		
		if(x < width-r2) {
			v2 = 0;
		}
		
	}
}