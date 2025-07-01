/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruiseship;


   public class PassengerQueue {
    
Scanner input = new Scanner(System.in); 
    int First = 0;
    int Last = 0;
    int Length = 0;
    static final int WAITING_LIST_CAPACITY = 5;
    static Passenger[] queueArray = new Passenger[WAITING_LIST_CAPACITY];

    public final void Initialise(Passenger[] queueArray) {
        for (int i = 0; i < queueArray.length; i++) {
            queueArray[i] = new Passenger();
            queueArray[i].SetFirstName("Empty"); 
        }

    }
    public PassengerQueue(int QUEUE_SIZE) {

        Initialise(queueArray);

    }
    public void AddPassengers() {

        if (IsFull()) {
            System.out.println("Queue is full");
        }
        else {
            String input;
            System.out.println("Enter passengers First Name");
            input = in.next().toUpperCase();
            queueArray[Last].SetFirstName(input);
            while (!input.matches("[a-zA-Z,]+")) {
                System.out.println("Invalid");
                System.out.println("Enter passengers First Name");
                input = in.next().toUpperCase();
                queueArray[Last].SetFirstName(input);
            }

            System.out.println("Enter Surname");
            input = in.next().toUpperCase();
            queueArray[Last].SetSurName(input);
            while (!input.matches("[a-zA-Z]+")) {
                System.out.println("Invalid");
                input = in.next().toUpperCase();
                queueArray[Last].SetSurName(input);
            }

            System.out.println(queueArray[Last].FirstName + "    " + queueArray[Last].Surname +"    "
            +"has been added to the queue");
            
        }

    }
    public void DeletePassengers() {
        if (empty()) {
            System.out.println("Passenger has beeen removed: " + queueArray[First].GetFirstName() + "      " 
            + queueArray[First].GetSurName());
            queueArray[First].FirstName = "Empty";
            queueArray[First].Surname = "Empty";  
        } 
        else {
            System.out.println("Empty");
        }
    }
    public void InitialiseQueue(Passenger[] passengersQueue) {

        for (int i = 0; i < passengersQueue.length; i++) {
            passengersQueue[i] = new Passenger();
            passengersQueue[i].SetFirstName("Empty");
            passengersQueue[i].SetSurName("Empty");
            passengersQueue[i].Expenses(0);
        }

    }
}
