/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class konekkan {

    private static Connection MySQLConfig;
    public static Connection configDB() throws SQLException{
        try {
            String url="jdbc:mysql://localhost:3306/SistemPenggajian"; //url database
            String user="root"; //user database
            String pass=""; //password database
           
            MySQLConfig=DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException e) {
            System.err.println("koneksi gagal "+e.getMessage()); 
        }
        
        return MySQLConfig;
    }
}