package GUI;

import Controllers.TracerHomepageController;
import Other.Test;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Font;

public class TracerHomepageScreen extends Screen{

    private int screenID = 3;

/* 
--------------
Labels
--------------
*/
private JLabel testLabel1 = new JLabel();
private JLabel testLabel2 = new JLabel();
private JLabel testLabel3 = new JLabel();
private JLabel testLabel4 = new JLabel();
private JLabel testLabel5 = new JLabel();

private JLabel testIDLabel1 = new JLabel();
private JLabel testIDLabel2 = new JLabel();
private JLabel testIDLabel3 = new JLabel();
private JLabel testIDLabel4 = new JLabel();
private JLabel testIDLabel5 = new JLabel();

private JLabel testDateLabel1 = new JLabel();
private JLabel testDateLabel2 = new JLabel();
private JLabel testDateLabel3 = new JLabel();
private JLabel testDateLabel4 = new JLabel();
private JLabel testDateLabel5 = new JLabel();
    
private JLabel testLocationLabel1 = new JLabel();
private JLabel testLocationLabel2 = new JLabel();
private JLabel testLocationLabel3 = new JLabel();
private JLabel testLocationLabel4 = new JLabel();
private JLabel testLocationLabel5 = new JLabel();

/* 
--------------
Buttons
--------------
*/
private JButton reviewBtn1 = new JButton();
private JButton reviewBtn2 = new JButton();
private JButton reviewBtn3 = new JButton();
private JButton reviewBtn4 = new JButton();
private JButton reviewBtn5 = new JButton();
private JButton markAllAsReviewedBtn = new JButton();

// Font
private Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());

public TracerHomepageScreen()
{

}

public void draw(TracerHomepageScreen ts, int agentID, ArrayList<Test> testArrayList)
{

    super.draw();
    drawLabels(agentID,testArrayList);
    drawButtons();
    updateContentPanel();

    TracerHomepageController c = new TracerHomepageController();
    c.addButtonListeners(ts,testArrayList, agentID);
}



public void drawLabels(int agentID, ArrayList<Test> testArrayList)
{
    //draw header label
    super.drawHeaderLabel(" Welcome Tracer " + agentID , super.getHeaderFont());


    // create arraylists for each type of label and add
    ArrayList<JLabel> testLabelArray = new ArrayList<>();
    // add test labels to array
    testLabelArray.add(this.testLabel1);
    testLabelArray.add(this.testLabel2);
    testLabelArray.add(this.testLabel3);
    testLabelArray.add(this.testLabel4);
    testLabelArray.add(this.testLabel5);



    ArrayList<JLabel> testIDLabelArray = new ArrayList<>();
    testIDLabelArray.add(this.testIDLabel1);
    testIDLabelArray.add(this.testIDLabel2);
    testIDLabelArray.add(this.testIDLabel3);
    testIDLabelArray.add(this.testIDLabel4);
    testIDLabelArray.add(this.testIDLabel5);

    ArrayList<JLabel> testDateLabelArray = new ArrayList<>();
    testDateLabelArray.add(this.testDateLabel1);
    testDateLabelArray.add(this.testDateLabel2);
    testDateLabelArray.add(this.testDateLabel3);
    testDateLabelArray.add(this.testDateLabel4);
    testDateLabelArray.add(this.testDateLabel5);


    ArrayList<JLabel> testLocationLabelArray = new ArrayList<>();
    testLocationLabelArray.add(this.testLocationLabel1);
    testLocationLabelArray.add(this.testLocationLabel2);
    testLocationLabelArray.add(this.testLocationLabel3);
    testLocationLabelArray.add(this.testLocationLabel4);
    testLocationLabelArray.add(this.testLocationLabel5);


    //set text of the test title labels and set visible
    int i = 1;
    for (JLabel temp: testLabelArray)
    {
        temp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        temp.setText(" Test " + i);
        temp.setFont(font);
        temp.setVisible(true);
        i++;
    }


i=0;
    for (JLabel temp: testIDLabelArray)
    {
        temp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        temp.setText(" Test ID: " + testArrayList.get(i).getTestID());
        temp.setFont(font);
        temp.setVisible(true);
        i++;
    }

    i = 0;
    for (JLabel temp: testDateLabelArray)
    {
        temp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        temp.setText(" Test Date: " + testArrayList.get(i).getTestDate());
        temp.setFont(font);
        temp.setVisible(true);
        i++;
    }
    i = 0;
    for (JLabel temp: testLocationLabelArray)
    {
        temp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        temp.setText(" Test Location: " + testArrayList.get(i).getTestLocation());
        temp.setFont(font);
        temp.setVisible(true);
        i++;
    }


}

public void drawButtons()
{
super.drawReturnButton();

ArrayList<JButton> reviewBtnArrayList= new ArrayList<>();

    reviewBtnArrayList.add(this.reviewBtn1);
    reviewBtnArrayList.add(this.reviewBtn2);
    reviewBtnArrayList.add(this.reviewBtn3);
    reviewBtnArrayList.add(this.reviewBtn4);
    reviewBtnArrayList.add(this.reviewBtn5);
    int i = 1;
    for (JButton temp: reviewBtnArrayList)
    {

        temp.setText(" Review Test " + i);
        temp.setFont(font);
        temp.setVisible(true);
        i++;
    }

    markAllAsReviewedBtn.setText(" Mark all as Reviewed");
    markAllAsReviewedBtn.setFont(font);
    markAllAsReviewedBtn.setVisible(true);

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
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(this.testLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testIDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testDateLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testLocationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.reviewBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(this.testLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testIDLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testDateLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testLocationLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.reviewBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(this.testLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testIDLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testDateLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testLocationLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.reviewBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                            .addComponent(this.testLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testIDLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testDateLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testLocationLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.reviewBtn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                            .addComponent(this.testLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testIDLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testDateLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.testLocationLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(this.reviewBtn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            ).addContainerGap()));


    contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.testLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testIDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testDateLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testLocationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.reviewBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.testLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testIDLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testDateLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testLocationLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.reviewBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.testLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testIDLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testDateLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testLocationLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.reviewBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.testLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testIDLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testDateLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testLocationLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.reviewBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(this.testLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testIDLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testDateLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.testLocationLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.reviewBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addContainerGap(50, Short.MAX_VALUE))
    );


    contentPanel.setVisible(true);

}

    public JButton getReviewBtn1() {
        return reviewBtn1;
    }

    public JButton getReviewBtn2() {
        return reviewBtn2;
    }

    public JButton getReviewBtn3() {
        return reviewBtn3;
    }

    public JButton getReviewBtn4() {
        return reviewBtn4;
    }

    public JButton getReviewBtn5() {
        return reviewBtn5;
    }
}
