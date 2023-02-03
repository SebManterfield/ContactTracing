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


public void draw()
{
    super.draw();

    drawLabels();
    drawButtons();
    drawTextFields();
    drawComboBox();
    updatePanels();
    SubmitATestController c = new SubmitATestController();
    c.addListeners(a);

}



public void updatePanels()
{
    
}

public void drawLabels()
{
 
    super.drawHeaderLabel("Submit a Covid Test", super.getHeaderFont());

    Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());
    // create an arrayList to easily set font and set visible 
    ArrayList<JLabel> labelArray = new ArrayList<JLabel>();

    
    this.patientNameLabel.setText("Patient Name:");
    labelArray.add(this.patientNameLabel);

    labelArray.add(this.patientNameLabel);
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
this.closeContact1NameTF.setVisible(true);
this.closeContact1NumberTF.setVisible(true);
this.closeContact2NameTF.setVisible(true);
this.closeContact2NumberTF.setVisible(true);
}

public void drawComboBox()
{
;

this.patientTestOutcomeBox.setVisible(true);

}

}