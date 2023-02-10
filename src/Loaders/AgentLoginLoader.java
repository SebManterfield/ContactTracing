package Loaders;

import GUI.AgentLoginScreen;

import java.sql.*;

public class AgentLoginLoader extends Loader {
    

    public static void loadScreen()
    {
        AgentLoginScreen a = new AgentLoginScreen();
        a.draw(a);
    }

    public static void loginBtnClicked(AgentLoginScreen as, String username, char[] password) throws SQLException {
        Connection c = dbConnect();
        boolean loginValid = false;
        loginValid = checkLoginDetails(c,username, password);


    }


    public static boolean checkLoginDetails(Connection c, String username, char[] password) throws SQLException {

        Statement s = c.createStatement();
        ResultSet rs = null;
        try {
            rs = s.executeQuery("CALL username_password_check('" + username + "','" + password.toString() + "'");
        }
        catch(SQLException e)
        {
            System.out.println("Query Execution failure (AgentLoginLoader)");
            
        }

        if (!rs.first())
        {
            return false;
        }
        else
        {
            if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
            {
            return true;
            }

        }
        return false;


    }
}


