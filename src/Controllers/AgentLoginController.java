package Controllers;

import GUI.*;
import Loaders.AgentLoginLoader;

import java.awt.event.*;


public class AgentLoginController extends Controller {
    
public AgentLoginController()
{

}

public void addListeners(AgentLoginScreen as)
{


// login button listener
    as.getAgentLoginBtn().addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        // get the username and password and store
        String username = as.getUsernameTF().getText();
        String password = as.getPasswordTF().getText();
        AgentLoginLoader.validateLoginFields(username, password,as);
        

        try {
            AgentLoginLoader.loginBtnClicked(as, username, password);
        } catch (Exception f) {
            System.out.println("loginBtnClicked method call failed (AgentLoginController) Error Message: " + f.getMessage());
        }
    }

});
// return button listener
super.returnButtonListener(as);


}




}
