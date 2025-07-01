/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruiseship;

//Task1
import java.util.*;
import java.io.FileReader;
import java.util.Scanner;

    public class CruiseShip {
     
        static cruiseShip Cabin = new cruiseShip();
        public static void main(String[] args) {
    
Scanner input = new Scanner(System.in); 
    String cabinName;
    int cabinNum = 0;
    String[] ship = new String[13];
    //for (int x = 0; x < 13; x++ ) ship[x] = ""; //initialise
    initialise(ship); 

    while ( cabinNum < 13 ) 
    {
        for (int x = 0; x < 13; x++ ) 
        {
        if(ship[x].equals("e"))System.out.println("cabin"+x+"isempty"); 
        }
  
    System.out.println("Enter cabin number (0-12) or 13 to stop:" ); 
    cabinNum = input.nextInt();
    System.out.println("Enter name for cabin " + cabinNum +" :" ); 
    cabinName = input.next();
    ship[cabinNum] = cabinName ;

    for (int x = 0; x < 13; x++ ) 
    {
    System.out.println("cabin " + x + " occupied by " + ship[x]); }
     }
  }

       private static void initialise( String shipRef[] ) { 
        for (int x = 0; x < 13; x++ ) shipRef[x] = "e"; 
        System.out.println( "initilise ");
    }
       Scanner input = new Scanner(System.in);
       String menu;     
       
       {
       do { 
        
        System.out.println("A:Add a customer to a cabin");
        System.out.println("V:View all cabins");
        System.out.println("E:Display empty cabins");
        System.out.println("D:Delete customer from cabin");
        System.out.println("F:Find cabin from customer name");
        System.out.println("S:Store program data into file");
        System.out.println("L:Load program data into a file");
        System.out.println("O:View passengers ordered alphabetically by name");
        String input = in.next().toUpperCase();
        menu = input;
        while (!menu.matches("[AVEDFSLO]")) {
            System.out.println("Invalid errors for the Input: Choose one of the following");
            System.out.println("A:Add a customer to a cabin");
            System.out.println("V:View all cabins");
            System.out.println("E:Display empty cabins");
            System.out.println("D:Delete customer from cabin");
            System.out.println("F:Find cabin from customer name");
            System.out.println("S:Store program data into file");
            System.out.println("L:Load program data into a file");
            System.out.println("O:View passengers ordered alphabetically by name");
            menu = in.next().toUpperCase();
        }
        
        switch (menu) {
                case "A":
                	Cabin.AddCustomers();
                    break;
                case "V":
                	Cabin.ViewCabin();
                    break;
                case "E":
                	Cabin.EmptyCabins();
                    break;
                case "D":
                	Cabin.DeleteCustomer();
                    break;
                case "F":
                	Cabin.FindCabin();
                    break;
                case "S":
                    Cabin.StoreDataFile();
                    break;
                case "L":
                        Cabin.LoadDataFile();
                    break;
                case "O":
                        Cabin.ViewPassengersOrderedByName();
                        Cabin.sort();
            }
       
       }   
    }
}

