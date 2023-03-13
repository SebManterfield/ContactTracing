package Loaders;

import GUI.SubmitATestScreen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SubmitATestLoader extends Loader{
 
    

    public static void loadScreen()
    {
        SubmitATestScreen sts = new SubmitATestScreen();
        sts.draw(sts);
    }

    public static void submitBtnClicked(SubmitATestScreen sts, ArrayList<String> patientInfo)
    {

        validateEmptyFields(sts,patientInfo);
        validateMobileFields(sts, patientInfo);
        patientInfo = reformatDate(patientInfo);
        submitTest(patientInfo);

    }
    // validate the submitted fields and reformat the date
    public static void validateEmptyFields(SubmitATestScreen sts, ArrayList<String> patientInfo)
    {
        //check if any are empty
        for(String temp: patientInfo)
        {
            if(temp.length() == 0)
            {
                String message = ("You must fill in all fields!");
                sts.close();
                drawMessage(sts.getScreenID(),message);

            }
        }


    }
    //check the submitted mobile fields are valid mobile numbers
    public static void validateMobileFields(SubmitATestScreen sts, ArrayList<String> patientInfo)
    {

        String mobile1 = patientInfo.get(3);
        String mobile2 = patientInfo.get(5);
        String mobile3 = patientInfo.get(7);


        //check the length of mobile numbers is correct
        if((!(mobile1.length() == 11)) || (!(mobile2.length() == 11))||(!(mobile3.length() == 11)))
        {

        }

    }

    public static ArrayList<String> reformatDate(ArrayList<String> patientInfo)
    {
        String date = patientInfo.get(2);
        String formattedDate = null;

        SimpleDateFormat userDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            formattedDate = myFormat.format(userDate.parse(date));
        } catch (ParseException e) {
            System.out.println("Date Conversion error (SubmitATestLoader). Error Code:" + e.getMessage());
        }

        patientInfo.set(3,formattedDate);
        return patientInfo;
    }

    public static void submitTest(ArrayList<String> patientInfo)
    {

    }


}
