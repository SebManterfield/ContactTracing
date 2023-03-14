package Loaders;

import GUI.Popup;
import GUI.SubmitATestScreen;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SubmitATestLoader extends Loader{
 
    

    public static void loadScreen()
    {
        SubmitATestScreen sts = new SubmitATestScreen();
        sts.draw(sts);
    }

    public static void submitBtnClicked(SubmitATestScreen sts, ArrayList<String> patientInfo) throws SQLException {


        // validate all the fields
        validateEmptyFields(sts,patientInfo);
        validatePostcodeField(sts, patientInfo);
        validateMobileFields(sts, patientInfo);

        patientInfo = reformatDate(patientInfo,sts);

        // if validation is successful attempt to update database
        submitTest(patientInfo);

    }

    // validate that the postcode area is real
    public static void validatePostcodeField(SubmitATestScreen sts, ArrayList<String> patientInfo)
    {




    }

    // validate the submitted fields and reformat the date
    public static void validateEmptyFields(SubmitATestScreen sts, ArrayList<String> patientInfo)
    {
        //check if any are empty
        for(String temp: patientInfo)
        {
            if(temp.length() == 0)
            {
                String msg = ("You must fill in all fields!");
                sts.close();
                drawMessage(sts.getScreenID(),msg);

            }
        }


    }
    //check the submitted mobile fields are valid mobile numbers
    public static void validateMobileFields(SubmitATestScreen sts, ArrayList<String> patientInfo)
    {

        String mobile1 = patientInfo.get(4);
        String mobile2 = patientInfo.get(6);
        String mobile3 = patientInfo.get(8);


        //check the length of mobile numbers is correct
        if((!(mobile1.length() == 11)) || (!(mobile2.length() == 11))||(!(mobile3.length() == 11)))
        {
            String msg = "The format of the mobile numbers is incorrect";
            sts.close();
            drawMessage(sts.getScreenID(),msg);
        }

    }
    // this reformats the date string into a date which can be accepted by the database
    public static ArrayList<String> reformatDate(ArrayList<String> patientInfo,SubmitATestScreen sts)
    {
        // declare variables for the existing date and new date
        String date = patientInfo.get(1);
        String formattedDate = null;

        // set the format that is expected and the format that is needed
        SimpleDateFormat userDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try
        {
            formattedDate = myFormat.format(userDate.parse(date));
        } catch (ParseException e) {
            System.out.println("Date Conversion error (SubmitATestLoader). Error Code:" + e.getMessage());
            String msg = "Incorrect date format entered!";
            sts.close();
            drawMessage(sts.getScreenID(),msg);
        }

        patientInfo.set(1,formattedDate);

        return patientInfo;
    }
    // this will submit a test to the test table and close contacts table
    public static void submitTest(ArrayList<String> patientInfo) throws SQLException {
        System.out.println("In submitATest method");

        Connection c = dbConnect();
        //prepare sql statements. Due to the nature of the database tables we need to
        // submit to the close contacts table first
        PreparedStatement submitCloseContacts1 = c.prepareStatement("CALL cc_table_insert('" + patientInfo.get(5)+"','"+patientInfo.get(6)+"');");
        PreparedStatement submitCloseContacts2 = c.prepareStatement("CALL cc_table_insert('" + patientInfo.get(7)+"','"+patientInfo.get(8)+"');");

        // the close contact IDs auto_increment so we can now select the top 2 close contact IDs to get the IDs of the close contacts
        PreparedStatement getCCid = c.prepareStatement("SELECT cc_id FROM close_contacts ORDER by cc_id DESC limit 2;");

        String ccid1 = null;
        String ccid2 = null;
        ResultSet ccids = null;

        try
        {
            System.out.println("in first try");
            submitCloseContacts1.executeQuery();
            submitCloseContacts2.executeQuery();
            ccids = getCCid.executeQuery();
        }
        catch(SQLException e)
        {
            System.out.println("SQL Error 1 (SubmitATestLoader) Error Code: " + e.getMessage());
        }
        System.out.println("out first try");

        if (!ccids.next())
        {

            SQLException e = new SQLException();
            System.out.println("Close contacts result set empty (SubmitATestLoader)");
            throw e;

        }
        else {

            ccid1 = ccids.getString("cc_id");

            ccids.next();
            ccid2 = ccids.getString("cc_id");

        }

        System.out.println("out if-else");
        try
        {
            System.out.println("in second try");
            PreparedStatement submitTest = c.prepareStatement("CALL test_table_insert ('" + patientInfo.get(1)+"'," + patientInfo.get(3)+","+1+","+1+","+ccid1+","+ccid2+");");
            submitTest.executeQuery();
        }
        catch(SQLException e)
        {
            System.out.println("SQL Error 2 (SubmitATestLoader) Error Code: " + e.getMessage());
        }
        System.out.println("successful submission");


    }




}
