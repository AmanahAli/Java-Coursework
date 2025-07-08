/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruiseshipboardingsystem;

import java.util.*;
import java.io.*;

/**
 *
 * @author Amanah
 */

public class CruiseShip {
    private Cabin[] cabins = new Cabin[13];  // Cabin 0 to 12
    private Scanner input = new Scanner(System.in);  // Scanner for user input
    private WaitingList waitingList = new WaitingList(10); //Capacity of 10 

    public CruiseShip() {
        for (int i = 0; i < cabins.length; i++) {
            cabins[i] = new Cabin();
        }
    }

    // View all cabins and passengers
    public void viewCabins() {
        for (int i = 0; i < cabins.length; i++) {
            System.out.println("Cabin " + i + ":");
            
            Passenger[] passengers = cabins[i].getPassengers();
            boolean isCabinEmpty = true;
            
            for (int  j = 0; j < passengers.length; j++) {
                if (passengers[j] != null) {
                    System.out.println("  " + passengers[j]);
                    isCabinEmpty = false;
                }
            }
            if (isCabinEmpty) {
                System.out.println(" Empty");
            }
        }
    }

    // Add passenger to a cabin, or to the waiting list if all cabins are full
    public void addCustomer() {
        System.out.print("Enter cabin number (0–12): ");
        int cabinNum = input.nextInt();
        input.nextLine();

        // Validate cabin number range
        if (cabinNum < 0 || cabinNum >= cabins.length) {
            System.out.println("Invalid cabin number.");
            return;
        }
        
        System.out.print("Enter passenger first name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter passenger surname: ");
        String surname = input.nextLine();
        
        System.out.print("Enter passenger expenses: £");
        double expenses = input.nextDouble();
        input.nextLine();
        
        Passenger p = new Passenger(firstName, surname, expenses);
        
        // Try to add passenger to the selected cabin
        if (cabins[cabinNum].addPassenger(p)) {
            System.out.println("Passenger added to cabin " + cabinNum);
        } else {
            // If that cabin is full, check if all cabins are full and add to waiting list
            boolean allFull = true;
            for (Cabin cabin : cabins) {
                if (!cabin.isFull()) {
                    allFull = false;
                    break;
                }
            }
        
            // If all cabins are full, add to waiting list
            if (allFull) {
                waitingList.enqueue(p); 
                System.out.println("All cabins are full. " + p.getFirstName() + " added to the waiting list.");
            } else {
                System.out.println("Cabin " + cabinNum + " is full. Please choose another cabin.");
            }
        }
    }
   
    // Display empty cabins
    public void displayEmptyCabins() {
        for (int i = 0; i < cabins.length; i++) {
            if (cabins[i].isEmpty()) {
                System.out.println("Cabin " + i + " is empty.");
            }
        }
    }

    // Deletes a passenger from a cabin and replace with next from queue if available
    public void deleteCustomer() {
        System.out.print("Enter cabin number to delete customer: ");
        int cabinNum = input.nextInt();
        input.nextLine();

         // Validate cabin number range
        if (cabinNum < 0 || cabinNum >= cabins.length) {
            System.out.println("Invalid cabin number.");
            return;
        }
        
        System.out.print("Enter passenger first name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter passenger surname: ");
        String surname = input.nextLine();
        
        Cabin cabin = cabins[cabinNum];
        
        // Try to remove passenger
        if (cabin.removePassenger(firstName, surname)) {
            System.out.println("Passenger removed from cabin " + cabinNum);
        
            // If waiting list is not empty, fill slot with next waiting passenger
            if (!waitingList.isEmpty()) {
                Passenger nextInQueue = waitingList.dequeue();
                cabin.addPassenger(nextInQueue);
                System.out.println(nextInQueue.getFirstName() + " from waiting list assigned to cabin " + cabinNum);
            }
        }
    }

    // Find cabin by passsenger name
    public void findCabin() {
        System.out.print("Enter passenger first name to search: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter passenger surname to search: ");
        String surname = input.nextLine();
        
        boolean found = false;
        
        // Search cabins for matching name
        for (int i = 0; i < cabins.length; i++) {
            Passenger p = cabins[i].findPassenger(firstName, surname);
            if (p != null) {
                System.out.println(firstName + " " + surname + " is in cabin " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Passenger not found.");
        }
    }

    // Store data to file - saves cabin passengers and expenses
    public void storeDataToFile() {
        try (PrintWriter writer = new PrintWriter("cabinData.txt")) {
            for (int i = 0; i < cabins.length; i++) {
                writer.println("Cabin " + i + ": ");
                Passenger[] passengers = cabins[i].getPassengers();
                for (Passenger p : passengers) {
                    if (p != null) {
                        writer.println(p.getFirstName() + "," + p.getSurname() + "," + p.getExpenses());
                    }
                }
            }
            System.out.println("Data stored to file.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file - clears cabin then fills from file
    public void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("cabinData.txt"))) {
            String line;
            int currentCabin = -1;
            
            //Clear existing data
            for (Cabin cabin : cabins) {
                for (int i = 0; i < cabin.getPassengers().length; i++) {
                    cabin.getPassengers()[i] = null;
                }
            }
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if(line.startsWith("Cabin")) {
                    String[] parts = line.split(" ");
                    currentCabin = Integer.parseInt(parts[1].replace(":", ""));
                } else if (!line.isEmpty() && currentCabin != -1) {
                    String[] data = line.split(",");
                    if (data.length == 3) {
                        String firstName = data[0];
                        String surname = data[1];
                        double expenses = Double.parseDouble(data[2]);
                        
                        Passenger newPassenger = new Passenger(firstName, surname, expenses);
                        cabins[currentCabin].addPassenger(newPassenger);
                    }
                }
            }
            
            System.out.println("Data loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid expense format in file.");
        }
    }
    
    // Prints expenses for all passengers and total expenses on ship
    public void printExpenses() {
        double totalExpenses = 0;
        for (int i = 0; i < cabins.length; i++) {
            for (Passenger p : cabins[i].getPassengers()) {
                if (p != null) {
                    System.out.println(p.getFirstName() + " " + p.getSurname() + ": £" + p.getExpenses());
                    totalExpenses += p.getExpenses();
                }
            }
        }
        System.out.println("Total expenses for all passengers: £" + totalExpenses);
    }

    // View all passengers ordered alphabetically by full name
    public void viewPassengersOrderedAlphabetically() {
        List<Passenger> allPassengers = new ArrayList<>();
        
        // Collect all passengers from all cabins
        for (Cabin cabin : cabins) {
            for (Passenger p : cabin.getPassengers()) {
                if (p != null) {
                    allPassengers.add(p);
                }
            }
        }

        // Sort by full name
        allPassengers.sort(Comparator.comparing((Passenger p) -> (p.getFirstName() + " " + p.getSurname()), String.CASE_INSENSITIVE_ORDER));
        
        // Print the sorted passengers
        System.out.println("Passengers in alphabetical order:");
        for (Passenger p : allPassengers) {
            System.out.println(p.getFirstName() + " " + p.getSurname());
        }
    }
}
