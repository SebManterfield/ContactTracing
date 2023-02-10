package GUI;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.Font;

public class TracerHomepageScreen extends Screen{

/* 
--------------
Labels
--------------
*/
private JLabel subtitle = new JLabel();
private JLabel testLabel1 = new JLabel();
private JLabel testLabel2 = new JLabel();
private JLabel testLabel3 = new JLabel();
private JLabel testLabel4 = new JLabel();
private JLabel testLabel5 = new JLabel();

private JLabel testIDLabel1 = new JLabel();
private JLabel testIdLabel2 = new JLabel();
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

public TracerHomepageScreen()
{

}

public void draw(TracerHomepageScreen ts)
{

    super.draw();
    drawLabels();
    drawButtons();
    updateContentPanel();

    TracerHomepageController c = new TracerHomepageController();
    c.addButtonListeners(ts);
}



public void drawLabels()
{
    super.drawHeaderLabel("Welcome Tracer " + TracerHomepageLoader.getTracerID(), super.getHeaderFont());

    Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());
    // create an arrayList to easily set font and set visible 
    ArrayList<JLabel> testLabelArray = new ArrayList<JLabel>();

    // add test labels to array
    testLabelArray.add(this.testLabel1);
    testLabelArray.add(this.testLabel2);
    testLabelArray.add(this.testLabel3);
    testLabelArray.add(this.testLabel4);
    testLabelArray.add(this.testLabel5);

    //set text of the test title labels
    for (JLabel temp: testLabelArray)
    {
        int i = 1;
        temp.setText("Test " + i);
        temp.setFont(font);
        temp.setVisible(true);
        i++;
    }




}












}
