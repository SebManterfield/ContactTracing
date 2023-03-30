package Loaders;

import GUI.AnalystHomepageScreen;
import GUI.ChartScreen;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.*;
import java.util.ArrayList;

import static Loaders.Loader.dbConnect;

public class ChartScreenLoader {



    public static void loadScreen(AnalystHomepageScreen ahs, JFreeChart lineChart, int agentID)
    {
        ahs.close();
        ChartScreen cs = new ChartScreen();
        cs.draw(lineChart, agentID);

    }

    public static void chartBtnClicked(AnalystHomepageScreen ahs, int agentID,int intervalIndex, String period) throws SQLException {

        AnalystHomepageLoader.validateAnalysisFields(ahs,intervalIndex,period, agentID);


        DefaultCategoryDataset dataset = calculateDataset(intervalIndex,period);

        System.out.println("dataset calculated");

        JFreeChart lineChart = createLineChart("Dates", dataset);
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


        ArrayList<String> datasetArray = getDataset(dates);



        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String series1 = "Cases";

        // create a dataset out of all values in the array
        for(int i =0; i < datasetArray.size();i++)
        {
            int caseNum = 0;
            int j=i;
          // check to see if the next index is greater than the size of the arraylist
            if (datasetArray.size()-1>i+1) {
                //if there are multiple cases with the same date the case numbers can be incremented
            while (datasetArray.get(j).equals(datasetArray.get(j + 1))) {
                caseNum++;
                j++;
            }
        }
            //finally add the values to the dataset
            dataset.addValue(caseNum, series1, datasetArray.get(i));
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


}
