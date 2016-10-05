import java.awt.event.*;
import java.io.IOException;
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
		int x = e.getX() - (Frame.size.width - Screen.myWidth) + 5;
		int y = e.getY() - (Frame.size.height - Screen.myHeight) + 5;
		
		try {
			Client.sendMouseCoords("Dragged", x, y);
		} catch (IOException e1) {
			System.exit(1);
		}
		
		Mouse.mouse = new Point(x, y);
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX() - (Frame.size.width - Screen.myWidth) + 5;
		int y = e.getY() - (Frame.size.height - Screen.myHeight) + 5;
		try {
			Client.sendMouseCoords("Moved", x, y);
		} catch (IOException e1) {
			System.exit(1);
		}
		Mouse.mouse = new Point(x, y);
	}
}
