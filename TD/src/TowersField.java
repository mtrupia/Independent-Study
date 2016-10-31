import java.awt.Font;
import java.awt.Graphics;

public class TowersField {
	public static int offset = 5, 
			borderWidth = 250, borderHeight = MainWindow.height-offset*2,
			borderX = MainWindow.width-offset-borderWidth,
			towersX = 2, towersY = 6;
	
	public Font font = new Font("Courier New", Font.BOLD, 40);
	public static Block border, lifeImg, coinImg, 
		topLine, botLine;
	public static Block tower[];
	public int iconSize = 40, lifeId = 10, coinId = 11,
			towerSize = 78, towersId = 20;
	
	
	public TowersField() {
		border = new Block(borderX, offset, borderWidth, borderHeight, 0);
		lifeImg = new Block(borderX+offset, border.y+offset, iconSize, iconSize, lifeId);
		coinImg = new Block(lifeImg.x, lifeImg.y+iconSize+offset, iconSize, iconSize, coinId);
		topLine = new Block(border.x, coinImg.y+iconSize+offset, borderWidth, 1, 0);
		
		//towers
		tower = new Block[towersX*towersY];
		int i = 0;
		for (int y = 0; y < towersY; y++) {
			for (int x = 0; x < towersX; x++) {
				tower[i] = new Block(topLine.x+offset*6 + x*(towerSize+offset*6), topLine.y+offset + y*(towerSize+offset), towerSize, towerSize, towersId+i);
				i++;
			}
		}
		
		botLine = new Block(border.x, SpecialsField.borderY-2, borderWidth, 1, 0);
	}
	
	public void draw(Graphics g) {
		g.setFont(font);
		
		border.drawRect(g);
		lifeImg.drawImg(g);
		g.drawString("" + MainWindow.player.getLives(), lifeImg.x+iconSize+offset, lifeImg.y+30);
		coinImg.drawImg(g);
		g.drawString("" + MainWindow.player.getGold(), coinImg.x+iconSize+offset, coinImg.y+30);
		topLine.drawRect(g);
	
		// towers
		for (int i = 0; i < tower.length; i++) {
			tower[i].drawImg(g);
		}

		botLine.drawRect(g);	
	}
}
