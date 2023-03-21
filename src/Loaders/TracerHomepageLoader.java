package Loaders;

import GUI.ReviewATestScreen;
import GUI.TracerHomepageScreen;
import Other.Test;

import java.sql.*;
import java.util.ArrayList;

public class TracerHomepageLoader extends Loader {


    public static void loadScreen(int agentID) throws SQLException {
        ArrayList<Test> testArrayList = getTests(agentID);
        TracerHomepageScreen ts = new TracerHomepageScreen();
        ts.draw(ts, agentID, testArrayList);
    }

    public static ArrayList<Test> getTests(int agentID) throws SQLException {
      //use the stored procedure to get the top 5 tests
        Connection c = dbConnect();
        PreparedStatement getTests = c.prepareStatement("CALL get_all_tests(" + agentID + ");");
        ResultSet testRS = null;
        ArrayList<Test> testArrayList = new ArrayList<>();

        try
        {
            testRS = getTests.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println("SQL exception (TracerHomepageLoader) Error Code: "+ e.getMessage() );
        }


        if (!testRS.next())
        {
            System.out.println("Test result set empty");
        }
        else
        {
            for (int i = 0; i <5 ; i++)
            {
                Test temp = new Test();
                temp.setTestID(testRS.getInt("test_id"));
                System.out.println(temp.getTestID());
                temp.setTestDate(testRS.getString("test_date"));
                temp.setTestLocation(testRS.getString("area_name"));
                testArrayList.add(temp);
                testRS.next();
            }



        }
        return testArrayList;
    }


}
