import java.awt.*;
import java.io.File;

/*
 * Field: the gaming field
 */
public class Field {
	// default vals
	public static int blockSize = 32;
	public static int worldWidth = 17;
	public static int fullWidth = worldWidth * blockSize;
	public static int worldHeight = 14;
	public static int fullHeight = worldHeight * blockSize;
	public static int offset = 5;
	
	// blocks of the field
	public Block blocks[][];
	public Block border;
	
	// begin blocks of the field
	public Field() {
		init();
	}
	
	// create blocks of the field
	public void init() {
		border = new Block(offset, offset, fullWidth-1, fullHeight-1, 0);
		blocks = Saves.loadWorld(new File("saves/world1.txt"));
		Screen.life = 20;
		Screen.coins = 100;
	}
	
	// draw blocks of the field
	public void draw(Graphics g) {
		g.setColor(Color.black);
		border.drawRect(g);
		
		Mouse.MouseText = "";
		for (int y=0; y<blocks.length; y++) {
			for (int x=0; x<blocks[0].length; x++) {
				if (blocks[y][x].contains(Mouse.mouse)) {
					g.setColor(new Color(255, 255, 255, 1));
					g.fillRect(blocks[y][x].x, blocks[y][x].y, blocks[y][x].width, blocks[y][x].height);
					Mouse.MouseText = Values.searchId(blocks[y][x].id);
				} else {
					blocks[y][x].drawImg(g);
				}
			}
		}
	}
}
