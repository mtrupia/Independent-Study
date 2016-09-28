import java.awt.*;
import java.awt.geom.Rectangle2D;

/*
 * Mouse control class in-game
 */
public class Mouse {
	// mouse point
	public static Point mouse = new Point(0,0);
	public static String MouseText = "";
	public static Font font = new Font("Courier New", Font.BOLD, 15);
	public static Color bkground = Color.black;
	public static Color fwground = Color.white;
	
	public static void drawText(Graphics g) {
		// draw hover text
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rect = fm.getStringBounds(MouseText, g);
		int y = mouse.y - fm.getAscent();
		
		if (mouse.x > Screen.myWidth/2) {
			g.setColor(bkground);
			g.fillRect(mouse.x - (int) rect.getWidth(), y - 2, (int) rect.getWidth(), (int) rect.getHeight());
			
			g.setColor(fwground);
			g.drawString(MouseText, mouse.x - (int) rect.getWidth(), mouse.y - 2);
		} else {
			g.setColor(bkground);
			g.fillRect(mouse.x, y, (int) rect.getWidth(), (int) rect.getHeight());
			
			g.setColor(fwground);
			g.drawString(MouseText, mouse.x, mouse.y);
		}
	}
}
