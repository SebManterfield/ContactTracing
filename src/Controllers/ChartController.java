package Controllers;

import GUI.ChartScreen;
import Loaders.AnalystHomepageLoader;
import Loaders.ChartScreenLoader;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ChartController extends Controller{


    public ChartController()
    {

    }


    public void addListeners(ChartScreen cs, int agentID, JFreeChart lineChart, ChartPanel chartPanel)
    {

        cs.getReturnBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ChartScreenLoader.returnBtnClicked(cs,agentID);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        cs.getSaveBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ChartScreenLoader.saveBtnClicked(cs,agentID, lineChart, chartPanel);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


    }









}
