package Controllers;

import GUI.Screen;

public class Controller {
    
public void Controller()
{

}

public void returnButtonListener(Screen s)

{
 // adds return button listener
    s.getReturnBtn().addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        //submitACovidTestBtnClicked(WelcomeScreen s);
    }
    
});
}



}
