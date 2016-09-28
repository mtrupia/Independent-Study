import java.util.ArrayList;

public class Towers {
	public static ArrayList<Towers> tows = new ArrayList<Towers>();
	public int towerId;
	public Block block;
	public Abilities ability;
	
	public Towers(Block block, Abilities ability) {
		this.block = block;
		this.towerId  = block.id;
		this.ability = ability;
	}
	
	public static void add(Towers tow) {
		tows.add(tow);
	}
	
	public static Abilities getAbility(Towers tow){
		return tow.ability;
	}
	
	public static Abilities getAbility(int towerId){
		Abilities r = null;
		
		r = searchId(towerId).ability;
		
		return r;
	}
	
	public static Towers searchId(int towerId) {
		Towers r = null;
		
		for (Towers tow : tows) {
			if (tow.towerId == towerId) {
				return tow;
			}
		}
		
		return r;
	}
}
