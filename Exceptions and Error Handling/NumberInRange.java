package com.company;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] range = scanner.nextLine().split(" ");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);
        System.out.printf("Range: [%d...%d]%n", start, end);
        int number = readNumber(scanner, start, end);
        System.out.println("Valid number: " + number);

    }

    private static int readNumber(Scanner scanner, int start, int end){
        while(true){
            String input = scanner.nextLine();
            try{
                int number = Integer.parseInt(input);
                if(number>=start && number<=end){
                    return number;
                }
            }
            catch (Exception exception){

            }
            System.out.println("Invalid number: " + input);
        }
    }
}
