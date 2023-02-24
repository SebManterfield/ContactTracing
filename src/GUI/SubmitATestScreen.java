package GUI;

import javax.swing.*;

import Controllers.SubmitATestController;
import java.awt.Font;
import java.util.ArrayList;

public class SubmitATestScreen extends Screen
{
private String[] testOutcomes = {"Positive", "Negative"};
/* 
--------------
Labels
--------------
*/
private JLabel patientNameLabel = new JLabel();
private JLabel testPostcodeLabel = new JLabel();
private JLabel testDateLabel = new JLabel();
private JLabel testOutcomeLabel = new JLabel();
private JLabel patientMobileLabel = new JLabel();
private JLabel closeContact1NameLabel = new JLabel();
private JLabel closeContact1NumberLabel = new JLabel();
private JLabel closeContact2NameLabel = new JLabel();
private JLabel closeContact2NumberLabel = new JLabel();

/* 
--------------
Text Fields
--------------
*/

private JTextField patientNameTF = new JTextField();
private JTextField patientPostcodeTF = new JTextField();
private JTextField patientTestDateTF = new JTextField();
private JTextField patientMobileTF = new JTextField();
private JTextField closeContact1NameTF = new JTextField();
private JTextField closeContact1NumberTF = new JTextField();
private JTextField closeContact2NameTF = new JTextField();
private JTextField closeContact2NumberTF = new JTextField();
/* 
--------------
Combo Box
--------------
*/

private JComboBox patientTestOutcomeBox = new JComboBox(testOutcomes);

/* 
--------------
Button
--------------
*/
private JButton submitBtn = new JButton();



public SubmitATestScreen()
{

}


public void draw(SubmitATestScreen sts)
{
    super.draw();

    drawLabels();
    drawButtons();
    drawTextFields();
    drawComboBox();
    updatePanels();
    SubmitATestController c = new SubmitATestController();
    c.addListeners(sts);

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
            .addGap(24, 24, 24)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.testOutcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(this.patientTestOutcomeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.testPostcodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(patientPostcodeTF))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.testDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(patientTestDateTF))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.patientNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(this.patientNameTF))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.patientMobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(patientMobileTF))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.closeContact1NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(this.closeContact1NameTF))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.closeContact1NumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(this.closeContact1NumberTF))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.closeContact2NumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(this.closeContact2NumberTF))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addComponent(this.closeContact2NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(this.closeContact2NameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
            .addContainerGap())
    );
    // vertical layout
    contentPanelLayout.setVerticalGroup(
        contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(contentPanelLayout.createSequentialGroup()
        .addContainerGap(50, Short.MAX_VALUE)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(this.patientNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.patientNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.testDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.patientTestDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(this.testPostcodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(this.patientPostcodeTF))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(this.testOutcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.patientTestOutcomeBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.patientMobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.patientMobileTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.closeContact1NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.closeContact1NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.closeContact1NumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.closeContact1NumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.closeContact2NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.closeContact2NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.closeContact2NumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.closeContact2NumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(12, 12, 12)
            .addContainerGap(50, Short.MAX_VALUE))
    );
    
   super.footerPanelReturnBtn(submitBtn);
 
   
contentPanel.setVisible(true);
footerPanel.setVisible(true);
pack();
}

public void drawLabels()
{
 
    super.drawHeaderLabel("Submit a Covid Test", super.getHeaderFont());

    Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());
    // create an arrayList to easily set font and set visible 
    ArrayList<JLabel> labelArray = new ArrayList<JLabel>();

    
    this.patientNameLabel.setText("Patient Name:");
    labelArray.add(this.patientNameLabel);

    labelArray.add(this.testPostcodeLabel);
    this.testPostcodeLabel.setText("Postcode Area:");

    labelArray.add(this.testDateLabel);
    this.testDateLabel.setText("Test Date:");

    labelArray.add(this.testOutcomeLabel);
    this.testOutcomeLabel.setText("Test Outcome:");

    labelArray.add(this.patientMobileLabel);
    this.patientMobileLabel.setText("Patient Mobile Number:");
    
    labelArray.add(this.closeContact1NameLabel);
    this.closeContact1NameLabel.setText("Close Contact 1 Name:");

    labelArray.add(this.closeContact1NumberLabel);
    this.closeContact1NumberLabel.setText("Close Contact 1 Mobile Number:");

    labelArray.add(this.closeContact2NameLabel);
    this.closeContact2NameLabel.setText("Close Contact 2 Name:");

    labelArray.add(this.closeContact2NumberLabel);
    this.closeContact2NumberLabel.setText("Close Contact 2 Mobile Number:");

    for (JLabel temp: labelArray)
    {
        temp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        temp.setFont(font);
        temp.setVisible(true);

    }

}

public void drawButtons()
{
    super.drawReturnButton();
           
    // set button text & font
    this.submitBtn.setText("Submit");
    this.submitBtn.setFont(new java.awt.Font(super.getLabelFontName(), super.getLabelFontStyle(), super.getLabelFontSize())); 
    
    this.submitBtn.setVisible(true);
}

public void drawTextFields()
{
this.patientNameTF.setVisible(true);
this.patientPostcodeTF.setVisible(true);
this.patientTestDateTF.setVisible(true);
this.patientMobileTF.setVisible(true);
this.closeContact1NameTF.setVisible(true);
this.closeContact1NumberTF.setVisible(true);
this.closeContact2NameTF.setVisible(true);
this.closeContact2NumberTF.setVisible(true);
}

public void drawComboBox()
{


this.patientTestOutcomeBox.setVisible(true);

}

}