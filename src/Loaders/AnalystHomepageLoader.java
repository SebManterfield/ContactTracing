package Loaders;

import GUI.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.Math.abs;


public class AnalystHomepageLoader extends Loader {

    public static void loadScreen(int agentID) throws SQLException {
        int[] caseNumArray = getCaseNumbers();
        AnalystHomepageScreen ah = new AnalystHomepageScreen();
        ah.draw(ah, "n", caseNumArray, agentID , -1, -1);

    }
    public static void loadScreen(int agentID, String period, int cases, int increase) throws SQLException {
        int[] caseNumArray = getCaseNumbers();
        AnalystHomepageScreen ah = new AnalystHomepageScreen();
        ah.draw(ah,period, caseNumArray, agentID, cases,increase);

    }
    public static void submitAnalysisBtnClicked(AnalystHomepageScreen ahs,int intervalIndex, String period, int agentID) throws SQLException {


        validateAnalysisFields(ahs,intervalIndex,period, agentID);

        String startDate = java.time.LocalDate.now().toString();

        String[] dates = computePeriod(intervalIndex,period,startDate);

        int cases =  calculateCases(dates);

        int increase = calculatePercentageIncrease(dates,intervalIndex,period);
        ahs.close();

        switch (intervalIndex) {
            case 1 -> period = (period + " Days");
            case 2 -> period = (period + " Months");
            case 3 -> period = (period + " Years");
        }


        loadScreen(agentID,period,cases,increase);

    }


    private static int[] getCaseNumbers() throws SQLException {

        Connection c = dbConnect();
        PreparedStatement getTotalCases = c.prepareStatement("SELECT COUNT(*) FROM test");
        PreparedStatement getTotalReviewedCases = c.prepareStatement("SELECT COUNT(*) FROM test WHERE test_reviewed = 1");
        ResultSet totalCases = null;
        ResultSet reviewedCases = null;

        int totalCaseNum = 0;
        int totalReviewedCaseNum = 0;
        int [] caseNumArray = new int[2];
        try
        {
            totalCases = getTotalCases.executeQuery();
            reviewedCases = getTotalReviewedCases.executeQuery();

        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception (AnalystHomepageLoader.getCaseNumbers())" + e.getMessage());
        }

        if (!totalCases.next())
            System.out.println("Result set empty");

        else
        {
            totalCaseNum = totalCases.getInt("COUNT(*)");
        }

        if (!reviewedCases.next())
            System.out.println("Result set empty");

        else
        {
            totalReviewedCaseNum = reviewedCases.getInt("COUNT(*)");
        }

        caseNumArray[0] = totalCaseNum;
        caseNumArray[1] = totalReviewedCaseNum;
        return caseNumArray;

    }


    private static int calculatePercentageIncrease(String[] dates, int intervalIndex, String period) throws SQLException {

        //take the start date from the dates passed in
        String startDate = dates[1];


        // get the dates from the previous period
        String[] newDates = computePeriod(intervalIndex,period,startDate);


        int finalValue = calculateCases(dates);
        int startingValue = calculateCases(newDates);



        //handles divide by 0 errors
        if (startingValue == 0)
            return 0;

        else {

            return ((finalValue - startingValue) / abs(startingValue)) * 100;
        }


    }

    // compute the start and end dates of a given period
    public static String[] computePeriod(int intervalIndex, String periodStr, String startDateStr)
    { //Interval Indices 1 = Days, 2 = Months, 3 = Years

        String [] dates = new String[2];
        int period = 0;
        String prevDateStr;

        // format the start date string as a localdate so calculation can be performed on it
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr,formatter);


        // convert the period to an integer
        try
        {
           period =  Integer.parseInt(periodStr);
        }
        catch (Exception e)
        {
            System.out.println("Integer parse Exception (AnalystHomepageLoader.computePeriod) Error code: " + e.getMessage());
        }

        // switch statement to decide how to calculate previous dates

        LocalDate prevDate = switch (intervalIndex) {
            case 1 -> startDate.minusDays(period);
            case 2 -> startDate.minusMonths(period);
            case 3 -> startDate.minusYears(period);
            default -> null;
        };


        prevDateStr = prevDate.toString();
        //add dates to array
        dates[0] = startDateStr;
        dates [1] = prevDateStr;


        return dates;
    }

    private static int calculateCases(String [] dates) throws SQLException {
        Connection c = dbConnect();
        PreparedStatement getCount = c.prepareStatement("SELECT COUNT(*) FROM test WHERE test_date BETWEEN '" + dates[1] + "' AND'" + dates[0] + "';");
        ResultSet dateRS = null;
        int caseCount = 0;

        try
        {
        dateRS = getCount.executeQuery();
        }
        catch (SQLException e)
        {
            System.out.println("SQL Exception (AnalystHomepageLoader.calculateCases) Error Code: " + e.getMessage());
        }

        if(!dateRS.next())
        {
            System.out.println("Empty Result Set!");
        }
        else
        {
            caseCount = dateRS.getInt("COUNT(*)");
        }
        c.close();
        return caseCount;

    }

    public static void validateAnalysisFields(AnalystHomepageScreen ahs, int intervalIndex, String period, int agentID)
    {
        // check the interval is not left empty
        if (intervalIndex == 0)
        {

            ahs.close();
            String msg = "The interval period is not valid!";
            drawMessage(ahs.getScreenID(),msg,agentID);
        }


        else {
            // check an integer is entered for period
            try {
                Integer.parseInt(period);
            } catch (Exception e) {
                ahs.close();
                String msg = "The period is not valid!";
                drawMessage(ahs.getScreenID(),msg,agentID);
            }
        }
    }

}
