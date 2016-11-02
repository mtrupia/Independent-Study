import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Random;

import javax.swing.JPanel;
@SuppressWarnings("serial")

public class MainWindow extends JPanel implements Runnable {
	public static Player player;
	
	public static int width, height;
	public boolean first = true;
	
	public EnemyField Efield;
	public GameField Gfield;
	public SpecialsField  Sfield;
	public TowersField Tfield;
	
	public static Font font = new Font("Courier New", Font.BOLD, 15);
	public static String MouseText = "";
	public static Color bkground = Color.black;
	public static Color fwground = Color.white;
	
	public Thread thread = new Thread(this);
	
	public static int ID = 0;
	
	public MainWindow() {
		while((ID = new Random().nextInt()) == 0);
		
		player = getPlayer();
		
		thread.start();
	}
	
	public void setPlayerValues() {
		player = getPlayer();
		
		if (player.getEnemies() != null) {
			GameField.Enemies.clear();
			for (int i = 0; i < player.getEnemies().size(); i++) {
				Enemy e = player.getEnemies().get(i); 
				GameField.Enemies.add(new Block(GameField.game[0][GameField.gameX/2].x + e.getX(), GameField.game[0][GameField.gameX/2].y + e.getY(), GameField.size, GameField.size, e.getId()));
				Block x = GameField.Enemies.get(i);
				Block y = GameField.game[GameField.gameY-1][GameField.gameX/2];
				if (x.contains(y)) {
					System.out.printf("X = %d, Y = %d\n", e.getX(), e.getY());
				}
			}
		}
		
		for(int y = 0; y < GameField.gameY; y++) {
			for(int x = 0; x < GameField.gameX; x++) {
				int id = player.getField().get(y).get(x).getBuilding().getId();
				GameField.game[y][x].id = id;
			}
		}
		GameField.game[0][GameField.gameX/2].id = 1;
		GameField.game[GameField.gameY-1][GameField.gameX/2].id = 1;
	}
	
	public Player getPlayer() {
		Player p = new Player();
		
		try {
			p = Client.getGame(ID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
	public void paintComponent(Graphics g) {
		if (first) {
			width = getWidth();
			height = getHeight();
			
			Efield = new EnemyField();
			Gfield = new GameField();
			Sfield = new SpecialsField();
			Tfield = new TowersField();
			
			first = false;
		}
		g.clearRect(0, 0, width, height);
		
		Efield.draw(g);
		Gfield.draw(g);
		Sfield.draw(g);
		Tfield.draw(g);
		
		setPlayerValues();
		
		drawMouseText(g);
	}
	
	public void drawMouseText(Graphics g) {
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rect = fm.getStringBounds(MouseText, g);
		Point m = Handler.mouse;
		int y = m.y - fm.getAscent();
		
		if(m.x > width/2) {
			g.setColor(bkground);
			g.fillRect(m.x - (int) rect.getWidth(), y - 2, (int) rect.getWidth(), (int) rect.getHeight());
			
			g.setColor(fwground);
			g.drawString(MouseText, m.x - (int) rect.getWidth(), m.y - 2);
		} else {
			g.setColor(bkground);
			g.fillRect(m.x, y, (int) rect.getWidth(), (int) rect.getHeight());
			
			g.setColor(fwground);
			g.drawString(MouseText, m.x, m.y);
		}
	}
	
	@Override
	public void run() {
		while(true) {
			
			repaint();
		}
	}
}
