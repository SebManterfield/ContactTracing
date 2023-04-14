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
        String[] period = {"n", "n", "n"};
        ah.draw(ah, period, caseNumArray, agentID , -1, -1);

    }
    public static void loadScreen(int agentID, String[] period, int cases, int increase) throws SQLException {
        int[] caseNumArray = getCaseNumbers();
        AnalystHomepageScreen ah = new AnalystHomepageScreen();
        ah.draw(ah,period, caseNumArray, agentID, cases,increase);

    }
    public static void submitAnalysisBtnClicked(AnalystHomepageScreen ahs, String[] period, int agentID) throws SQLException {


        boolean fieldsValid = validateAnalysisFields(ahs,period, agentID);

       if (!fieldsValid)
       {
           ahs.close();
           String msg = "Invalid entry in Period Text Fields - must be int";
           drawMessage(ahs.getScreenID(), msg, agentID);
       }
       else {

           String startDate = java.time.LocalDate.now().toString();

           String[] dates = computePeriod(period, startDate);

           int cases = calculateCases(dates);


           int increase = calculatePercentageIncrease(dates, period);
           ahs.close();


           loadScreen(agentID, period, cases, increase);
       }
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


    private static int calculatePercentageIncrease(String[] dates, String period[]) throws SQLException {

        //take the start date from the dates passed in
        String startDate = dates[1];


        // get the dates from the previous period
        String[] newDates = computePeriod(period,startDate);


        float finalValue = calculateCases(dates);
        float startingValue = calculateCases(newDates);



        //handles divide by 0 errors
        if (startingValue == 0)
            return 0;

        else {
            return (int)((((finalValue - startingValue) / (startingValue)) * 100));
        }


    }

    // compute the start and end dates of a given period
    public static String[] computePeriod(String[] periodArray, String startDateStr)
    {
        // define variables
        String [] dates = new String[2];
        int periodDays = 0;
        int periodMonths = 0;
        int periodYears = 0;


        // format the start date string as a localdate so calculation can be performed on it
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr,formatter);

        // convert the period strings to integers (these are already validated)
        try
        {
            periodDays =  Integer.parseInt(periodArray[0]);
            periodMonths =  Integer.parseInt(periodArray[1]);
            periodYears =  Integer.parseInt(periodArray[2]);
        }
        catch (Exception e)
        {
            System.out.println("Integer parse Exception (AnalystHomepageLoader.computePeriod) Error code: " + e.getMessage());
        }

        // subtract period from the start date
        LocalDate prevDate = startDate;
        prevDate = prevDate.minusDays(periodDays);
        prevDate = prevDate.minusMonths(periodMonths);
        prevDate = prevDate.minusYears(periodYears);

        String prevDateStr = prevDate.toString();
        //add dates to array
        dates[0] = startDateStr;
        dates[1] = prevDateStr;

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

    public static boolean validateAnalysisFields(AnalystHomepageScreen ahs, String period[], int agentID)
    {

            // check an integer is entered for period
            try {
                Integer.parseInt(period[0]);
            } catch (Exception e) {
                return false;

            }

            try{
                Integer.parseInt(period[1]);
            }
            catch (Exception e) {
                return false;

            }

        try{
            Integer.parseInt(period[2]);
        }
        catch (Exception e) {
            return false;

        }
        return true;
    }

    }


