/**
 * Project Invisible Drums, SYSC 3010 Monday Group 7
 * @author Mohammed Tanvir Hossain
 * @Version Final, December 3rd, 2018
 *
 */


import java.io.File;
import java.io.FilenameFilter;
import java.sql.*;



/*
 * This is a  Public Class DB (short form for Database)
 * 1. It has 4 methods. These methods are used by the android application to
 * add, store, delete or set music tones inside the database.
 * 2. DB has JDBC connection method in it. For every method it will connect to jdbc using the jdbc connector.
 * 3. Name of the database is 'idrums'
 */

public class DB {
    
	//Here name of the MYSQL database is 'idrums'
    static String myDatabase = "jdbc:mysql://localhost:3306/idrums"; 
    int ID =0;
    
   
    public void viewAllTone(String myDatabase) throws SQLException
    {   
        
        Connection conn = DriverManager.getConnection(myDatabase, "root3", "1234"); 
        String query = "SELECT * FROM tones";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
    
        while (rs.next())
          {
            int id = rs.getInt("id");
            String checkReturn = rs.getString("Name");
            String toneLink = rs.getString("LinktoTone");
            Blob f = rs.getBlob(4);
            System.out.format("%s, %s, %s, %s\n", id, checkReturn, toneLink, f);
          }
        
   
        st.close();
        conn.close();
    }

    
    /*
     * The method addTone adds a drum sample tone inside the database
     * @param tondeID, name of the tone and the path of the tone
     * @return void
     */
    
    public void addTone(int toneid, String tonename, String tonepath )
    {
        Connection conn = null;
        Statement st = null;
        
        DB id = new DB();

        
        try{
              
              conn = DriverManager.getConnection(myDatabase, "root3", "1234");
              System.out.println("Connected database successfully...");
              
              //STEP: Execute a query
              System.out.println("Creating statement...");
               st = conn.createStatement();
              String sql =       
              "INSERT INTO `idrums`.`tones` (`ID`, `Name`, `LinktoTone`, `BinaryofTone`)" +
                                            "VALUES ('"+toneid+"', '"+tonename+"', '"+tonepath+"', '"+tonepath+"')";
            
              st.executeUpdate(sql);

         }
           catch (SQLException se) {se.printStackTrace(); }     //Handle errors for JDBC
           catch (Exception e) {  e.printStackTrace(); }        //Handle errors for Class.forName
        finally { //finally block used to close resources
              try
              {
                 if (st !=null)
                    {conn.close();}
              }
              catch(SQLException se) {}// do nothing
              try
              {
                 if(conn!=null)
                    conn.close();
              }
              catch(SQLException se) {  se.printStackTrace(); }//end finally try
            //end try
           System.out.println("Goodbye!");
        } // end of finally try
    } //end of addTone()
    
    
    /*
     * The method deleteTone deletes a drum sample tone inside the database
     * @param 
     * @return 
     */
    
    public void deleteTone(String deleteName)
    {
           
           Connection conn = null;
           Statement stmt = null;
           try{
              
              //STEP 2: Register JDBC driver

              //STEP 3: Open a connection
              System.out.println("Connecting to a selected database...");
              
              conn = DriverManager.getConnection(myDatabase, "root3", "1234");
              
              System.out.println("Connected database successfully...");
              
              //STEP 4: Execute a query
              System.out.println("Creating statement...");
              stmt = conn.createStatement();

              
              
              String sql = "DELETE FROM tones WHERE Name = '"+deleteName+"'";
              stmt.executeUpdate(sql);

              // Now you can extract all the records
              // to see the remaining records

           }catch(SQLException se){
              //Handle errors for JDBC
              se.printStackTrace();
           }catch(Exception e){
              //Handle errors for Class.forName
              e.printStackTrace();
           }finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    conn.close();
              }catch(SQLException se){
              }// do nothing
              try{
                 if(conn!=null)
                    conn.close();
              }catch(SQLException se){
                 se.printStackTrace();
              }//end finally try
           }//end try
           System.out.println("Goodbye!");
        
    } //end of deleteTone
    
    
    /*
     * Method viewSpecific Tone prints out any desired tone from the entries of database
     */
    
    public void viewspecificTone(int id) throws SQLException
    {   
        
        Connection conn = DriverManager.getConnection(myDatabase, "root3", "1234"); 
        String query = "SELECT * FROM tones where ID = '"+id+"'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            int number = rs.getInt("id");
            String checkname= rs.getString("Name");
            String toneLink = rs.getString("LinktoTone");
            Blob f = rs.getBlob(4);
            System.out.format("%s, %s, %s \n", number, checkname, toneLink);
        }
            rs.close();
        

        st.close();
        conn.close();
    }
    
    /*
     * Method getIdfromDB() returns the id for latest entry from the database
     */

    
    public int getIdfromDB() throws SQLException
    {
        Connection conn = DriverManager.getConnection(myDatabase, "root3", "1234"); 
		String query = "SELECT * FROM tones";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		int id =0;
	
		while (rs.next())
	      {
	       id = rs.getInt("id");
	        
	      }
		

		st.close();
		conn.close();
		return id;
    }
    

    

}

