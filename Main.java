package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Cars> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String brand = data[0];
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);
            Cars car = new Cars(brand, model, horsePower);
            cars.add(car);
        }
        for(Cars printCar:cars){
            System.out.println(printCar.carInfo());
        }
    }
}
