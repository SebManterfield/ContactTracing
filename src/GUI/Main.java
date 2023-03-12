package GUI;

import javax.sound.midi.Soundbank;
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
                        // ensure the MySQL connector.JAR file is included in the external libraries of the project
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Diss","test","password");
                        System.out.println("Connected");

                        PreparedStatement st = conn.prepareStatement("SELECT * FROM test");
                        ResultSet rs = st.executeQuery();

                        System.out.println(rs.isFirst());
                
                
                    }
                    catch (SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }


            }
        });
    }


}
