package Loaders;

import GUI.WelcomeScreen;;

public class WelcomeScreenLoader extends Loader {
    


    public static void loadScreen()
    {
        WelcomeScreen ws = new WelcomeScreen();
        ws.draw(ws);
    }

}

