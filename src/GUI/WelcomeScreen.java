package GUI;

import javax.swing.*;

public class WelcomeScreen extends Screen {

    private JButton agentLoginBtn;
    private JButton submitACovidTestBtn;



WelcomeScreen()
    {


    }

public void draw ()
{
    super.draw();

    drawLabels();
    drawButtons();


}



public void drawButtons()
    {


    }

    // draws welcome screen labels
public void drawLabels()
{
    Font welcomeHeader = new Font(24);
    super.drawHeaderLabel("Welcome to Contact Tracing", welcomeHeader);
}

}
