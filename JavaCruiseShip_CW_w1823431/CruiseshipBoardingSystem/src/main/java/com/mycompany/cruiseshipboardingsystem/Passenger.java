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

// Passenger class holds first name, surname, and expenses
public class Passenger {
    private String firstName;
    private String surname;
    private double expenses;
    
    public Passenger(String firstName, String surname, double expenses) {
        this.firstName = firstName;
        this.surname = surname;
        this.expenses = expenses;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public double getExpenses() {
        return expenses;
    }
    
    @Override
    public String toString() {
        return firstName + " " + surname + " (Expenses: £" + expenses + ")";
    }
}


