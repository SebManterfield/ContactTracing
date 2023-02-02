package Loaders;

import java.sql.*;


public class Loader {

    public Loader()
    {

    }

    public static Connection dbConnect ()   {

        try {
            Connection dbC = DriverManager.getConnection("jdbc:derby://127.0.0.1:3306//Diss");
            return dbC;
        }
        catch (Exception e)
        {
            System.out.println("Database connection failure (Loader)");
            return null;
        }
    }





}
