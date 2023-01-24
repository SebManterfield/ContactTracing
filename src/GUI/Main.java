package GUI;

public class Main {

    public static void main (String [] args)
    {
        // Create the form & display
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //instantiate an object of type screen and run
                Screen s = new Screen();
                s.setVisible(true);
                s.draw();
            }
        });
    }


}
