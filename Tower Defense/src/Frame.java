import javax.swing.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

/*
 * Frame: Starts the games frame and imports data
 */
public class Frame extends JFrame {
	// default vals
	public static String title = "TD  Version: 0.1";
	public static Dimension size = new Dimension(700, 550);
	
	// import parameters
	public Frame() {
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
		
		addValues();
		addMouseMotionListener(new Handler());
		addMouseListener(new Handler());
		Screen screen = new Screen();
		add(screen);
		
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
		//20 - 31: towers
		Values.vals.get(20).string = "Shotty";
		Values.vals.get(21).string = "Multy";
		Values.vals.get(22).string = "Ice";
		Values.vals.get(23).string = "Fire";
		Values.vals.get(24).string = "Air";
		Values.vals.get(25).string = "Earth";
		Values.vals.get(26).string = "Wall";
		Values.vals.get(27).string = "Melee";
		Values.vals.get(28).string = "Cannon";
		Values.vals.get(29).string = "Bombs";
		Values.vals.get(30).string = "Spikes";
		Values.vals.get(31).string = "Paver";
	}
	
	// start frame
	public static void main (String args[]) {
		Frame frame = new Frame();
	}
}
