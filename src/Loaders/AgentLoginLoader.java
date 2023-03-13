package Loaders;

import GUI.AgentLoginScreen;
import GUI.TracerHomepageScreen;

import java.sql.*;

public class AgentLoginLoader extends Loader {

    public static void loadScreen()
    {
        AgentLoginScreen a = new AgentLoginScreen();
        a.draw(a);
    }

    public static void loginBtnClicked(AgentLoginScreen as, String username, String password) throws SQLException {

        Connection c = dbConnect();

        boolean loginValid = checkLoginDetails(c,username, password);

        if(loginValid)
        {

            as.close();
            TracerHomepageScreen t = new TracerHomepageScreen();
            t.draw(t);
        }
        else
            {
                String msg = "Username or password incorrect";
                as.close();
                drawMessage(as.getScreenID(),msg);
            }


    }

    // checks login details against the database - takes the connection specified by dbConnect() method
    public static boolean checkLoginDetails(Connection c, String username, String password) throws SQLException {

        // create statement and return variables
        PreparedStatement usernameCheck = c.prepareStatement("CALL username_password_check('" + username + "','" + password + "');");
        ResultSet rs = null;

        //try to call the login check procedure
        try {

            rs = usernameCheck.executeQuery();
        }
        catch(SQLException e)
        {
            System.out.println("Query Execution failure (AgentLoginLoader). Error Code: " + e.getMessage());
            
        }

        // returns false if result set is empty, i.e no match
        if (!rs.next())
        {

            return false;
        }
        else
        {
            rs.next();
            if(username.equals(rs.getString("username")) && password.equals(rs.getString("user_password")))
            {
                System.out.println("password success");

                return true;
            }

        }
        return false;


    }
    public static void validateLoginFields(String username, String password, AgentLoginScreen as)
    {
        // simple validation
        if (username.isEmpty() || password.isEmpty())
        {
            String msg = "The username or password field is empty!";
            as.close();
            drawMessage(as.getScreenID(),msg);

        }
    }


}



