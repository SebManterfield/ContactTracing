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
private JLabel periodLabel = new JLabel();
private JLabel periodDaysLabel = new JLabel();
private JLabel periodMonthsLabel = new JLabel();
private JLabel periodYearsLabel = new JLabel();

private JLabel periodDaysVarLabel = new JLabel();
private JLabel periodMonthsVarLabel = new JLabel();
private JLabel periodYearsVarLabel = new JLabel();
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
Text Fields
--------------
*/
private JTextField periodDaysTF = new JTextField();
private JTextField periodMonthsTF = new JTextField();
private JTextField periodYearsTF = new JTextField();

public AnalystHomepageScreen()
{
    this.setVisible(true);
}

public void draw(AnalystHomepageScreen ahs,String[] period, int[] caseNumArray, int agentID, int cases, int increase)
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
                            .addGap(26, 26, 26)
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                    .addComponent(periodDaysLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE)
                                                                    .addComponent(periodLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(periodDaysTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(chartBtn, javax.swing.GroupLayout.Alignment.LEADING, 150,150,150)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                                    .addComponent(percentIncreaseLabel,110,110,110)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(percentIncreaseVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                                    .addComponent(casesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(casesVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                                    .addComponent(periodYearsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(periodYearsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                                    .addComponent(periodMonthsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(periodMonthsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                                    .addComponent(periodDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(periodDaysVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(periodMonthsVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(periodYearsVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                                    .addComponent(submitAnalysisBtn, javax.swing.GroupLayout.Alignment.LEADING, 150,150,150)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)

                                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                                            .addComponent(totalCasesReviewedLabel,150,150,150)
                                                            .addGap(34, 34, 34)
                                                            .addComponent(totalCasesReviewedVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                                            .addComponent(totalCasesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(totalCasesVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(145, 145, 145))

                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(trendAnalysisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(150, 150, 150)
                                            .addComponent(welcomeLabel, 200, 200, 200)
                                            .addGap(100, 100, Short.MAX_VALUE))))
    );
    contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(trendAnalysisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))

                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))

                            .addGap(18, 18, 18)
                            .addComponent(periodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(periodDaysLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(periodDaysTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))

                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(periodMonthsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(periodMonthsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))

                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(periodYearsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(periodYearsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))

                                            .addGap(17, 17, 17)
                                            .addComponent(submitAnalysisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(casesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(casesVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))

                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(periodDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(periodDaysVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(periodMonthsVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(periodYearsVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            )

                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(percentIncreaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(percentIncreaseVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))

                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(totalCasesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(totalCasesVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))

                                            .addGap(18, 18, 18)
                                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(totalCasesReviewedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(totalCasesReviewedVarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))

                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(chartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(66, Short.MAX_VALUE))
    );


        contentPanel.setVisible(true);
}

public void drawLabels(int[] caseNumArray, int agentID, String[] period, int cases, int increase)
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

    this.periodDaysLabel.setText(" Days:");
    labelArray.add(this.periodDaysLabel);

    this.periodMonthsLabel.setText(" Months:");
    labelArray.add(this.periodMonthsLabel);

    this.periodYearsLabel.setText(" Years:");
    labelArray.add(this.periodYearsLabel);

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

    this.periodDaysVarLabel.setText(" " +period[0]+ " Days" );
    labelArray.add(this.periodDaysVarLabel);

    this.periodMonthsVarLabel.setText(" "+ period[1] + " Months");
    labelArray.add(this.periodMonthsVarLabel);

    this.periodYearsVarLabel.setText(" " + period[2] + " Years");
    labelArray.add(this.periodYearsVarLabel);
    
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


    public JTextField getPeriodDaysTF() {
        return periodDaysTF;
    }

    public JTextField getPeriodMonthsTF() {
        return periodMonthsTF;
    }

    public JTextField getPeriodYearsTF() {
        return periodYearsTF;
    }

    public JButton getChartBtn() {
        return chartBtn;
    }
}

