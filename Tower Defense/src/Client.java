import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * Trivial client for the date server.
 */
public class Client {
	private static BufferedReader in;
	private static PrintWriter out;
	public static String line = "";
	private static Scanner kb;
    public static void main(String[] args) throws IOException, InterruptedException {
    	System.out.println(new Gson().toJson(new Field()));
    	kb = new Scanner(System.in);
        String serverAddress = "127.0.0.1";
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
    
    public static Block[][] getWorld() throws IOException {
    	kb = new Scanner(System.in);
        String serverAddress = "127.0.0.1";
        Socket s = new Socket(serverAddress, 8081);

    	in = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
        
    	Block blocks[][] = new Block[Field.worldHeight][Field.worldWidth];
    	
    	return blocks;
    }
}