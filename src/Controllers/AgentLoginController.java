package Controllers;

import GUI.*;
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
        char[] p = as.getPasswordTF().getPassword();
        
        String password = p.toString();


        validateLoginFields(username, password,as);
        

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


public void validateLoginFields(String username, String password,AgentLoginScreen as)
{  
    
    if (username.isEmpty() || password.isEmpty())
    {   
        String msg = "The username or password field is empty!";
        as.close();
        AgentLoginLoader.drawFailedLoginMsg(msg);
        
    }
}


}
