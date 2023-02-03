package GUI;

import javax.swing.*;

import Controllers.AgentLoginController;
import java.awt.Font;

public class AgentLoginScreen extends Screen {
    

    // initialise Login Screen attributes
private JButton loginBtn = new JButton();
private JLabel usernameLabel = new JLabel();
private JLabel passwordLabel = new JLabel();
private JLabel loginMessageLabel = new JLabel();
private JTextField usernameTF = new JTextField();
private JPasswordField passwordTF = new JPasswordField();


public AgentLoginScreen()
{

}

public void draw(AgentLoginScreen a)
{

    super.draw();

    drawLabels();
    drawButtons();
    drawTextFields();
    updatePanels();
    AgentLoginController c = new AgentLoginController();
    c.addListeners(a);
    

}

public void updatePanels()
{
    JPanel contentPanel = super.getContentPanel(); 
    JPanel footerPanel = super.getFooterPanel();
    /*
         -------------------------------------
         -------- Content Panel Layout -------
         -------------------------------------
         */

         javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
         contentPanel.setLayout(contentPanelLayout);
         contentPanelLayout.setHorizontalGroup(
             contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(contentPanelLayout.createSequentialGroup()
                 .addGap(348, 348, 348)
                 .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(contentPanelLayout.createSequentialGroup()
                         .addComponent(this.passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(this.loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(this.passwordLabel)
                     .addComponent(this.usernameLabel)
                     .addComponent(this.usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addContainerGap(200, Short.MAX_VALUE))
         );
        
         contentPanelLayout.setVerticalGroup(
             contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(contentPanelLayout.createSequentialGroup()
                 .addGap(142, 142, 142)
                 .addComponent(this.usernameLabel)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(this.usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(29, 29, 29)
                 .addComponent(this.passwordLabel)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(this.loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(this.passwordTF, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                 .addContainerGap(487, Short.MAX_VALUE))
         );

        
        contentPanel.setVisible(true);
        footerPanel.setVisible(true);
}


public void drawLabels()
{ //draw header and login labels
    
    
    super.drawHeaderLabel("Agent Login", super.getHeaderFont());
    

    Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());

    this.usernameLabel.setFont(font);
    this.usernameLabel.setText(" Username:");

    this.passwordLabel.setFont(font);
    this.passwordLabel.setText("Password:");

    this.usernameLabel.setVisible(true);
    this.passwordLabel.setVisible(true);
}

public void drawButtons()
    {   
        // define the button font
        MyFont btnFont = new MyFont (12);
       
        // set button text & font
        this.loginBtn.setText("Login");
        this.loginBtn.setFont(new java.awt.Font(btnFont.getName(), btnFont.getStyle(), btnFont.getSize())); 
        
        
      
        


        this.loginBtn.setVisible(true);
        super.drawReturnButton();
        
    }

    public void drawTextFields()
    {



        this.usernameTF.setVisible(true);
        this.passwordTF.setVisible(true);
    }

    // this label is only drawn after a failed login so has it's own method
    public void drawLoginMessageLabel(String message)
    {
        Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());
        this.passwordLabel.setFont(font);
        this.loginMessageLabel.setText(message);
        this.loginMessageLabel.setVisible(true);

    }

    public JButton getAgentLoginBtn()
    {
        return this.loginBtn;
    }



}
