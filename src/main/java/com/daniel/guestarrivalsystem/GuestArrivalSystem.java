/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.daniel.guestarrivalsystem;


import java.time.LocalDateTime;
/**
 *
 * @author steve
 */
public class GuestArrivalSystem {

    public static void main(String[] args) {
        
        GuestDAO guestDAO = new GuestDAO();
        ArrivalDAO arrivalDAO = new ArrivalDAO();

        // create guest
        Guest guest = new Guest("Andres", "Lopez", "andres@email.com");

        // Save or get existing guest (ensures valid ID)
        guest = guestDAO.saveOrGetGuest(guest);

        // Create arrival linked to that guest
        Arrival arrival = new Arrival(
                guest.getGuestId(),
                LocalDateTime.now(),
                "Pending"
        );

        // Insert arrival
        arrivalDAO.insertArrival(arrival);

        System.out.println("Guest ID used: " + guest.getGuestId());
        System.out.println("Arrival ID created: " + arrival.getArrivalId());
        
        arrivalDAO.printArrivalsWithGuestNames();
    }
 }
        
        

        
        
        
       

