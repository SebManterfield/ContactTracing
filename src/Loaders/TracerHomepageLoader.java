package Loaders;

import GUI.ReviewATestScreen;
import GUI.TracerHomepageScreen;

public class TracerHomepageLoader extends Loader {


    public static void loadScreen()
    {
        TracerHomepageScreen ts = new TracerHomepageScreen();
        ts.draw(ts);
    }

}
