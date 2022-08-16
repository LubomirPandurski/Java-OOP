package football.entities.player;

public class Men extends BasePlayer{

    private static final double INITIAL_KILOGRAMS = 85.50;

    private double kg;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
        this.kg = INITIAL_KILOGRAMS;
    }


    public void stimulation(){
        setStrength(getStrength() + 145);
    }
}
