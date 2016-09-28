import java.awt.*;

/*
 * PowerUp: Area for power ups
 */
public class PowerUp {
	// PowerUp border
	public Block border;
	public Block borderImg;
	
	// begin border
	public PowerUp() {
		init();
	}
	
	// create border
	public void init() {
		borderImg = new Block(Field.offset, Field.offset*2 + Field.fullHeight, Field.fullWidth, Screen.myHeight - Field.fullHeight - Field.offset*3, 99);
		border = new Block(Field.offset-1, (Field.offset*2 - 1) + Field.fullHeight, Field.fullWidth + 1, Screen.myHeight - Field.fullHeight - (Field.offset*3 - 1), 0);
	}
	
	// draw border
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		border.drawRect(g);
		borderImg.drawImg(g);
	}
}
