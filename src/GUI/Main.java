package GUI;

public class Main {

    public static void main (String [] args)
    {
        loadDefault();
    }
    public static void loadDefault()
    {
        Screen s = new Screen();
        s.draw();
        s.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Screen().setVisible(true);
            }
        });
    }

}
