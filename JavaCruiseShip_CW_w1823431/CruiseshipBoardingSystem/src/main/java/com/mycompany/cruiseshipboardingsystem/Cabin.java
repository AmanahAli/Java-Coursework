/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruiseshipboardingsystem;

/**
 *
 * @author Amanah
 */

public class Cabin {
    private Passenger[] passengers;
    private final int MAX_PASSENGERS = 1; // 3 passengers per cabin
    
    public Cabin() {
        passengers = new Passenger[MAX_PASSENGERS];
    }
    
    // Add a passenger to this cabin if space available
    public boolean addPassenger(Passenger p) {
        for (int i = 0; i < MAX_PASSENGERS; i++) {
            if (passengers[i] == null) {
                passengers[i] = p;
                return true; // Passenger added
            }
        }
        return false; //cabin full
    }
    
    // Remove passenger by full name
    public boolean removePassenger(String firstName, String surname) {
        for (int i = 0; i < MAX_PASSENGERS; i++) {
            if (passengers[i] != null &&
                passengers[i].getFirstName().equalsIgnoreCase(firstName) &&
                passengers[i].getSurname().equalsIgnoreCase(surname)) {
                passengers[i] = null;
                return true; // Removed successfully
            }
        }
        return false; // Passenger not found
    }
    
    // Check if cabin is empty
    public boolean isEmpty() {
        for (Passenger p : passengers) {
            if (p != null)
                return false; 
        }
        return true; // Returns true if the cabin has no passengers
    }
    
    public boolean isFull() {
        for (Passenger p : passengers) {
            if (p == null)
                return false; // At least one free slot
        }
        return true; //All slots are filled
    }
    
    //Returns passengers array for viewing 
    public Passenger[] getPassengers() {
        return passengers;
    }
    
    //Find passenger by full name
    public Passenger findPassenger(String firstName, String surname) {
        for (Passenger p: passengers) {
            if (p != null &&
                p.getFirstName().equalsIgnoreCase(firstName) &&
                p.getSurname().equalsIgnoreCase(surname)) {
                return p;
            }
        }
        return null;
    }
    
    // Calculates total expense for this cabin
    public double getTotalExpense() {
        double total = 0;
        for (Passenger p: passengers) {
            if (p != null) total += p.getExpenses();
        }
        return total;
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < MAX_PASSENGERS; i++) {
            if (passengers[i] != null) {
                result += passengers[i].toString() + "\n";
            }
        }
        return result.isEmpty() ? "Empty" : result;
    }
}
