import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/*
 * Screen: draws the screen for the user
 */
public class Screen extends JPanel implements Runnable {
	public Thread thread = new Thread(this);
	
	// default vals
	public static int myWidth, myHeight;
	public static boolean isFirst = true;
	
	// Life, Coins, Points
	public static int life = 0;
	public static int coins = 0;
	public static int points = 0;
	
	// Areas on the screen
	public static Field field;
	public static PowerUp powerUp;
	public static Tower tower;
	
	// start the thread
	public Screen() {
		thread.start();
	}
	
	// begin areas of screen
	public void init() {
		field = new Field();
		powerUp = new PowerUp();
		tower = new Tower();
	}
	
	// draw areas of screen
	public void paintComponent(Graphics g) {
		if (isFirst){
			myWidth = getWidth();
			myHeight = getHeight();
			init();
			
			isFirst = false;
		}
		g.clearRect(0, 0, myWidth, myHeight);
		g.drawRect(0, 0, myWidth-1, myHeight-1);
		
		// draw areas
		field.draw(g);
		powerUp.draw(g);
		tower.draw(g);
		
		Mouse.drawText(g);
	}
	
	// Run game loop
	public void run() {
		while(true) {
			if (!isFirst) {
				// stuff
			}
			
			repaint();
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) { }
		}
	}
}
