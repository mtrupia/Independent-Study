import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class Handler implements MouseMotionListener, MouseListener{
	public static Point mouse = new Point(0, 0);
	public int id = 20;
	public boolean stop = false, towerSelected = false;
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!stop) { 
			
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		stop = false;
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		stop = true;
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!stop) { 
			mouse.x = e.getX() - (Screen.size.width - MainWindow.width) + 5;
			mouse.y = e.getY() - (Screen.size.height - MainWindow.height) + 5;
			MainWindow.MouseText = "";
			int button = e.getButton();
			
			//Game
			if (button == MouseEvent.BUTTON1) {
				if (GameField.border.contains(mouse) && towerSelected) {
					for (int y = 0; y < GameField.gameY; y++) {
						for (int x = 0; x < GameField.gameX; x++) {
							Block g = GameField.game[y][x];
							if (g.contains(mouse) && g.id != 1) {
								// add tower
								try {
									Client.sendMessage("tower");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				}
				
				//Enemies
				if (EnemyField.border.contains(mouse)) {
					for (int i = 0; i < EnemyField.enemyX*EnemyField.enemyY; i++) {
						if (EnemyField.enemy[i].contains(mouse)) {
							// add enemy
						}
					}
				}
				//towers
				if (TowersField.border.contains(mouse)) {
					for (int i = 0; i < TowersField.towersX*TowersField.towersY; i++) {
						if (TowersField.tower[i].contains(mouse)) {
							towerSelected = true;
							id = TowersField.tower[i].id;
						}
					}
				}
			} else if (button == MouseEvent.BUTTON3) {
				towerSelected = false;
			} else if (button == MouseEvent.BUTTON2) {
				if (GameField.border.contains(mouse)) {
					for (int y = 0; y < GameField.gameY; y++) {
						for (int x = 0; x < GameField.gameX; x++) {
							Block g = GameField.game[y][x];
							if (g.contains(mouse) && g.id != 1) {
								// remove tower
								try {
									Client.sendMessage("delete");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!stop) { 
			
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (!stop) { 
			mouse.x = e.getX() - (Screen.size.width - MainWindow.width) + 5;
			mouse.y = e.getY() - (Screen.size.height - MainWindow.height) + 5;
			MainWindow.MouseText = "";
			
			//Game
			if (GameField.border.contains(mouse)) {
				for (int y = 0; y < GameField.gameY; y++) {
					for (int x = 0; x < GameField.gameX; x++) {
						Block g = GameField.game[y][x];
						if (g.contains(mouse) && g.id != 0 && g.id != 1) {
							MainWindow.MouseText = Values.searchId(g.id);
						}
					}
				}
			}
			
			//Enemies
			if (EnemyField.border.contains(mouse)) {
				for (int i = 0; i < EnemyField.enemyX*EnemyField.enemyY; i++) {
					if (EnemyField.enemy[i].contains(mouse)) {
						MainWindow.MouseText = Values.searchId(EnemyField.enemy[i].id);
					}
				}
			}
			//towers
			if (TowersField.border.contains(mouse)) {
				for (int i = 0; i < TowersField.towersX*TowersField.towersY; i++) {
					if (TowersField.tower[i].contains(mouse)) {
						MainWindow.MouseText = Values.searchId(TowersField.tower[i].id);
					}
				}
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
		if (!stop) { 
			mouse.x = e.getX() - (Screen.size.width - MainWindow.width) + 5;
			mouse.y = e.getY() - (Screen.size.height - MainWindow.height) + 5;
			MainWindow.MouseText = "";
			
			//Game
			if (GameField.border.contains(mouse)) {
				for (int y = 0; y < GameField.gameY; y++) {
					for (int x = 0; x < GameField.gameX; x++) {
						Block g = GameField.game[y][x];
						if (g.contains(mouse) && g.id != 0 && g.id != 1) {
							MainWindow.MouseText = Values.searchId(g.id);
						}
					}
				}
			}
			
			//Enemies
			if (EnemyField.border.contains(mouse)) {
				for (int i = 0; i < EnemyField.enemyX*EnemyField.enemyY; i++) {
					if (EnemyField.enemy[i].contains(mouse)) {
						MainWindow.MouseText = Values.searchId(EnemyField.enemy[i].id);
					}
				}
			}
			//towers
			if (TowersField.border.contains(mouse)) {
				for (int i = 0; i < TowersField.towersX*TowersField.towersY; i++) {
					if (TowersField.tower[i].contains(mouse)) {
						MainWindow.MouseText = Values.searchId(TowersField.tower[i].id);
					}
				}
			}
		}
	}
	
}
