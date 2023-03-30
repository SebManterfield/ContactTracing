package Controllers;

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

                //0 = none, 1 = Days, 2 = Months, 3 = Quarters, 4 = Years
                int intervalIndex = ahs.getIntervalComboBox().getSelectedIndex();
                String period = ahs.getPeriodTF().getText();

                try {
                    AnalystHomepageLoader.submitAnalysisBtnClicked(ahs,intervalIndex,period, agentID);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        ahs.getChartBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //0 = none, 1 = Days, 2 = Months, 3 = Quarters, 4 = Years
                int intervalIndex = ahs.getIntervalComboBox().getSelectedIndex();
                String period = ahs.getPeriodTF().getText();
                try {
                    ChartScreenLoader.chartBtnClicked(ahs, agentID, intervalIndex,period);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

    }


}
