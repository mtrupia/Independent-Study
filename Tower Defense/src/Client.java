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
	public static String line = "";
	private static Scanner kb;
    public static void main(String[] args) throws IOException, InterruptedException {
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
		
    	out.println("LoadSave");
    	out.println("Test");
    	
    	for (int y=0; y<blocks.length; y++) {
			for (int x=0; x<blocks[0].length; x++) {
				blocks[y][x] = new Block((x * Field.blockSize)+ Field.offset, (y * Field.blockSize)+Field.offset, Field.blockSize, Field.blockSize, in.read());
			}
    	}
    	
    	return blocks;
    }
}