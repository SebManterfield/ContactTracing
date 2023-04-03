package Loaders;

import GUI.*;
import org.jfree.chart.*;
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
        return lineChart;

    }

    public static DefaultCategoryDataset calculateDataset(int intervalIndex, String period) throws SQLException {

        String startDate = java.time.LocalDate.now().toString();
        // retrieves start and end dates for graphs

        String[] dates = AnalystHomepageLoader.computePeriod(intervalIndex,period,startDate);

        // this simply retrieves all dates for which cases have been submitted between the 2 given dates
        ArrayList<String> datasetArray = getDataset(dates);



        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "Cases";

        // create a dataset out of all values in the array
        for(int i =0; i < datasetArray.size();i++)
        {
            int caseNum = 0;
            int j=i;
            // check to see if the next index is smaller than the size of the arraylist -1
            // i.e not on the last index

            if ((datasetArray.size()-1) > i+1) {
                //if there are multiple cases with the same date the case numbers can be incremented
                System.out.println("in if");


            // while the current date in arraylist is the same as the next date
            while (datasetArray.get(j).equals(datasetArray.get(j + 1))) {
                // increment case numbers for this day
                caseNum+= 1;
                // move onto next date in arraylist
                j++;
                // also increment i to stop repeated values
                i++;
                System.out.println("in while");
            }


        }
            // if the value of j hasn't been incremented then add to caseNum
            // i.e there are not multiple dates which are the same
            if (j == i)
            caseNum+=1;

            //finally add the values to the dataset
            dataset.addValue(caseNum, series1, datasetArray.get(i));
            System.out.println("date: " + datasetArray.get(i) + "\n case numbers: " + caseNum);
        }
    return dataset;
    }

    public static ArrayList<String> getDataset(String[] dates) throws SQLException {
        Connection c = dbConnect();
        PreparedStatement cases = c.prepareStatement("SELECT test_date FROM test WHERE test_date BETWEEN '" + dates[1] + "' AND '" + dates[0] + "' ORDER BY test_date ASC;");
        ResultSet casesRS = null;
        ArrayList<String> datasetArray = new ArrayList<>();


        try
        {
            casesRS = cases.executeQuery();
        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception (ChartScreenLoader.getDataset) Error Code: " + e.getMessage());
        }

        //null check
        if (!casesRS.next())
            System.out.println("Empty Dataset!");
        else
        {
            while(casesRS.next())
            {
                datasetArray.add(casesRS.getString("test_date"));
                casesRS.next();
            }

        }
        // returns arraylist of test_dates oldest to newest
        return datasetArray;
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
