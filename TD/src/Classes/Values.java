package Classes;
import java.awt.Image;
import java.util.ArrayList;

/*
 * Contains block id values to names and images
 */
public class Values {
	public static ArrayList<Values> vals = new ArrayList<Values>();
	public int id;
	public String string;
	public Image image;
	
	public Values(int id, String string, Image image) {
		this.id = id;
		this.string = string;
		this.image = image;
	}
	
	public static void add(Values val) {
		vals.add(val);
	}
	
	public static int searchName(String string) {
		int r = -1;
		
		for (Values val : vals) {
			if (val.string.equals(string)) {
				return val.id;
			}
		}
		
		return r;
	}
	
	public static String searchId(int id) {
		String r = "";
		
		for (Values val : vals) {
			if (val.id == id) {
				return val.string;
			}
		}
		
		return r;
	}
	
	public static Image img(Values val) {
		return val.image;
	}
	
	public static Image img(String string) {
		return vals.get(searchName(string)).image;
	}
	
	public static Image img(int id) {
		return vals.get(id).image;
	}
}
