import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

public class Client {
	private static BufferedReader in;
	private static PrintWriter out;
	private static String serverAddress = "127.0.0.1";
	private static String line = "";
	
	public static Player getGame() throws UnknownHostException, IOException {
		Player p;
		Gson gson = new Gson();
		
		Socket s = new Socket(serverAddress, 8081);
    	in = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
        
        out.println("json");
        String json = "";

		while ((line=in.readLine()) != null) {
        	json += line;
        }
		
        p = (Player) gson.fromJson(json, Player.class);
		
        s.close();
        
		return p;
	}
	
	public static void sendMessage(String txt) throws UnknownHostException, IOException {
		Socket s = new Socket(serverAddress, 8081);
		out = new PrintWriter(s.getOutputStream(), true);
		
		out.println(txt);
		
		s.close();
	}
	
	public static void sendMessage(String txt[]) throws UnknownHostException, IOException {
		Socket s = new Socket(serverAddress, 8081);
		out = new PrintWriter(s.getOutputStream(), true);
		
		for (int i = 0; i < txt.length; i++) {
			out.println(txt[i]);
		}
		
		s.close();
	}
}
