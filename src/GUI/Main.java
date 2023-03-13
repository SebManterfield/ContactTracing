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
               
               
               
                WelcomeScreen ws = new WelcomeScreen();
                ws.draw(ws);
               



            }
        });
    }


}
