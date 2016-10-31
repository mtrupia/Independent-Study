import java.awt.Graphics;

public class SpecialsField {
	public static int borderY = GameField.borderHeight+10, 
			borderX = GameField.borderX,
			borderWidth = GameField.borderWidth,
			borderHeight = 85;
			
	public static Block border;
	
	
	public SpecialsField() {
		border = new Block(borderX, borderY, borderWidth, borderHeight, 0);
	}
	
	public void draw(Graphics g) {
		border.drawRect(g);
	}
}
