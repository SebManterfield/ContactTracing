package Loaders;

import GUI.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import static Loaders.Loader.*;

public class ChartScreenLoader {



    public static void loadScreen(AnalystHomepageScreen ahs, JFreeChart lineChart, int agentID)
    {
        ahs.close();
        ChartScreen cs = new ChartScreen();
        cs.draw(cs,lineChart, agentID);

    }

    public static void chartBtnClicked(AnalystHomepageScreen ahs, int agentID,int intervalIndex, String period) throws SQLException {

        AnalystHomepageLoader.validateAnalysisFields(ahs,intervalIndex,period, agentID);


        DefaultCategoryDataset dataset = calculateDataset(intervalIndex,period);

        System.out.println("dataset calculated");

        String interval = "";

        switch (intervalIndex) {
            case 1:
                interval = "days";
                break;
            case 2:
                interval = "months";
                break;
            case 3:
                interval = "years";
                break;
        }


        JFreeChart lineChart = createLineChart("Cases over the last " + period + " " + interval, dataset);
        loadScreen(ahs,lineChart, agentID);

    }

    public static JFreeChart createLineChart(String title, DefaultCategoryDataset dataset)
    {
        //create line chart with given parameters
        JFreeChart lineChart = ChartFactory.createLineChart(
                title,
                "Dates",
                "Cases",
                dataset
        );
        //set the labels vertical
        CategoryAxis axis = lineChart.getCategoryPlot().getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        return lineChart;

    }

    public static DefaultCategoryDataset calculateDataset(int intervalIndex, String period) throws SQLException {

        String startDate = java.time.LocalDate.now().toString();
        // retrieves start and end dates for graphs

        String[] dates = AnalystHomepageLoader.computePeriod(intervalIndex,period,startDate);

        // retrieves all dates and case numbers for given period
        ResultSet casesRS = getDataset(dates);

        int size = 0;
        while(casesRS.next())
        {
            size++;
            casesRS.next();
        }
        casesRS.beforeFirst();


        String[][] datasetArray = new String[2][size];
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "Cases";

        //null check
        if (!casesRS.next())
            System.out.println("Empty Dataset!");

        else
        {
            int i = 0;
            casesRS.beforeFirst();
            while(casesRS.next())
            {

                datasetArray[0][i] = casesRS.getString("test_date");
                datasetArray[1][i] = casesRS.getString("COUNT(test_date)");
                String testDate = datasetArray[0][i];
                int caseCount = Integer.parseInt(datasetArray[1][i]);
                dataset.addValue(caseCount, series1, testDate);
            }

        }




    return dataset;
    }

    // returns a 2D array where the first column is dates and the second column is the case count for these dates
    public static ResultSet getDataset(String[] dates) throws SQLException {
        Connection c = dbConnect();
        PreparedStatement cases = c.prepareStatement("CALL get_case_count_between_dates('" + dates[1] + "','" + dates[0] + "');", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
        ResultSet casesRS = null;



        try
        {
            casesRS = cases.executeQuery();
        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception (ChartScreenLoader.getDataset) Error Code: " + e.getMessage());
        }



        // returns arraylist of test_dates oldest to newest
        return casesRS;
    }

    public static void returnBtnClicked(ChartScreen cs, int agentID) throws SQLException {
        cs.close();
        AnalystHomepageLoader.loadScreen(agentID);
    }

    public static void saveBtnClicked(ChartScreen cs, int agentID, JFreeChart lineChart, ChartPanel chartPanel) throws IOException {

        saveChart(lineChart,chartPanel);

        cs.close();
        String msg = "Successfully saved chart!";
        int returnTo = 4;
        drawMessage(returnTo,msg,agentID);

    }

    public static void saveChart (JFreeChart lineChart, ChartPanel chartPanel)
    {
        try
        {

            ChartUtils.saveChartAsPNG(new File("chart.png"), lineChart,chartPanel.getWidth(), chartPanel.getHeight());
        }
        catch (IOException e)
        {
            System.out.println("I/O Exception (Chart Screen Loader.saveBtnClicked) Error Code: " + e.getMessage());
        }
    }


}
