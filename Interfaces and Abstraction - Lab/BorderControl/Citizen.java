package BorderControl;

public class Citizen implements Identifiable{

    private String id;
    private int age;
    private String name;

    public Citizen(String id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}
