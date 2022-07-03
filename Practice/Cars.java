package Practice;

public class Cars {
    private String brand;
    private String model;
    private int horsePower;

    public Cars(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String carInfo(){
        return String.format("Car brand: %s; Model: %s; Power: %d. ",
                brand,
                model,
                horsePower);
    }
}
