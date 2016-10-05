import java.awt.*;
import java.io.File;
import java.io.IOException;

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
		try {
			blocks = Client.getBlocks();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.exit(1);
		}
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

	public static int getBlockSize() {
		return blockSize;
	}

	public static void setBlockSize(int blockSize) {
		Field.blockSize = blockSize;
	}

	public static int getWorldWidth() {
		return worldWidth;
	}

	public static void setWorldWidth(int worldWidth) {
		Field.worldWidth = worldWidth;
	}

	public static int getFullWidth() {
		return fullWidth;
	}

	public static void setFullWidth(int fullWidth) {
		Field.fullWidth = fullWidth;
	}

	public static int getWorldHeight() {
		return worldHeight;
	}

	public static void setWorldHeight(int worldHeight) {
		Field.worldHeight = worldHeight;
	}

	public static int getFullHeight() {
		return fullHeight;
	}

	public static void setFullHeight(int fullHeight) {
		Field.fullHeight = fullHeight;
	}

	public static int getOffset() {
		return offset;
	}

	public static void setOffset(int offset) {
		Field.offset = offset;
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

	public Block getBorder() {
		return border;
	}

	public void setBorder(Block border) {
		this.border = border;
	}
}
