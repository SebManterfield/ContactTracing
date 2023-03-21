package Loaders;

import GUI.*;

public class AnalystHomepageLoader extends Loader {

    public static void loadScreen(int agentID)
    {
        AnalystHomepageScreen ah = new AnalystHomepageScreen();
        ah.draw(ah);
    }

}
