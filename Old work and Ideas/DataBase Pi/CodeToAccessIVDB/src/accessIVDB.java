import java.sql.*;

/**
 * This code is to access the database located in the Raspberry Pi
 * It creates a local connection, database driver 
 *  
 * Original Author Alvin Alexander, http://alvinalexander.com
 * 
 * Modified for Invisible Drums, a 3rd-Year Project
 * 
 * Author: Mohammed Tanvir Hossain
 * 
 * Version: 1.01, 
 * Date: October 26th, 2018
 */
public class accessIVDB
{

  public static void main (String[] args)
  {
    try
    {
      // create our MYSQL database connection
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/ivdb";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
      
      // our SQL SELECT query. 
      // Showing the entire table				//Update on 26th October, 2018
      String query = "SELECT * FROM tones";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      /* Things need to improve
       * 
       * 1. At this moment it's calling both the sound files
       * 2. We need to change it to one sound at a time, pack into a package and send it to Processor pi
       * 3. Access the database as an Array
       * 
       */
     
      while (rs.next())
      {
        int id = rs.getInt("id");
        String checkReturn = rs.getString("checkingReturn");
        String toneLink = rs.getString("linktoTone");
        //new playSound(voice).start();					//Testing if the link works as a file
        
        
        // print the results
        System.out.format("%s, %s, %s \n", id, checkReturn, toneLink);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}