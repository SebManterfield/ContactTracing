package Loaders;

import GUI.AgentLoginScreen;
import GUI.AnalystHomepageScreen;
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



        // if the login is a success close the AgentLoginScreen and open a  new screen
        if(loginValid)
        {
            // get the users permission level i.e type of user
            int permissionLevel = checkPermissions(c,as,username);
            c.close();
            switch(permissionLevel)
            {
                case 0:
                    as.close();
                    TracerHomepageScreen t = new TracerHomepageScreen();
                    t.draw(t);

                    break;
                case 1:
                    as.close();
                    AnalystHomepageScreen a = new AnalystHomepageScreen();
                    a.draw(a);

                    break;

            }

        }
        else
            {
                String msg = "Username or password incorrect";
                as.close();
                drawMessage(as.getScreenID(),msg);
            }


    }
    //checks the permission level of the user
    public static int checkPermissions(Connection c, AgentLoginScreen as, String username) throws SQLException {

        PreparedStatement permissions = c.prepareStatement("SELECT user_permission_level FROM _user WHERE username = '" + username + "';");
        ResultSet userPermissions = null;
        int permissionLevel = 0;

        //get the permission level of the user
        try
        {
            userPermissions = permissions.executeQuery();
        }
        catch (SQLException e)
        {
            System.out.println("SQLExecution error (AgentLoginLoader) Error Code:" + e.getMessage());

        }

        //check for empty result set
        if(!userPermissions.next())
        {
            System.out.println("No user with this username exists (AgentLoginLoader)");
        }
        else
        {

            permissionLevel = userPermissions.getInt("user_permission_level");
        }
        
        return permissionLevel;




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



