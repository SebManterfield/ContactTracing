package GUI;

import java.sql.*;

public class Main {

    public static void main (String [] args)
    {
        // Create the form & display
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //instantiate an object of type screen and run
               
               
               
                SubmitATestScreen ws = new SubmitATestScreen();             
                ws.draw(ws);
               
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/diss", "root", "password");
                        PreparedStatement test = conn.prepareStatement("SELECT * FROM test");
                        ResultSet rs = test.executeQuery();
                        
                
                
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Failed to connect");
                    }

            }
        });
    }


}
