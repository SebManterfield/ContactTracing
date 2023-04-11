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

    public static void chartBtnClicked(AnalystHomepageScreen ahs, int agentID, String[] period) throws SQLException {

        AnalystHomepageLoader.validateAnalysisFields(ahs,period,agentID);


        DefaultCategoryDataset dataset = calculateDataset(period);

        System.out.println("dataset calculated");

        String interval = "";

        JFreeChart lineChart = createLineChart("Cases over the selected period ", dataset);
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
    //get the case count between 2 given dates in a 2D array then add values to a dataset
    public static DefaultCategoryDataset calculateDataset(String[] period) throws SQLException {

        String startDate = java.time.LocalDate.now().toString();
        // retrieves start and end dates for period
        String[] dates = AnalystHomepageLoader.computePeriod(period,startDate);
        // retrieves dates and case numbers for period
        ResultSet casesRS = getDataset(dates);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "Cases";
        //null check
        if (!casesRS.next())
            System.out.println("Empty Dataset!");
        else
        {
            casesRS.beforeFirst();
            while(casesRS.next())
            {   //get each test date and case count
                String testDate = casesRS.getString("test_date");
                int caseCount = casesRS.getInt("COUNT(test_date)");
                //add the date and case count to the dataset
                dataset.addValue(caseCount, series1, testDate);
            }

        }

    return dataset;
    }

    // returns a result set of dates and case counts between 2 given dates
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

        // returns result set of cases
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
