package Controllers;




import java.awt.event.*;
import GUI.WelcomeScreen;
import Loaders.AgentLoginLoader;


public class WelcomeScreenController extends Controller{
    


public static void submitACovidTestBtnClicked()
{

}

public void addButtonListeners(WelcomeScreen ws)
{
    
    
        // adds listeners which call the controller functions
       ws.getSubmitATestButton().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //submitACovidTestBtnClicked(WelcomeScreen s);
        }
        
    });

        // adds listeners which call the controller functions
       ws.getAgentLoginBtn().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            agentLoginBtnClicked(ws);
        }


    });




}

public static void agentLoginBtnClicked(WelcomeScreen ws)
{
    ws.close();
    AgentLoginLoader.loadScreen();


}


}
