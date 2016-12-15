package windows;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import classes.Values;
import handlers.Handler;
@SuppressWarnings("serial")

public class GameScreen extends JFrame{
	public static String title = "TD";
	public static Dimension size = new Dimension(1280,620);
	
	public GameScreen() {
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
	}
	
	// start game
	public void init() {
		setLayout(new GridLayout(1, 1, 0, 0));
		
		GameWindow window = new GameWindow();
		add(window);
		addValues();
		addMouseMotionListener(new Handler());
		addMouseListener(new Handler());
		
		setVisible(true);
	}
	
	// import block values
	public void addValues() {
		Image img = new ImageIcon("res/blocks.png").getImage();
		
		for (int i = 0; i < 100; i++) {
			Values.add(new Values(i, "test "+i, createImage(new FilteredImageSource(img.getSource(), new CropImageFilter(0, 26*i, 26, 26)))));
		}
		// 0 - 9: blocks
		Values.vals.get(0).string = "Grass";
		Values.vals.get(1).string = "Road";
		// 10 - 19: icons
		Values.vals.get(10).string = "LifeIcon";
		Values.vals.get(11).string = "CoinIcon";
		Values.vals.get(12).string = "EnemyLifeIcon";
		//20 - 31: towers
		Values.vals.get(20).string = "Shotty";
		Values.vals.get(21).string = "Multy";
		Values.vals.get(22).string = "Ice";
		Values.vals.get(23).string = "Fire";
		Values.vals.get(24).string = "Melee";
		Values.vals.get(25).string = "Cannon";
		// 40 - 51: enemies
		Values.vals.get(40).string = "Walker";
		Values.vals.get(41).string = "Runner";
		Values.vals.get(42).string = "Tank";
		Values.vals.get(43).string = "Flyer";
		Values.vals.get(44).string = "Breaker";
		Values.vals.get(45).string = "Boss";
	} 
}
