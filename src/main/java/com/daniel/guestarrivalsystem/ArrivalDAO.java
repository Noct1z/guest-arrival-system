/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.guestarrivalsystem;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steve
 */
public class ArrivalDAO {
    
    public void insertArrival(Arrival arrival) {

        String sql = "INSERT INTO arrivals (guest_id, scheduled_time, status) " +
                     "VALUES (?, ?, ?) RETURNING arrival_id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, arrival.getGuestId());
            pstmt.setTimestamp(2, Timestamp.valueOf(arrival.getScheduledTime()));
            pstmt.setString(3, arrival.getStatus());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int generatedId = rs.getInt("arrival_id");
                arrival.setArrivalId(generatedId);
                System.out.println("Arrival inserted with ID: " + generatedId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Arrival> getAllArrivals() {

        List<Arrival> arrivals = new ArrayList<>();

        String sql = "SELECT arrival_id, guest_id, scheduled_time, actual_time, status FROM arrivals";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                LocalDateTime actualTime = null;
                Timestamp actualTimestamp = rs.getTimestamp("actual_time");
                if (actualTimestamp != null) {
                    actualTime = actualTimestamp.toLocalDateTime();
                }

                Arrival arrival = new Arrival(
                        rs.getInt("arrival_id"),
                        rs.getInt("guest_id"),
                        rs.getTimestamp("scheduled_time").toLocalDateTime(),
                        actualTime,
                        rs.getString("status")
                );

                arrivals.add(arrival);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrivals;
    }
    
    public void printArrivalsWithGuestNames() {

    String sql = """
        SELECT g.first_name, g.last_name,
               a.scheduled_time, a.status
        FROM arrivals a
        JOIN guests g ON a.guest_id = g.guest_id
    """;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        System.out.println("Arrivals with Guest Names:");

        while (rs.next()) {
            System.out.println(
                    rs.getString("first_name") + " " +
                    rs.getString("last_name") + " | " +
                    rs.getTimestamp("scheduled_time").toLocalDateTime() + " | " +
                    rs.getString("status")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
}

    
    

