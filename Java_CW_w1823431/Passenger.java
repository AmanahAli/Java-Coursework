/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruiseship;
        
public class Passenger {
    
    String FirstName;
    String Surname;
    int Expenses;
    
        public String GetFirstName() {
        return FirstName;
    }
     
    public void SetFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
     public String GetSurName() {
        return Surname;
    }
     
    public void SetSurName(String Surname) {
        this.Surname = Surname;
    }

    public void SetExpenses(int Expenses) {
        this.Expenses = Expenses;
    }

    public int GetExpenses() {
        return Expenses;
    }
    
    public class Cabin {
        int passenger = 3;
    }
}
 


