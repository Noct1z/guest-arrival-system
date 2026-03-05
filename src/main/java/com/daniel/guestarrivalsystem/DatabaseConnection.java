/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daniel.guestarrivalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author steve
 */
public class DatabaseConnection {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/guest_arrival_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Programming0905!";
    
    public static Connection getConnection()throws SQLException {
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
