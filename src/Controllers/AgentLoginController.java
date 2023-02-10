package Controllers;

import GUI.AgentLoginScreen;
import Loaders.AgentLoginLoader;

import java.awt.event.*;
import java.sql.SQLException;

public class AgentLoginController extends Controller {
    
public AgentLoginController()
{

}

public void addListeners(AgentLoginScreen as)
{


// login button listener
as.getAgentLoginBtn().addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String username = as.getUsernameTF().getText();
        char[] password = as.getPasswordTF().getPassword();

        try {
            AgentLoginLoader.loginBtnClicked(as, username, password);
        } catch (Exception f) {
            System.out.println("loginBtnClicked method call failed (AgentLoginController)");
        }
    }

});


// return button listener
super.returnButtonListener(as);



}


}
