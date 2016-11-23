package windows;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import classes.Block;

@SuppressWarnings("serial")
public class MainWindow extends JPanel implements Runnable {
	public static int width, height;
	public boolean first = true;
	public Image playImg = new ImageIcon("res/PlayButton.png").getImage();
	public Font font = new Font("Courier New", Font.BOLD, 40);
	public Thread thread = new Thread(this);
	
	public static Block play;
	
	public MainWindow() {
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		if (first) {
			width = getWidth();
			height = getHeight();
			
			play = new Block(width/2-250,height/2-250, 500, 500, 0);
		
			first = false;
		}
		g.clearRect(0, 0, width, height);
		
		play.drawImg(g, playImg);
	}
	
	@Override
	public void run() {
		while(true) {
			repaint();
		}
	}
}
