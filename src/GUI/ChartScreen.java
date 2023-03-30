package GUI;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public class ChartScreen extends Screen {


    private JButton returnBtn = new JButton();

    public ChartScreen()
    {

    }



    public void draw(JFreeChart lineChart, int agentID) {

        super.draw();
        super.drawHeaderLabel("Charting", super.getHeaderFont());
        setSize(900,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        drawButtons();
        updateContentPanel(lineChart);
        //ChartController c= new ChartController();
        //c.addListeners(agentID);


    }

    public void updateContentPanel(JFreeChart lineChart)
    {
        JPanel contentPanel = super.getContentPanel();
       contentPanel.add(new ChartPanel(lineChart));
        contentPanel.setVisible(true);

    }

    public void drawButtons()
    {
        super.drawReturnButton();
        this.returnBtn = super.getReturnBtn();
        this.returnBtn.setText("Return to Homepage");
    }
}
