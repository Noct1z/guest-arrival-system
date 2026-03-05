/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.guestarrivalsystem;

/**
 *
 * @author steve
 */
public class Guest {
    
    private int guestId;
    private String firstName;
    private String lastName;
    private String email;
    
    // Constructor without ID (for new guest before insert)
    public Guest(String firstName, String lastName, String email){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    // Constructor with ID (for reading from database)
    public Guest(int guestId, String firstName, String lastName, String email){
        
        this.guestId = guestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    //Getters
    public int getGuestId(){
        return guestId;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    
    // Setter for ID (after insert)
    public void setGuestId(int guestId){
        this.guestId = guestId;
    }
    
}
