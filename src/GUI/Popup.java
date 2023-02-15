package GUI;

import javax.swing.*;

import Controllers.Controller;

public class Popup extends Screen{

    public Popup()
    {this.setVisible(true);}

    JLabel popupLabel = new JLabel();
    JButton popupButton = new JButton();
    JPanel popupPanel = new JPanel();
    MyFont font = new MyFont();
    
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



    public void drawPanel()
    {  

         popupPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout popupPanelLayout = new javax.swing.GroupLayout(popupPanel);
        popupPanel.setLayout(popupPanelLayout);
        popupPanelLayout.setHorizontalGroup(
            popupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popupPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(popupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(popupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        popupPanelLayout.setVerticalGroup(
            popupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popupPanelLayout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(popupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(popupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(popupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(167, 167, 167))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPanel());
        getContentPanel().setLayout(layout);
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
        popupPanel.setVisible(true);
   
    }

    public void drawButton()
    {
        popupButton.setText("Accept");
        popupButton.setFont(new java.awt.Font(font.getName(), font.getStyle(), font.getSize())); 
        popupButton.setVisible(true);
    }

    public void drawLabel(String msg)
    {
        
        popupLabel.setText(msg);
        popupLabel.setFont(new java.awt.Font(font.getName(), font.getStyle(), font.getSize())); 
        popupLabel.setVisible(true);
    }


public JButton getPopupBtn()
{
return popupButton;
}




    
}
