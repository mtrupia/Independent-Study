import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Trivial client for the date server.
 */
public class Client {
	private static BufferedReader in;
	private static PrintWriter out;
    public static void main(String[] args) throws IOException, InterruptedException {
    	Scanner kb = new Scanner(System.in);
        String serverAddress = "127.0.0.1";
        Socket s = new Socket(serverAddress, 8081);
        
        while(true) {
        	if (s.isClosed()) {
        		s = new Socket(serverAddress, 8081);
        	}
        	in = new BufferedReader(new InputStreamReader(
                    s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
            
        	System.out.print("Type something: ");
        	String response = kb.nextLine();
        	out.println(response);
        	
        	String line = "";
        	System.out.print("Server says: ");
        	while ((line=in.readLine()) != null) {
        		System.out.print(line);
        	}
        	
        	System.out.println("\n");
        	s.close();
        }
    }
}