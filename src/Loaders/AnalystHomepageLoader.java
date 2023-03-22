package Loaders;

import GUI.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnalystHomepageLoader extends Loader {

    public static void loadScreen(int agentID) throws SQLException {
        int[] caseNumArray = getCaseNumbers();
        AnalystHomepageScreen ah = new AnalystHomepageScreen();
        ah.draw(ah, caseNumArray);
    }

    public static int[] getCaseNumbers() throws SQLException {

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



}
