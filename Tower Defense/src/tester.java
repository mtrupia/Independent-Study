import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class tester {
	public static Field field;
	public static fieldtest fieldtest;
	public static Gson gson;
	
	 public static void main(String[] args) {
		 field = new Field();
		 System.out.println(Screen.life);
		 Screen.life = 0;
		 System.out.println(Screen.life);
		 
		 gson = new Gson();
		 gson = new GsonBuilder()
	             .disableHtmlEscaping()
	             .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
	             .setPrettyPrinting()
	             .serializeNulls()
	             .create();
		 String json = gson.toJson(field);
		 
		 System.out.println(json);
		 
		 fieldtest = gson.fromJson(json, fieldtest.getClass());
		 System.out.println(fieldtest.blocks[0][0]);
	 }
	 
	 public class fieldtest {
		// default vals
			public int blockSize = 32;
			public int worldWidth = 17;
			public int fullWidth = worldWidth * blockSize;
			public int worldHeight = 14;
			public int fullHeight = worldHeight * blockSize;
			public int offset = 5;
			
			// blocks of the field
			public Block blocks[][] = new Block[worldHeight][worldWidth];
			public Block border;
			
			// begin blocks of the field
			public fieldtest(Block blocks[][], Block border) {
				this.blocks = blocks;
				this.border = border;
				Screen.life = 20;
				Screen.coins = 100;
			}
			
			// create blocks of the field
			public void init() {
				//border = new Block(offset, offset, fullWidth-1, fullHeight-1, 0);
				//blocks = Saves.loadWorld(new File("saves/world1.txt"));
				Screen.life = 20;
				Screen.coins = 100;
			}
			
			// draw blocks of the field
			public void draw(Graphics g) {
				g.setColor(Color.black);
				border.drawRect(g);
				
				Mouse.MouseText = "";
				for (int y=0; y<blocks.length; y++) {
					for (int x=0; x<blocks[0].length; x++) {
						if (blocks[y][x].contains(Mouse.mouse)) {
							g.setColor(new Color(255, 255, 255, 1));
							g.fillRect(blocks[y][x].x, blocks[y][x].y, blocks[y][x].width, blocks[y][x].height);
							Mouse.MouseText = Values.searchId(blocks[y][x].id);
						} else {
							blocks[y][x].drawImg(g);
						}
					}
				}
			}
	 }
}
