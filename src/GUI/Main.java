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
                        Class.forName("com.mysql.jdbc.Driver").newInstance();

                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diss","test","password");
                        System.out.println("Connected");
                        PreparedStatement test = conn.prepareStatement("SELECT * FROM test");
                        ResultSet rs = test.executeQuery();
                        
                
                
                    }
                    catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
                    {
                        System.out.println("Failed to connect");
                    }

            }
        });
    }


}
