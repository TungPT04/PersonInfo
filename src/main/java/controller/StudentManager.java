/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Persons;
import java.util.Scanner;
import view.Menu;
import view.Validation;

/**
 *
 * @author tung
 */

public class StudentManager extends Menu<String> {
    private ArrayList<Persons> persons;
    private Validation validation;

    public StudentManager() {
        title = "Person Info System";
        String[] options = {"Add Person", "Display Persons", "Sort Persons", "Exit"};
        super.mChon = new ArrayList<>();
        for (String option : options) {
            super.mChon.add(option);
        }
        persons = new ArrayList<>();
        validation = new Validation();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                addPerson();
                break;
            case 2:
                displayPersons();
                break;
            case 3:
                sortBySalary();
                break;
            case 4:
                System.out.println("Exiting program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private void addPerson() {
        Persons person = inputPersonInfo();
        persons.add(person);
        System.out.println("Person added successfully.");
    }

    private void displayPersons() {
        if (persons.isEmpty()) {
            System.out.println("No persons to display.");
            return;
        }
        for (Persons person : persons) {
            person.displayPersonInfo();
        }
    }

    private Persons inputPersonInfo() {
        System.out.println("Input Information of Person");
        String name = validation.checkInputString("Please input name: ");
        String address = validation.checkInputString("Please input address: ");
        double salary = validation.checkInputSalary();
        return new Persons(name, address, salary);
    }

    private void sortBySalary() {
        persons.sort((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
        System.out.println("Sort success.");
    }
}