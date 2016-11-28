package handlers;
import java.awt.event.*;
import java.io.IOException;

import classes.AStar;
import classes.Block;
import classes.Values;
import fields.EnemyField;
import fields.GameField;
import fields.TowersField;
import windows.GameScreen;
import windows.GameWindow;

import java.awt.*;

public class Handler implements MouseMotionListener, MouseListener{
	public static Point mouse = new Point(0, 0);
	public static int towerId = 20, enemyId = 40;
	public static boolean stop = false, towerSelected = false;
	public static int mouseBtn;
	
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
			mouse.x = e.getX() - (GameScreen.size.width - GameWindow.width) + 5;
			mouse.y = e.getY() - (GameScreen.size.height - GameWindow.height) + 5;
			GameWindow.MouseText = "";
			int button = e.getButton();
			
			//Game
			if (button == MouseEvent.BUTTON1) {
				if (GameField.border.contains(mouse) && towerSelected) {
					for (int y = 0; y < GameField.gameY; y++) {
						for (int x = 0; x < GameField.gameX; x++) {
							Block g = GameField.game[y][x];
							if (g.contains(mouse) && g.id != 1 && g.id < 20) {
								if (AStar.test(18, 23, 0, 11, 17, 11, GameField.game, y, x, false)) {
									// add tower
									try {
										Client.buyTower(towerId, y, x, GameWindow.ID);
										mouseBtn = button;
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
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
							try {
								Client.buyEnemy(1, GameWindow.ID);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
				//towers
				if (TowersField.border.contains(mouse)) {
					for (int i = 0; i < TowersField.towersX*TowersField.towersY; i++) {
						if (TowersField.tower[i].contains(mouse)) {
							towerSelected = true;
							towerId = TowersField.tower[i].id;
						}
					}
				}
			} else if (button == MouseEvent.BUTTON3) {
				towerSelected = false;
				mouseBtn = button;
			} else if (button == MouseEvent.BUTTON2) {
				if (GameField.border.contains(mouse)) {
					for (int y = 0; y < GameField.gameY; y++) {
						for (int x = 0; x < GameField.gameX; x++) {
							Block g = GameField.game[y][x];
							if (g.contains(mouse) && g.id != 1 && g.id > 19) {
								if (AStar.test(18, 23, 0, 11, 17, 11, GameField.game, y, x, true)) {
									// remove tower
									try {
										Client.sellTower(y, x, GameWindow.ID);
										mouseBtn = button;
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
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!stop) { 
			mouseBtn = 0;
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (!stop) { 
			mouse.x = e.getX() - (GameScreen.size.width - GameWindow.width) + 5;
			mouse.y = e.getY() - (GameScreen.size.height - GameWindow.height) + 5;
			GameWindow.MouseText = "";
			
			// mouse stuff
			if (mouseBtn == MouseEvent.BUTTON1) {
				if (GameField.border.contains(mouse) && towerSelected) {
					for (int y = 0; y < GameField.gameY; y++) {
						for (int x = 0; x < GameField.gameX; x++) {
							Block g = GameField.game[y][x];
							if (g.contains(mouse) && g.id != 1 && g.id < 20) {
								if (AStar.test(18, 23, 0, 11, 17, 11, GameField.game, y, x, false)) {
									// add tower
									try {
										Client.buyTower(towerId, y, x, GameWindow.ID);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
					}
				}
			} else if (mouseBtn == MouseEvent.BUTTON2) {
				if (GameField.border.contains(mouse)) {
					for (int y = 0; y < GameField.gameY; y++) {
						for (int x = 0; x < GameField.gameX; x++) {
							Block g = GameField.game[y][x];
							if (g.contains(mouse) && g.id != 1 && g.id > 19) {
								if (AStar.test(18, 23, 0, 11, 17, 11, GameField.game, y, x, true)) {
									// remove tower
									try {
										Client.sellTower(y, x, GameWindow.ID);
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
			
			//Game
			if (GameField.border.contains(mouse)) {
				for (int y = 0; y < GameField.gameY; y++) {
					for (int x = 0; x < GameField.gameX; x++) {
						Block g = GameField.game[y][x];
						if (g.contains(mouse) && g.id != 0 && g.id != 1) {
							GameWindow.MouseText = Values.searchId(g.id);
						}
					}
				}
			}
			
			//Enemies
			if (EnemyField.border.contains(mouse)) {
				for (int i = 0; i < EnemyField.enemyX*EnemyField.enemyY; i++) {
					if (EnemyField.enemy[i].contains(mouse)) {
						GameWindow.MouseText = Values.searchId(EnemyField.enemy[i].id);
					}
				}
			}
			//towers
			if (TowersField.border.contains(mouse)) {
				for (int i = 0; i < TowersField.towersX*TowersField.towersY; i++) {
					if (TowersField.tower[i].contains(mouse)) {
						GameWindow.MouseText = Values.searchId(TowersField.tower[i].id);
					}
				}
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
		if (!stop) { 
			mouse.x = e.getX() - (GameScreen.size.width - GameWindow.width) + 5;
			mouse.y = e.getY() - (GameScreen.size.height - GameWindow.height) + 5;
			GameWindow.MouseText = "";
			
			//Game
			if (GameField.border.contains(mouse)) {
				for (int y = 0; y < GameField.gameY; y++) {
					for (int x = 0; x < GameField.gameX; x++) {
						Block g = GameField.game[y][x];
						if (g.contains(mouse) && g.id != 0 && g.id != 1) {
							GameWindow.MouseText = Values.searchId(g.id);
						}
					}
				}
			}
			
			//Enemies
			if (EnemyField.border.contains(mouse)) {
				for (int i = 0; i < EnemyField.enemyX*EnemyField.enemyY; i++) {
					if (EnemyField.enemy[i].contains(mouse)) {
						GameWindow.MouseText = Values.searchId(EnemyField.enemy[i].id);
					}
				}
			}
			//towers
			if (TowersField.border.contains(mouse)) {
				for (int i = 0; i < TowersField.towersX*TowersField.towersY; i++) {
					if (TowersField.tower[i].contains(mouse)) {
						GameWindow.MouseText = Values.searchId(TowersField.tower[i].id);
					}
				}
			}
		}
	}
	
}
