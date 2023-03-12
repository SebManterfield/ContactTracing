package Controllers;

import GUI.*;
import Loaders.*;

import java.awt.event.*;

public class Controller {
    
public Controller()
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
    //close previous screen and open welcome screen
s.close();
WelcomeScreenLoader.loadScreen();
}

public void popupButtonListener(int returnTo, Popup p) {

p.getPopupBtn().addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e) {
        popupBtnClicked(p, returnTo);
    }

});

}

public void popupBtnClicked (Popup p, int returnTo)
{
    p.close();

    switch(returnTo)
    {
        case 0:
        WelcomeScreenLoader.loadScreen();
        break;
        case 1:
        AgentLoginLoader.loadScreen();
        break;
    }

}



}
