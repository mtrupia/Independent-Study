package classes;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
@SuppressWarnings("serial")

public class Block extends Rectangle{
	public int id;
	
	public Block(int x, int y, int width, int height, int id) {
		setBounds(x, y, width, height);
		this.id = id;
	}
	
	public void drawImg(Graphics g) {
		g.drawImage(Values.img(id), x, y, width, height, null);
	}
	
	public void drawRect(Graphics g) {
		g.drawRect(x, y, width, height);
	}
	
	public void drawImg(Graphics g, Image img) {
		g.drawImage(img, x, y, width, height, null);
	}
}
