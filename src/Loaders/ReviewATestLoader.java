package Loaders;

import GUI.*;
import Other.Test;
import com.sun.source.tree.TryTree;

import java.sql.*;

public class ReviewATestLoader extends Loader {

    public static void loadScreen(int testID) throws SQLException {
        Test test = getTest(testID);
        ReviewATestScreen rs = new ReviewATestScreen();
        rs.draw(rs, test);
    }

    /// query database and get details of the test
    public static Test getTest(int testID) throws SQLException {

        Connection c = dbConnect();
        PreparedStatement getTest = c.prepareStatement("SELECT * FROM test WHERE test_id = " + testID + ";");
        ResultSet testRS = null;

        Test test = new Test();

        int cc_id1 = 0;
        int cc_id2 = 0;
        ResultSet ccRS = null;

        try
        {
            testRS = getTest.executeQuery();
        }
        catch (Exception e)
        {
            System.out.println("SQL Exception (Review a Test Loader) Error Code:" + e.getMessage());
        }

        if(!testRS.next())
        {
            System.out.println("result set empty (Review a test loader)");
        }
        else
        {
            test.setTestDate(testRS.getString("test_date"));
            test.setOutcome(testRS.getString("test_outcome"));
            cc_id1 = testRS.getInt("cc_id1");
            cc_id2 = testRS.getInt("cc_id2");
        }

       PreparedStatement getCCdetails = c.prepareStatement("SELECT * FROM close_contacts WHERE cc_id =  "+cc_id1+" OR cc_id = "+cc_id2+";");

        try
        {
            ccRS = getCCdetails.executeQuery();
        }
        catch (SQLException e )
        {
            System.out.println("SQL Exception (Review a Test Loader) Error Code: " + e.getMessage());
        }



        if(!ccRS.next())
        {
            System.out.println("result set empty (Review a test loader)");
        }
        else
        {
            test.setCc1Name(ccRS.getString("cc_name"));
            test.setCc1Mobile(ccRS.getString("cc_mobile"));
            ccRS.next();
            test.setCc2Name(ccRS.getString("cc_name"));
            test.setCc2Mobile(ccRS.getString("cc_mobile"));
        }


        return test;


    }



}
