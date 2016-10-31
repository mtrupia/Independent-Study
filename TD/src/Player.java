import java.util.ArrayList;
import java.util.List;

public class Player {

    private Integer score;
    private Integer lives;
    private Integer gold;
    private List<Object> specials = new ArrayList<Object>();
    private List<List<Field>> field = new ArrayList<List<Field>>();
    private List<Enemy> enemies = new ArrayList<Enemy>();
   
    public Integer getScore() {
        return score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }
    
    public Integer getLives() {
        return lives;
    }
    
    public void setLives(Integer lives) {
        this.lives = lives;
    }
    
    public Integer getGold() {
        return gold;
    }
    
    public void setGold(Integer gold) {
        this.gold = gold;
    }
    
    public List<Object> getSpecials() {
        return specials;
    }
    
    public void setSpecials(List<Object> specials) {
        this.specials = specials;
    }
    
    public List<List<Field>> getField() {
        return field;
    }
    
    public void setField(List<List<Field>> field) {
        this.field = field;
    }
    
    public List<Enemy> getEnemies() {
        return enemies;
    }
    
    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
}
