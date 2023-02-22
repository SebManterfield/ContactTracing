package GUI;

import javax.swing.*;

import Controllers.Controller;
import java.awt.Font;

/*
 * The Popup class is used to display messages to the user such as a failed login
 */
public class Popup extends Screen{

    public Popup()
    {this.setVisible(true);}

    // attributes
    private JLabel popupLabel = new JLabel();
    private JButton popupBtn = new JButton();
    private JPanel popupPanel = new JPanel();
    private Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());

    // the draw method takes the message to be displayed and the screen to return to as parameters
    public void draw(String msg, int returnTo, Popup p)
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));
      
        drawButton();
        drawLabel(msg);
        drawPanel();
        

        Controller c = new Controller();
        c.popupButtonListener(returnTo, p);
    }


    // draws the popup panel and adds the button and label
    public void drawPanel()
    {  

         popupPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

          /*
         ------------------------------
         -------- Panel Layout --------
         ------------------------------
         */
        javax.swing.GroupLayout popupPanelLayout = new javax.swing.GroupLayout(popupPanel);
        popupPanel.setLayout(popupPanelLayout);
        popupPanelLayout.setHorizontalGroup(
            popupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(popupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(popupPanelLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(popupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        popupPanelLayout.setVerticalGroup(
            popupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(popupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(popupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

         /*
         ------------------------------
         -------- Group Layout --------
         ------------------------------
         */

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(popupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(popupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        popupPanel.setVisible(true);
   
    }

    //draw the button and set the text
    public void drawButton()
    {
        this.popupBtn.setText("Accept");
        this.popupBtn.setFont(font); 
        this.popupBtn.setVisible(true);
    }

    // takes the message to be displayed as a parameter
    public void drawLabel(String msg)
    {
        this.popupLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.popupLabel.setText(msg);
        this.popupLabel.setHorizontalAlignment(JLabel.CENTER);
        this.popupLabel.setFont(font); 
        this.popupLabel.setVisible(true);
    }

// if the button needs to display other text this getter can be used
public JButton getPopupBtn()
{
return popupBtn;
}




    
}
