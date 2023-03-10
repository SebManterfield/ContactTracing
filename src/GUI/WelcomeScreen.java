package GUI;

import javax.swing.*;



import Controllers.WelcomeScreenController;

public class WelcomeScreen extends Screen{

    private int screenID = 0;
    private JButton agentLoginBtn = new JButton();
    private JButton submitATestBtn = new JButton();



public WelcomeScreen()
    {
        

    }



public void draw (WelcomeScreen s)
{
    super.draw();
    drawLabels();
    drawButtons();
    updateContentPanel();

    WelcomeScreenController c = new WelcomeScreenController();
    c.addButtonListeners(s);

}

public void updateContentPanel()
{   // get the superclass content panel to update it
    JPanel contentPanel = super.getContentPanel(); 
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
                .addGap(335, 335, 335)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(this.agentLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.submitATestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(318, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(this.agentLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(this.submitATestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
        );
        contentPanel.setVisible(true);
}

public void drawButtons()
    {   
        // define the button font
        MyFont btnFont = new MyFont (12);
       
        // set the agent login button text & font
        this.agentLoginBtn.setText("Agent Login");
        this.agentLoginBtn.setFont(new java.awt.Font(btnFont.getName(), btnFont.getStyle(), btnFont.getSize())); 
        
        // set submit a test button text & font
        this.submitATestBtn.setText("Submit a Covid Test");
        this.submitATestBtn.setFont(new java.awt.Font(btnFont.getName(), btnFont.getStyle(), btnFont.getSize())); 
        

        this.agentLoginBtn.setVisible(true);
        this.submitATestBtn.setVisible(true);
        
    }





    // draws welcome screen labels
public void drawLabels()
{
    
    super.drawHeaderLabel("Welcome to Contact Tracing", super.getHeaderFont());
}


public JButton getAgentLoginBtn()
{
    return this.agentLoginBtn;
}


public JButton getSubmitATestButton()
{
    return this.submitATestBtn;
}

public void close()
{
    super.close();
}

    public int getScreenID() {
        return screenID;
    }
}
