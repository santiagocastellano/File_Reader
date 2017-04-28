/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.castellano.tools.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class Connect
{

    public Connect() {
        
        try { 
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.hostinger.com.ar/u842114668_locap", "u842114668_locap", "resident26121972");
            
            /*  String serverName = "mysql.hostinger.com.ar";
            String mydatabase = "u842114668_locap";
            String url = "jdbc:apache://" + serverName + "/" + mydatabase;
            
            String username = "u842114668_locap";
            String password = "resident26121972";
            try {
            Connection connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
            
            }
        }*/ } catch (SQLException ex) {
            System.out.println("fallo en conexion"+ ex);
        }
    }
}