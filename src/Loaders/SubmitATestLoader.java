package Loaders;


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
       boolean emptyFields = validateEmptyFields(patientInfo);
       if (!emptyFields)
       {
           String msg = ("You must fill in all fields!");
           sts.close();
           drawMessage(sts.getScreenID(),msg);
           return;
       }

        boolean validPostcode = validatePostcodeField(patientInfo);
       if (!validPostcode)
       {
           sts.close();
           String msg = "Invalid Postcode entered!";
           drawMessage(sts.getScreenID(),msg);
           return;
       }

       boolean validMobile = validateMobileFields(patientInfo);
       if (!validMobile)
       { String msg = "The format of the mobile numbers is incorrect";
           sts.close();
           drawMessage(sts.getScreenID(),msg);
           return;
      }

        SimpleDateFormat userDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        boolean validDate = validateDate(userDate,myFormat,patientInfo);

        if (!validDate)
            {
                String msg = "Incorrect date format entered!";
                sts.close();
                drawMessage(sts.getScreenID(),msg);
                return;
            }


       if ((validMobile) && (validPostcode) && (emptyFields) && (validDate)) {
           //reformat the date and update patient info

           patientInfo = reformatDate(patientInfo, userDate,myFormat);

           // if validation is successful attempt to update database


           submitTest(patientInfo);
           //inform the user that the test submission was a success
           testSuccess(sts);
       }
    }


    public static void testSuccess(SubmitATestScreen sts)
    {
        String msg = "Test successfully submitted!";
        int returnTo = 0;
        sts.close();
        drawMessage(returnTo,msg);

    }

    // validate that the postcode area is real
    public static boolean validatePostcodeField(ArrayList<String> patientInfo) throws SQLException {

        //create a connection and get the users entered postcode
        Connection c = dbConnect();
        String postcodeArea = patientInfo.get(2);

        PreparedStatement checkPostcode = c.prepareStatement("SELECT area_postcode FROM area WHERE area_postcode = '" + postcodeArea+"';");
        ResultSet rs = null;

        try
        {
            rs = checkPostcode.executeQuery();
        }
        catch (SQLException e)
        {
            System.out.println("SQL execution error (SubmitATestLoader) Error Code: " + e.getMessage());
        }
        //check to see if result set is empty i.e incorrect postcode area
        if(!rs.next())
        {
            return false;
        }
      // assume otherwise the postcode area is correct and do nothing
        c.close();
        return true;
    }

    // validate the submitted fields and reformat the date
    public static boolean validateEmptyFields( ArrayList<String> patientInfo)
    {
        //check if any are empty
        for(String temp: patientInfo)
        {
            if(temp.length() == 0)
            {
                return false;


            }
        }

        return true;
    }
    //check the submitted mobile fields are valid mobile numbers
    public static boolean validateMobileFields(ArrayList<String> patientInfo)
    {

        String mobile1 = patientInfo.get(4);
        String mobile2 = patientInfo.get(6);
        String mobile3 = patientInfo.get(8);


        //check the length of mobile numbers is correct
        if((!(mobile1.length() == 11)) || (!(mobile2.length() == 11))||(!(mobile3.length() == 11)))
        {
           return false;
        }
    return true;
    }
    // this reformats the date string into a date which can be accepted by the database
    public static ArrayList<String> reformatDate(ArrayList<String> patientInfo, SimpleDateFormat userDate, SimpleDateFormat myFormat)
    {
        // declare variables for the existing date and new date
        String date = patientInfo.get(1);
        String formattedDate = null;


        try
        {
            formattedDate = myFormat.format(userDate.parse(date));
        } catch (ParseException e) {
            System.out.println("Date Conversion error (SubmitATestLoader). Error Code:" + e.getMessage());
        }

        patientInfo.set(1,formattedDate);

        return patientInfo;
    }

public static boolean  validateDate (SimpleDateFormat userDate, SimpleDateFormat myFormat,ArrayList<String> patientInfo)
{
    String date = patientInfo.get(1);
    try
    {
        date = myFormat.format(userDate.parse(date));
    } catch (ParseException e) {
        System.out.println("Date Conversion error (SubmitATestLoader). Error Code:" + e.getMessage());
        return false;
    }
    return true;
}



    // this will submit a test to the test table and close contacts table
    public static void submitTest(ArrayList<String> patientInfo) throws SQLException {


        Connection c = dbConnect();

        PreparedStatement atomic_insert = c.prepareStatement("CALL atomic_insert('" + patientInfo.get(1)+"'," + patientInfo.get(3)+",'"+patientInfo.get(2)+"','"+patientInfo.get(5)+"','"+patientInfo.get(7)+"','"+patientInfo.get(6)+"','"+patientInfo.get(8)+"');");


        try
        {

            atomic_insert.executeQuery();
        }
        catch(SQLException e)
        {
            System.out.println("SQL Error 1 (SubmitATestLoader) Error Code: " + e.getMessage());
        }



    }




}
