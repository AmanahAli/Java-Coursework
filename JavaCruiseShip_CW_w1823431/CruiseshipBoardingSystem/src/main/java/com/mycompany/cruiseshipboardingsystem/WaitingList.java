/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruiseshipboardingsystem;

/**
 *
 * @author Amanah
 */

// Circular queue for waiting list
public class WaitingList {
    private Passenger[] queue;
    private int front;
    private int back;
    private int size;
    
    public WaitingList(int capacity) {
        queue = new Passenger[capacity];
        front = 0;
        back = -1;
        size = 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Add a passenger to the back of the queue
    public void enqueue(Passenger passenger) {
        if(!isFull()) {
            back = (back + 1) % queue.length; // Wrap around if at end
            queue[back] = passenger;
            size++;
        } else {
            System.out.println("Waiting list is full.");
        }
    }
    
    //Remove and returns the passenger at the front of the queue
    public Passenger dequeue() {
        if (!isEmpty()) {
            Passenger passenger = queue[front];
            front = (front + 1) % queue.length; // Move front foward circularly
            size--;
            return passenger;
        } else {
            System.out.println("Waiting list is empty.");
            return null;
        }
    }
    
    // Prints all passengers in the waiting list
    public void printQueue() {
        System.out.println("Current waiting list:");
        for(int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.println("- " + queue[index]);
        }
        if (size == 0) {
            System.out.println("(empty)");
        }
    }
}
