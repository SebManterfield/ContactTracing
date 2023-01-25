package GUI;

import javax.swing.*;

public class AgentLoginScreen extends Screen {
    
private JButton loginBtn = new JButton();
private JButton returnBtn = new JButton();
private JLabel usernameLabel = new JLabel();
private JLabel passwordLabel = new JLabel();
private JTextField usernameTF = new JTextField("Username");
private JPasswordField passwordTF = new JPasswordField("Password");

public AgentLoginScreen()
{

}

public void draw()
{

    super.draw();

    drawLabels();
    drawButtons();
    drawTextFields();
    //updateContentPanel();
    //updateFooterPanel();

}


public void drawLabels()
{ //draw header and login labels
    MyFont loginHeader = new MyFont(24);
    MyFont labelFont = new MyFont();
    super.drawHeaderLabel("Agent Login", loginHeader);

    usernameLabel.setFont(new java.awt.Font(labelFont.getName(), labelFont.getStyle(), labelFont.getSize()));
    usernameLabel.setText("Username:");

    passwordLabel.setFont(new java.awt.Font(labelFont.getName(), labelFont.getStyle(), labelFont.getSize()));
    passwordLabel.setText("Password:");
}

public void drawButtons()
    {   
        // define the button font
        MyFont btnFont = new MyFont (12);
       
        // set button text & font
        this.loginBtn.setText("Login");
        this.loginBtn.setFont(new java.awt.Font(btnFont.getName(), btnFont.getStyle(), btnFont.getSize())); 
        
        
        this.returnBtn.setText("Submit a Covid Test");
        this.returnBtn.setFont(new java.awt.Font(btnFont.getName(), btnFont.getStyle(), btnFont.getSize())); 
        

        this.loginBtn.setVisible(true);
        this.returnBtn.setVisible(true);
        
    }

    public void drawTextFields()
    {

    }
}
