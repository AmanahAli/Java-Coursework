/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cruiseshipboardingsystem;

import java.util.Scanner;

/**
 *
 * @author Amanah
 */
public class CruiseshipBoardingSystem {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        CruiseShip cabin = new CruiseShip(); 
        
        String option;
        
        while (true) {
            //Displaying Menu
            System.out.println("\n----- Cruise Ship Menu -----");
            System.out.println("A: Add customer to cabin");
            System.out.println("V: View all cabins");
            System.out.println("E: Display empty cabins");
            System.out.println("D: Delete customer from cabin");
            System.out.println("F: Find cabin from customer name");
            System.out.println("S: Store program data into file");
            System.out.println("L: Load program data from file");
            System.out.println("O: View passengers ordered alphabetically by name");
            System.out.println("T: View total expenses");
            System.out.println("Q: Quit");

            System.out.print("Enter option: ");
            option = input.next().toUpperCase();
            
            switch (option) {
                case "A":
                    cabin.addCustomer();
                    break;
                case "V":
                    cabin.viewCabins();
                    break;
                case "E":
                    cabin.displayEmptyCabins();
                    break;
                case "D":
                    cabin.deleteCustomer();
                    break;
                case "F":
                    cabin.findCabin();
                    break;
                case "S":
                    cabin.storeDataToFile();
                    break;
                case "L":
                    cabin.loadDataFromFile();
                    break;
                case "O":
                    cabin.viewPassengersOrderedAlphabetically();
                    break;
                case "T":
                    cabin.printExpenses();
                    break;
                case "Q":
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid input. Please enter a valid option. ");
            }
        }
    }
}
