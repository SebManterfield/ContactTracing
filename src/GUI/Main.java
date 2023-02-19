package GUI;

public class Main {

    public static void main (String [] args)
    {
        // Create the form & display
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //instantiate an object of type screen and run
                TracerHomepageScreen s = new TracerHomepageScreen();
                s.draw(s);
            }
        });
    }


}
