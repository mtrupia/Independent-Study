package fields;
import java.awt.Graphics;
import java.util.ArrayList;

import classes.Block;
import classes.Enemy;
import classes.Field;
import classes.Player;
import main.begin;
import windows.GameWindow;

public class GameField {
	public static int offset = 5, 
			borderX = EnemyField.borderWidth+offset*2,
			borderWidth = GameWindow.width-borderX*2,
			borderHeight = GameWindow.height-10;
			
	public static Block border;
	public static Block game[][];
	public static ArrayList<Block> Enemies;
	public static int size = 32, gameX = 23, gameY = 18, 
			gameWidth = gameX*size, gameHeight = gameY*size;
	
	
	public GameField() {
		Player p = GameWindow.player;
		
		Enemies = new ArrayList<Block>();
		try {
			if (p.getEnemies() != null) {
				for (int i = 0; i < p.getEnemies().size(); i++) {
					Enemy e = p.getEnemies().get(i); 
					Enemies.add(new Block(game[0][gameX/2].x + e.getX(), game[0][gameX/2].y + e.getY(), size, size, e.getId()));
				}
			}
		
			border = new Block(borderX, offset, borderWidth, borderHeight, 0);
			
			game = new Block[gameY][gameX];
			for(int y = 0; y < gameY; y++) {
				for(int x = 0; x < gameX; x++) {
					Field f = p.getField().get(y).get(x);
					game[y][x] = new Block(border.x+offset*2 + f.getX(), border.y+offset+3 + f.getY() - 5, size, size, f.getBuilding().getId());
				}
			}
			game[0][gameX/2].id = 1;
			game[gameY-1][gameX/2].id = 1;
		} catch (Exception e) {
			begin.switichStates();
		}
	}
	
	public void draw(Graphics g) {
		border.drawRect(g);
		
		for(int y = 0; y < gameY; y++) {
			for(int x = 0; x < gameX; x++) {
				game[y][x].drawImg(g);
			}
		}
		
		for (int i = 0; i < Enemies.size(); i++) {
			Enemies.get(i).drawImg(g);
		}
	}
}
