import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Trivial client for the date server.
 */
public class Client {
	private static BufferedReader in;
	private static PrintWriter out;
	public static String line = "";
	private static Scanner kb;
	private static String serverAddress = "127.0.0.1";
	
    public static void main(String[] args) throws IOException, InterruptedException {
    	kb = new Scanner(System.in);
    	
        Socket s = new Socket(serverAddress, 8081);

    	in = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
        
        while(true) {
        	if (s.isClosed()) {
        		s = new Socket(serverAddress, 8081);
        		in = new BufferedReader(new InputStreamReader(
                        s.getInputStream()));
                out = new PrintWriter(s.getOutputStream(), true);
        	}
            
        	System.out.print("Type something: ");
        	String response = kb.nextLine();
        	out.println(response);
        	
        	System.out.print("Server says: ");
        	while ((line=in.readLine()) != null) {
        		System.out.print(line);
        	}
        	
        	System.out.println("\n");
        	s.close();
        }
    }
    
    public static Block[][] getBlocks() throws UnknownHostException, IOException {
    	Gson gson = new Gson();
    	Block[][] blocks = null;
    	
    	// create socket
    	Socket s = new Socket(serverAddress, 8081);
    	in = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
        
        // get block json packet from server
        out.println("json");
        String json = "";
        while ((line=in.readLine()) != null) {
        	json += line;
        }
        
        // create blocks from json
        blocks = (Block[][]) gson.fromJson(json, Block[][].class);
        
        s.close();
    	
    	return blocks;
    }
    
    public static void sendMouseCoords(String type, int x, int y) throws UnknownHostException, IOException {
    	// create socket
    	Socket s = new Socket(serverAddress, 8081);
    	in = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
        
        out.println("Mouse " + type + ":  (" + x + "," + y + ")");
    }
}