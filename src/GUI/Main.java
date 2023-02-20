package GUI;

import java.util.Scanner;

public class Main {

    public static void main (String [] args)
    {
        // Create the form & display
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                System.out.println("Pick a Screen to view: \n1) Welcome Screen\n2)Agent Login Screen\n3)Submit a Test Screen\n4)Tracer Homepage Screen\n5)Review a Test Screen");
                Scanner in = new Scanner(System.in);

                String sToView = in.nextLine();

               switch (sToView)
               {
                   case "1":
                       WelcomeScreen w = new WelcomeScreen();
                       w.draw(w);
                       break;
                   case "2":
                       AgentLoginScreen a = new AgentLoginScreen();
                       a.draw(a);
                       break;
                   case "3":
                       SubmitATestScreen s = new SubmitATestScreen();
                       s.draw(s);
                       break;
                   case "4":
                       TracerHomepageScreen t = new TracerHomepageScreen();
                       t.draw(t);
                       break;
                   case "5":
                       ReviewATestScreen r = new ReviewATestScreen();
                       r.draw(r);
                       break;
                   default:
                       System.out.println("Valid input not entered");
                       run();

               }











            }
        });
    }


}
