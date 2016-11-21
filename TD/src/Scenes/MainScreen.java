package Scenes;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.begin;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	public Font font = new Font("Courier New", Font.BOLD, 40);
	
	public MainScreen() {
		setTitle(GameScreen.title);
		setSize(GameScreen.size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel play = new JLabel("PLAY");
		play.setFont(font);
		play.setBounds(getWidth()/2-50, getHeight()/3-50, 200, 200);
		play.addMouseListener(new MouseAdapter() {
			 @Override
             public void mouseClicked(MouseEvent e) {
                 begin.getGame();
             }
		});
		
		JLabel exit = new JLabel("Exit");
		exit.setFont(font);
		exit.setBounds(getWidth()/2, getHeight()/3, 200, 200);
		add(play);
		add(exit);
		exit.setVisible(false);
		setVisible(true);
	}
}
