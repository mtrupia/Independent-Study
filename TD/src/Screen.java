import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
@SuppressWarnings("serial")

public class Screen extends JFrame{
	public static String title = "TD";
	public static Dimension size = new Dimension(1280,720);
	
	public Screen() {
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
		
		MainWindow window = new MainWindow();
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
	
	public static void main( String args[]) {
		new Screen();
	}
	
}
