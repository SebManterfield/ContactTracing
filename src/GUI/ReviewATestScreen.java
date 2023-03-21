package GUI;
import Other.Test;

import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;

public class ReviewATestScreen extends Screen {

private int screenID = 5;

/* 
--------------
Labels
--------------
*/

private JLabel patientNameLabel = new JLabel();
private JLabel testDateLabel = new JLabel();
private JLabel testOutcomeLabel = new JLabel();
private JLabel cc1NameLabel = new JLabel();
private JLabel cc1MobileLabel = new JLabel();
private JLabel cc2NameLabel = new JLabel();
private JLabel cc2MobileLabel = new JLabel();

// variable labels - these will contain the data from database
private JLabel testDateVarLabel = new JLabel();
private JLabel testOutcomeVarLabel = new JLabel();
private JLabel testLocationVarLabel = new JLabel();
private JLabel cc1NameVarLabel = new JLabel();
private JLabel cc1MobileVarLabel = new JLabel();
private JLabel cc2NameVarLabel = new JLabel();
private JLabel cc2MobileVarLabel = new JLabel();

/* 
--------------
Buttons
--------------
*/

private JButton markAsReviewedBtn = new JButton();
private JButton returnBtn = new JButton();



private Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());


public ReviewATestScreen()
{

}

public void draw(ReviewATestScreen rts, Test test)
{
super.draw();

drawLabels(test);
drawButtons();
updateContentPanel();
//ReviewATestController c = new ReviewATestController();
//r.addListeners(rts);

}


public void drawLabels(Test test){

    super.drawHeaderLabel("Review a Test", super.getHeaderFont());

ArrayList<JLabel> labelArray = new ArrayList<>();

this.patientNameLabel.setText("Patient Name: ");
labelArray.add(this.patientNameLabel);

this.testDateLabel.setText("Test Date: ");
labelArray.add(this.testDateLabel);

this.testOutcomeLabel.setText("Test Outcome: ");
labelArray.add(this.testOutcomeLabel);

this.cc1NameLabel.setText("Close Contact 1 Name: ");
labelArray.add(this.cc1NameLabel);

this.cc1MobileLabel.setText("Close Contact 1 Mobile: ");
labelArray.add(this.cc1MobileLabel);

this.cc2NameLabel.setText("Close Contact 2 Name: ");
labelArray.add(this.cc2NameLabel);

this.cc2MobileLabel.setText("Close Contact 2 Mobile: ");
labelArray.add(this.cc2MobileLabel);

this.testDateVarLabel.setText(test.getTestDate());
labelArray.add(this.testDateVarLabel);

String outcome;
if (test.getOutcome().equals("0"))
{
    outcome = "Negative";
}
else
{
    outcome = "Positive";
}
this.testOutcomeVarLabel.setText(outcome);
labelArray.add(this.testOutcomeVarLabel);

this.testLocationVarLabel.setText(test.getTestLocation());
labelArray.add(this.testLocationVarLabel);

this.cc1NameVarLabel.setText(test.getCc1Name());
labelArray.add(this.cc1NameVarLabel);

this.cc1MobileVarLabel.setText(test.getCc1Mobile());
labelArray.add(this.cc1MobileVarLabel);

this.cc2NameVarLabel.setText(test.getCc2Name());
labelArray.add(this.cc2NameVarLabel);

this.cc2MobileVarLabel.setText(test.getCc2Mobile());
labelArray.add(this.cc2MobileVarLabel);

for(JLabel temp: labelArray)
{
    temp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    temp.setFont(font);
    temp.setVisible(true);
    }


}

public void drawButtons()
{
    super.drawReturnButton();
    this.returnBtn = super.getReturnBtn();
    

    this.returnBtn.setText("Return to Homepage");
    this.markAsReviewedBtn.setText("Mark as Reviewed");
    this.markAsReviewedBtn.setFont(font);
    this.markAsReviewedBtn.setVisible(true);

}
    
public void updateContentPanel()
{
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
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(this.testDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(this.testDateVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(this.testOutcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(this.testOutcomeVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(this.cc1NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(this.cc1NameVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(this.cc1MobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(this.cc1MobileVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(this.cc2NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(cc2NameVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(this.cc2MobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(this.cc2MobileVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(this.markAsReviewedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(contentPanelLayout.createSequentialGroup()
                    .addGap(350, 350, 350)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(this.patientNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )))
            .addContainerGap(403, Short.MAX_VALUE))
    );
    contentPanelLayout.setVerticalGroup(
        contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(contentPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(this.patientNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.testDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.testDateVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.testOutcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.testOutcomeVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.cc1NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.cc1NameVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.cc1MobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.cc1MobileVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.cc2NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.cc2NameVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(this.cc2MobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.cc2MobileVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(this.markAsReviewedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
            .addGap(18, 18, 18)
            .addContainerGap(50, Short.MAX_VALUE))
    );

contentPanel.setVisible(true);

}

    public int getScreenID() {
        return screenID;
    }
}

