import java.awt.event.*;
import java.awt.*;

public class Handler implements MouseMotionListener, MouseListener{
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent e) {
		Mouse.mouse = new Point(e.getX() - (Frame.size.width - Screen.myWidth) + 5, e.getY() - (Frame.size.height - Screen.myHeight) + 5);
	}

	public void mouseMoved(MouseEvent e) {
		Mouse.mouse = new Point(e.getX() - (Frame.size.width - Screen.myWidth) + 5, e.getY() - (Frame.size.height - Screen.myHeight) + 5);
	}
}
