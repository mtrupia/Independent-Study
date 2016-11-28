package main;

import windows.GameScreen;
import windows.MainScreen;

public class begin {
	static MainScreen ms;
	static GameScreen gs;
	
	static String game = "GAME", main = "MAIN";
	
	static String state = main;
	
	public static void main( String args[]) {
		ms = new MainScreen();
	}
	
	public static void switichStates() {
		if (state.equals(main)) {
			ms.setVisible(false);
			
			if (gs != null) {
				gs.setLocationRelativeTo(ms);
				gs.setVisible(true);
				state = game;
			}
		} else if (state.equals(game)) {
			gs.removeAll();
			gs.setVisible(false);
			gs = null;
			
			ms.setLocationRelativeTo(gs);
			ms.setVisible(true);
			
			state = main;
		}
	}
	
	public static void getGame() {
		if (gs == null) {
			gs = new GameScreen();
			
			switichStates();
		} else {
			switichStates();
		}
	}
}
