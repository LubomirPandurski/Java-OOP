package BirthdayCelebrations;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        while (!"End".equals(input)){
            String [] inputParts = input.split(" ");
            String type = inputParts[0];
            switch (type){
                case "Citizen":
                    String citizenName = inputParts[1];
                    int age = Integer.parseInt(inputParts[2]);
                    String id = inputParts[3];
                    String birthDate = inputParts[4];
                    Citizen citizen = new Citizen(citizenName, age, id, birthDate);
                    citizens.add(citizen);
                    break;
                case "Pet":
                    String petName = inputParts[1];
                    String petBirthDate = inputParts[2];
                    Pet pet = new Pet(petName, petBirthDate);
                    pets.add(pet);
                    break;
                case "Robot":
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Citizen citizen : citizens) {
            if (citizen.getBirthDate().endsWith(year)) {
                System.out.println(citizen.getBirthDate());
            }
        }

        for (Pet pet : pets) {
            if (pet.getBirthDate().endsWith(year)) {
                System.out.println(pet.getBirthDate());
            }
        }
    }
}
