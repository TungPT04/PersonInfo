/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author tung
 */
public class Validation {
    private static final Scanner in = new Scanner(System.in);

    public String checkInputString(String message) {

        while (true) {
            System.out.print(message);
            String result = in.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.err.println("Input cannot be empty.");
        }
    }

    public double checkInputSalary() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                if (result < 0) {
                    System.err.println("Salary must be greater than or equal to zero");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.err.println("You must input digit.");
                System.out.print("Please input salary: ");
            }
        }
    }
}
