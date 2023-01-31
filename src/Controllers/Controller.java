package Controllers;

import GUI.Screen;
import Loaders.WelcomeScreenLoader;

import java.awt.event.*;
public class Controller {
    
public void Controller()
{

}

public void returnButtonListener(Screen s)

{
    
 // adds return button listener
    s.getReturnBtn().addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        returnBtnClicked(s);
    }
    
});
}

public void returnBtnClicked(Screen s)
{
s.close();
WelcomeScreenLoader.loadScreen();
}

}
