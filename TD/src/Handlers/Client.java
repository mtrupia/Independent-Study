package Handlers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import Classes.Player;

public class Client {
	private static BufferedReader in;
	private static PrintWriter out;
	private static String serverAddress = "127.0.0.1";
	private static int port = 8081;
	private static String line = "";
	
	public static Player getGame(int id) throws UnknownHostException, IOException {
		Player p;
		Gson gson = new Gson();
		
		Socket s = new Socket(serverAddress, port);
    	in = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
        
        out.println(id+":game");
        String json = "";

		while ((line=in.readLine()) != null) {
        	json += line;
        }
		
        p = (Player) gson.fromJson(json, Player.class);
		
        s.close();
        
		return p;
	}
	
	public static void buyTower(int id, int y, int x, int pID) throws UnknownHostException, IOException {
		String mes = "buytower:"+id+":"+y+":"+x+":";
		sendMessage(mes, pID);
	}
	
	public static void buyEnemy(int id, int pID) throws UnknownHostException, IOException {
		String mes = "buyenemy:"+id+":";
		sendMessage(mes, pID);
	}
	
	public static void sellTower(int y, int x, int pID) throws UnknownHostException, IOException {
		String mes = "selltower:"+y+":"+x+":";
		sendMessage(mes, pID);
	}
	
	public static void sendMessage(String txt, int id) throws UnknownHostException, IOException {
		Socket s = new Socket(serverAddress, 8081);
		out = new PrintWriter(s.getOutputStream(), true);
		
		out.println(id+":"+txt);
		
		s.close();
	}
}
