package GUI;
import Controllers.AnalystHomepageController;

import javax.swing.*;



import java.awt.Font;
import java.util.ArrayList;
public class AnalystHomepageScreen extends Screen {

    private int screenID = 4;

// font
    private Font font = new Font(super.getLabelFontName(), super.getLabelFontStyle(),super.getLabelFontSize());

/* 
--------------
Labels
--------------
*/

private JLabel welcomeLabel = new JLabel(); 
private JLabel trendAnalysisLabel = new JLabel(); 
private JLabel intervalLabel = new JLabel(); 
private JLabel periodLabel = new JLabel(); 
private JLabel periodVarLabel = new JLabel(); 
private JLabel casesLabel = new JLabel(); 
private JLabel casesVarLabel = new JLabel(); 
private JLabel periodDisplayLabel = new JLabel(); 
private JLabel percentIncreaseLabel = new JLabel(); 
private JLabel totalCasesLabel = new JLabel(); 
private JLabel totalCasesReviewedLabel = new JLabel(); 
private JLabel percentIncreaseVarLabel = new JLabel(); 
private JLabel totalCasesVarLabel = new JLabel(); 
private JLabel totalCasesReviewedVarLabel = new JLabel();

/* 
--------------
Buttons
--------------
*/

private JButton submitAnalysisBtn = new JButton();
private JButton chartBtn = new JButton();

/* 
--------------
Combo Box Outcomes
--------------
*/
private String[] intervals = {"-","Days", "Months","Years"};


/* 
--------------
Combo Boxes
--------------
*/

private JComboBox intervalComboBox = new JComboBox<>(intervals);

/* 
--------------
Text Fields
--------------
*/
private JTextField periodTF = new JTextField();

public AnalystHomepageScreen()
{
    this.setVisible(true);
}

public void draw(AnalystHomepageScreen ahs,String period, int[] caseNumArray, int agentID, int cases, int increase)
{
    super.draw();
    drawLabels(caseNumArray, agentID, period, cases,increase);
    drawButtons();
    updateContentPanel();
    AnalystHomepageController ahc = new AnalystHomepageController();
    ahc.addButtonListeners(ahs, agentID);
}


public void updateContentPanel()
{
    JPanel contentPanel = super.getContentPanel(); 
    javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(this.welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(this.trendAnalysisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(this.intervalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addComponent(this.intervalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(this.periodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.casesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.periodDisplayLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.percentIncreaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(this.periodTF, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.casesVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.periodVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.percentIncreaseVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(this.submitAnalysisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(this.chartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(136, 136, 136)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(this.totalCasesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.totalCasesReviewedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(this.totalCasesReviewedVarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(this.totalCasesVarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(this.welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(this.trendAnalysisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(this.intervalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.intervalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(this.periodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.periodTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.submitAnalysisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(this.totalCasesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.totalCasesVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(this.totalCasesReviewedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.totalCasesReviewedVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(this.casesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.casesVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(this.periodDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.periodVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(this.percentIncreaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.percentIncreaseVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(this.chartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        contentPanel.setVisible(true);
}

public void drawLabels(int[] caseNumArray, int agentID, String period, int cases, int increase)
{
    int totalCases = caseNumArray[0];
    int totalReviewedCases = caseNumArray[1];

    String strTotalCases = Integer.toString(totalCases);
    String strTotalReviewedCases = Integer.toString(totalReviewedCases);
    String strAnalysisCases;
    String strAnalysisIncrease;

    if (cases == -1)
        strAnalysisCases= "n";
    else
        strAnalysisCases = Integer.toString(cases);

    if (increase == -1)
        strAnalysisIncrease= "n";
    else
        strAnalysisIncrease = Integer.toString(increase);




    super.drawHeaderLabel("Analyst Homepage", super.getHeaderFont());
    
    // create arraylist to easily set attributes for all labels
    ArrayList<JLabel> labelArray = new ArrayList<>();
    
    // set text of each label and add to arraylist
    Font subtitle = new Font(super.getLabelFontName(), 1,16);
    this.welcomeLabel.setText(" Welcome user: " + agentID );
    this.welcomeLabel.setFont(subtitle);
    this.welcomeLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    this.trendAnalysisLabel.setText(" Trend Analysis: ");
    this.trendAnalysisLabel.setFont(subtitle);
    this.trendAnalysisLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    this.intervalLabel.setText(" Interval: ");
    labelArray.add(this.intervalLabel);

    this.periodLabel.setText(" Period (1-30): ");
    labelArray.add(this.periodLabel);

    this.casesLabel.setText(" Cases: ");
    labelArray.add(this.casesLabel);

    this.percentIncreaseLabel.setText(" Percent Increase: ");
    labelArray.add(this.percentIncreaseLabel);

    this.percentIncreaseVarLabel.setText(" " + strAnalysisIncrease);
    labelArray.add(this.percentIncreaseVarLabel);

    this.periodDisplayLabel.setText(" Period: ");
    labelArray.add(this.periodDisplayLabel);

    this.totalCasesLabel.setText(" Total Cases: ");
    labelArray.add(this.totalCasesLabel);

    this.totalCasesReviewedLabel.setText(" Total Cases Reviewed: ");
    labelArray.add(this.totalCasesReviewedLabel);

    this.periodVarLabel.setText(" " + period);
    labelArray.add(this.periodVarLabel);
    
    this.casesVarLabel.setText(" "+strAnalysisCases);
    labelArray.add(this.casesVarLabel);
    
    this.totalCasesVarLabel.setText(" " + strTotalCases);
    labelArray.add(this.totalCasesVarLabel);

    this.totalCasesReviewedVarLabel.setText(" " + strTotalReviewedCases);
    labelArray.add(this.totalCasesReviewedVarLabel);

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

    this.chartBtn.setText("View chart");
    this.chartBtn.setFont(font);
    this.chartBtn.setVisible(true);

    this.submitAnalysisBtn.setText("Submit");
    this.submitAnalysisBtn.setFont(font);
    this.submitAnalysisBtn.setVisible(true);


}

    public int getScreenID() {
        return screenID;
    }

    public JButton getSubmitAnalysisBtn() {
        return submitAnalysisBtn;
    }

    public JComboBox getIntervalComboBox() {
        return intervalComboBox;
    }

    public JTextField getPeriodTF() {
        return periodTF;
    }

    public JButton getChartBtn() {
        return chartBtn;
    }
}

