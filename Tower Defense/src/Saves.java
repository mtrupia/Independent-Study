import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Saves {
	public static Block[][] loadWorld(File loadPath) {
		Block blocks[][] = new Block[Field.worldHeight][Field.worldWidth];
		
		try {
			Scanner loadScanner = new Scanner(loadPath);
			
			while(loadScanner.hasNext()) {
				for (int y=0; y<blocks.length; y++) {
					for (int x=0; x<blocks[0].length; x++) {
						int i = 0;
						try {
							i = loadScanner.nextInt();
						} catch (NoSuchElementException e) { }
						blocks[y][x] = new Block((x * Field.blockSize)+ Field.offset, (y * Field.blockSize)+Field.offset, Field.blockSize, Field.blockSize, i);
					}
				}
			}
			
			loadScanner.close();
		} catch (FileNotFoundException e) { }
		
		return blocks;
	}
}
