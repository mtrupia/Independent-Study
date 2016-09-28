import java.awt.*;

public class Tower {
	// PowerUp border
	public Block border;
	public Block borderImg;
	
	//Default Vals
	public static int towerWidth = 2;
	public static int towerHeight = 6;
	public static int totalTowers = towerHeight*towerWidth;
	public static int towerSize = 56;
	public static int lineOffset = 65;
	public static int towerOffset = 6;
	public static int offset = 3;
	public static int blockSize = Field.blockSize/2 + Field.blockSize/5;
	
	// Icons
	public Block lifeImg;
	public Block coinImg;
	
	// Lines
	public Block topLine;
	public Block botLine;
	
	// Towers
	public Towers towers[];
	
	
	// begin border
	public Tower() {
		init();
	}
	
	// create border and Icon
	public void init() {
		borderImg = new Block(Field.offset*2 + Field.fullWidth, Field.offset, Screen.myWidth - Field.fullWidth - Field.offset*3, Screen.myHeight - Field.offset*2, 99);
		border = new Block((Field.offset*2-1) + Field.fullWidth, Field.offset-1, Screen.myWidth - Field.fullWidth - (Field.offset*3-1), Screen.myHeight - (Field.offset*2-1), 0);
		lifeImg = new Block(border.x+offset, border.y+offset, blockSize, blockSize, 10);
		coinImg = new Block(lifeImg.x, lifeImg.y+blockSize+offset, blockSize, blockSize, 11);
		
		topLine = new Block(border.x, border.y+lineOffset, border.x + border.width, border.y+lineOffset, 0);
		botLine = new Block(border.x, border.height-lineOffset, border.x + border.width, border.height-lineOffset, 0);
		
		towers = new Towers[totalTowers];
		int i = 0;
		for (int y = 0; y < towerHeight; y++) {
			for (int x = 0; x < towerWidth; x++){
				towers[i] = new Towers(new Block((topLine.x+towerOffset+offset) + x*(towerSize+towerOffset), (topLine.y+towerOffset) + y*(towerSize+towerOffset), towerSize, towerSize, 20+i), null);
				i++;
			}
		}
	}
	
	// draw border and icons
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		border.drawRect(g);
		borderImg.drawImg(g);
		lifeImg.drawImg(g);
		g.drawString("" + Screen.life, lifeImg.x+blockSize+offset, lifeImg.y+blockSize - (blockSize/3));
		coinImg.drawImg(g);
		g.drawString("" + Screen.coins, coinImg.x+blockSize+offset, coinImg.y+blockSize - (blockSize/3));
		g.drawString("" + Screen.points, coinImg.x, coinImg.y+blockSize+(offset/2) + (blockSize/2));
		g.setColor(Color.BLACK);
		g.drawLine(topLine.x, topLine.y, topLine.width, topLine.height);
		
		for (int i = 0; i < totalTowers; i++) {
			if (towers[i].block.contains(Mouse.mouse)) {
				Mouse.MouseText = Values.searchId(towers[i].block.id);
			}
			towers[i].block.drawImg(g);
		}
		
		g.drawLine(botLine.x, botLine.y, botLine.width, botLine.height);
	}
}
