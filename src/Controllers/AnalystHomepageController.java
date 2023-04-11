package Controllers;

import GUI.AgentLoginScreen;
import GUI.AnalystHomepageScreen;
import GUI.TracerHomepageScreen;
import Loaders.AnalystHomepageLoader;
import Loaders.ChartScreenLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AnalystHomepageController extends Controller {


    public void addButtonListeners(AnalystHomepageScreen ahs, int agentID)
    {
        super.returnButtonListener(ahs);

        ahs.getSubmitAnalysisBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] period = getTextFields(ahs);


                try {
                    AnalystHomepageLoader.submitAnalysisBtnClicked(ahs,period, agentID);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        ahs.getChartBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //0 = none, 1 = Days, 2 = Months, 3 = Quarters, 4 = Years
                String[] period = getTextFields(ahs);
                try {
                    ChartScreenLoader.chartBtnClicked(ahs, agentID,period);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

    }
        // returns values of text fields as an array
    public String[] getTextFields(AnalystHomepageScreen ahs) {
        String[] period = new String[3];
        if (ahs.getPeriodDaysTF().getText().length() == 0) {
            period[0] = "0";
        } else {
            period[0] = ahs.getPeriodDaysTF().getText();
        }

        if (ahs.getPeriodMonthsTF().getText().length() == 0) {
            period[1] = "0";
        } else {
            period[1] = ahs.getPeriodMonthsTF().getText();
        }

        if (ahs.getPeriodYearsTF().getText().length() == 0) {
            period[2] = "0";
        } else {
            period[2] = ahs.getPeriodYearsTF().getText();
        }

        return period;
    }


}
