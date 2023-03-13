package GUI;

import javax.swing.*;


// parent screen class implements common UI elements
public class Screen extends javax.swing.JFrame {

    // defining basic UI elements
   
    private JLabel headerLabel = new javax.swing.JLabel();
    private JPanel headerPanel = new javax.swing.JPanel();
    private JPanel contentPanel = new javax.swing.JPanel();
    private JPanel footerPanel = new javax.swing.JPanel();
    private JButton returnBtn = new JButton();
    private MyFont header = new MyFont(24);
    private MyFont labelFont = new MyFont();


    public Screen() {
        this.setVisible(true);
    }

    // sets basic frame size and calls component draw methods
    public void draw() {
        // set the Frame to be visible


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 800));
        drawPanels();

        // call the headerLabel with default values
        drawHeaderLabel("default", new MyFont());


    }

    


    // draws the panels and positions them
    public void drawPanels() {

        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


        /*
         -------------------------------------
         -------- Header Panel Layout --------
         -------------------------------------
         */

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addGap(270, 270, 270))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

       

        contentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 295, Short.MAX_VALUE)
        );



       /*
         -------------------------------------
         -------- Footer Panel Layout --------
         -------------------------------------
         */

        footerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
                footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(footerPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
                footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanelLayout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();


    }

    
// this method allows for the header label style and size to be changed by passing parameters
    public void drawHeaderLabel(String labelText, MyFont font) {
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText(labelText);
        headerLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        headerLabel.setFont(new java.awt.Font(font.getName(), font.getStyle(), font.getSize()));



    }
public void drawReturnButton ()
{       MyFont btnFont = new MyFont (12);

        this.returnBtn.setText("Return to Welcome Screen");
        this.returnBtn.setFont(new java.awt.Font(btnFont.getName(), btnFont.getStyle(), btnFont.getSize())); 
        this.returnBtn.setVisible(true);
        footerPanelReturnBtn();
}

public void footerPanelReturnBtn()
{
          /*
         -------------------------------------
         -------- Footer Panel Layout --------
         -------------------------------------
         */

         javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(this.returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(this.returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        footerPanel.setVisible(true);
        
}

public void footerPanelReturnBtn(JButton buttonToAdd)
{
          /*
         -------------------------------------
         -------- Footer Panel Layout --------
         -------------------------------------
         */

         javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(this.returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 450, Short.MAX_VALUE)
                .addComponent(buttonToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
            footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanelLayout.createSequentialGroup()
            .addContainerGap(12, Short.MAX_VALUE)
            .addGroup(footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(this.returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addContainerGap(12, Short.MAX_VALUE))
                );
        footerPanel.setVisible(true);
        
        
}

public JPanel getContentPanel()
{
        return this.contentPanel;
}

public JPanel getFooterPanel()
{
        return this.footerPanel;
}

public JButton getReturnBtn()
{
        return this.returnBtn;
}

public MyFont getHeaderFont()
{
        return header;
}

public MyFont getLabelFont()
{
        return labelFont;
}

public String getLabelFontName()
{
        return labelFont.getName();
}
public int getLabelFontStyle()
{
        return labelFont.getStyle();
}
public int getLabelFontSize()
{
        return labelFont.getSize();
}


public void close()
{
        this.dispose();
}

}
