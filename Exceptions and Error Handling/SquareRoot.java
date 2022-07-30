package com.company;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try{
            int number = Integer.parseInt(input);
            double sqrt = squareRoot(number);
            System.out.printf("%.2f%n", sqrt);
        }
        catch (Exception e){
            System.out.println("Invalid");
        }
        finally {
            System.out.println("Goodbye");
        }
    }
    public static double squareRoot(double number){
        if(number < 0){
            throw new ArithmeticException("Invalid number");
        }
        return Math.sqrt((number));
    }
}
