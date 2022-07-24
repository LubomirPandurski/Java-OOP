package FoodShortage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String input = scanner.nextLine();
            String[] parts = scanner.nextLine().split(" ");

            if(parts.length == 3){
                String rebelName = parts[0];
                int rebelAge = Integer.parseInt(parts[1]);
                String group = parts[2];

                Rebel rebel = new Rebel(rebelName, rebelAge, group);
                buyers.put(rebelName, rebel);
            }
            else if(parts.length == 4){
                String citizenName = parts[0];
                int citizenAge = Integer.parseInt(parts[1]);
                String citizenId = parts[2];
                String citizenBirthDate = parts[3];

                Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthDate);
                buyers.put(citizenName, citizen);
            }

        }

        String input = scanner.nextLine();
        while(!"End".equals(input)){
            Buyer buyer = buyers.get(input);

            if(buyer != null){
                buyer.buyFood();
            }

            input = scanner.nextLine();
        }

        int totalSum = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalSum);
    }
}
