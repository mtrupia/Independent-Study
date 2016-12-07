package fields;
import java.awt.Font;
import java.awt.Graphics;

import classes.Block;
import windows.GameWindow;

public class EnemyField {
	public static int offset = 5, 
			borderWidth = 250, borderHeight = GameWindow.height-offset*2,
			enemyX = 2, enemyY = 3;
	
	public Font font = new Font("Courier New", Font.BOLD, 40);
	public String buyText = "Spend All";
	public static Block border, topLine, botLine;
	public static Block enemy[];
	public int enemySize = 78, enemyId = 40;
	
	
	public EnemyField() {
		border = new Block(offset, offset, borderWidth, borderHeight, 0);
		topLine = new Block(border.x, 100, borderWidth, 1, 0);
		
		//enemies
		enemy = new Block[enemyX*enemyY];
		int i = 0;
		for (int y = 0; y < enemyY; y++) {
			for (int x = 0; x < enemyX; x++) {
				enemy[i] = new Block(topLine.x+offset*6 + x*(enemySize+offset*6), topLine.y+offset*18 + y*(enemySize+offset*6), enemySize, enemySize, enemyId+i);
				i++;
			}
		}
		
		botLine = new Block(border.x, 599, borderWidth, 1, 0);
	}
	
	public void draw(Graphics g) {
		g.setFont(font);
		
		border.drawRect(g);
		g.drawString("" + GameWindow.player.getScore(), border.x+offset, border.y+55);
		topLine.drawRect(g);
		
		// Enemies
		for (int i = 0; i < enemy.length; i++) {
			enemy[i].drawImg(g);
		}
		
		botLine.drawRect(g);
		
		// Spend all gold
		g.drawString(buyText, border.x+offset*3, border.height-30);
	}
}
