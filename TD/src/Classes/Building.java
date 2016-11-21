package Classes;
import java.util.HashMap;
import java.util.Map;

public class Building {

    private Integer id;
    private Integer health;
    private Integer damage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getHealth() {
        return health;
    }
    
    public void setHealth(Integer health) {
        this.health = health;
    }
    
    public Integer getDamage() {
        return damage;
    }
    
    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
