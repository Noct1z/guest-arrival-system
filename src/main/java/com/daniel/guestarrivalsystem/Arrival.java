/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.guestarrivalsystem;
import java.time.LocalDateTime;
/**
 *
 * @author steve
 */
public class Arrival {
    
    private int arrivalId;
    private int guestId;
    private LocalDateTime scheduledTime;
    private LocalDateTime actualTime;
    private String status;

    // Constructor without ID (for new arrival)
    public Arrival(int guestId, LocalDateTime scheduledTime, String status) {
        this.guestId = guestId;
        this.scheduledTime = scheduledTime;
        this.status = status;
    }

    // Constructor with ID (for reading from DB)
    public Arrival(int arrivalId, int guestId, LocalDateTime scheduledTime,
                   LocalDateTime actualTime, String status) {
        this.arrivalId = arrivalId;
        this.guestId = guestId;
        this.scheduledTime = scheduledTime;
        this.actualTime = actualTime;
        this.status = status;
    }

    // Getters
    public int getArrivalId() { return arrivalId; }
    public int getGuestId() { return guestId; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public LocalDateTime getActualTime() { return actualTime; }
    public String getStatus() { return status; }

    public void setArrivalId(int arrivalId) {
        this.arrivalId = arrivalId;
    }
    
    
}
