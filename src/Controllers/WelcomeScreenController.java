package Controllers;




import java.awt.event.*;
import GUI.WelcomeScreen;
import Loaders.AgentLoginLoader;
import Loaders.SubmitATestLoader;


public class WelcomeScreenController extends Controller{
    


public void addButtonListeners(WelcomeScreen ws)
{
    
    
        // adds listeners which call the controller functions
       ws.getSubmitATestButton().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            submitATestBtnClicked(ws);
        }
        
    });

        // adds listeners which call the controller functions
       ws.getAgentLoginBtn().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            agentLoginBtnClicked(ws);
        }


    });




}

public void agentLoginBtnClicked(WelcomeScreen ws)
{
    ws.close();
    AgentLoginLoader.loadScreen();


}

public void submitATestBtnClicked(WelcomeScreen ws)
{
    ws.close();
    SubmitATestLoader.loadScreen();
    }


}
