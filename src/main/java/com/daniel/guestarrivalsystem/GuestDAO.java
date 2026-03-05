/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.guestarrivalsystem;

/**
 *
 * @author steve
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {
    
    public Guest saveOrGetGuest(Guest guest) {

    String checkSql = "SELECT guest_id FROM guests WHERE email = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

        checkStmt.setString(1, guest.getEmail());
        ResultSet rs = checkStmt.executeQuery();

        // If guest already exists
        if (rs.next()) {
            int existingId = rs.getInt("guest_id");
            guest.setGuestId(existingId);
            System.out.println("Guest already exists with ID: " + existingId);
            return guest;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    // If not exists → insert
    String insertSql = "INSERT INTO guests (first_name, last_name, email) VALUES (?, ?, ?) RETURNING guest_id";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

        insertStmt.setString(1, guest.getFirstName());
        insertStmt.setString(2, guest.getLastName());
        insertStmt.setString(3, guest.getEmail());

        ResultSet rs = insertStmt.executeQuery();

        if (rs.next()) {
            int generatedId = rs.getInt("guest_id");
            guest.setGuestId(generatedId);
            System.out.println("Guest inserted with ID: " + generatedId);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return guest;
}
    
    
}
