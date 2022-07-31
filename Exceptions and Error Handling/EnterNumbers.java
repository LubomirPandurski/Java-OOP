package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    static int currentNumber = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int end = 100;

        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 10){
            numbers.add(readNumber(scanner,  end));
        }
        for (int i = 0; i < 9; i++) {
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.println(numbers.get(9));
    }

    private static int readNumber(Scanner scanner,  int end) {

        while(true) {
            String input = scanner.nextLine();
            try {
                int numberEntered = Integer.parseInt(input);
                if (numberEntered > currentNumber && numberEntered < end) {
                    currentNumber = numberEntered;
                    return numberEntered;
                } else {
                    throw new IndexOutOfBoundsException("Your number is not in range " + currentNumber + " - 100!");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid Number!");
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Your number is not in range " + currentNumber + " - 100!");
            }
        }
    }
}
