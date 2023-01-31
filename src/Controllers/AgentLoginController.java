package Controllers;

import GUI.AgentLoginScreen;
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
        loginBtnClicked(as);
    }
    
});


// return button listener
super.returnButtonListener(as);

}




}
