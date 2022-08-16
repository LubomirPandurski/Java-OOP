package football.entities.player;

public class Women extends BasePlayer{

    private static final double INITIAL_KILOGRAMS = 60.00;

    private double kg;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
        this.kg = INITIAL_KILOGRAMS;
    }


    public void stimulation(){
        setStrength(getStrength() + 115);
    }
}
