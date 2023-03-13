package Loaders;

import GUI.Popup;

import java.sql.*;


public class Loader {

    public Loader() {

    }

    public static Connection dbConnect() {

        try {
            // ensure the MySQL connector.JAR file is included in the external libraries of the project
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Diss", "test", "password");
            System.out.println("Connected");
            return conn;

        } catch (SQLException e) {
            System.out.println("Database Connection error (Loader). Error Code: " + e.getMessage());
            return null;
        }
    }

    // calls a popup with a  message
    public static void drawMessage(int returnTo,String msg)
    {

        Popup p = new Popup();
        p.draw(msg, returnTo,p);
    }
}






