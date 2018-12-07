import java.io.File;
import java.io.FilenameFilter;
import java.sql.*;




public class DB {
    

    //Point 1 Not sure how it will run Pi
    static String myDatabase = "jdbc:mysql://localhost:3306/idrums"; 
    int ID =0;
    
    /*
    public static void main (String[] args) throws ClassNotFoundException, SQLException
    {
        
        DB idrums = new DB();
        
        
        String toneName = "clap";
        String path = "/home/pi/Desktop/Sound Packs/ blooze.wav";
        
        idrums.addTone(toneid, toneName, path);
        //idrums.deleteTone(toneid);
        idrums.viewAllTone(myDatabase);
        //idrums.viewspecificTone(toneid);
        
        
        
    } */


    
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
        
        //These statements might help closing the communication? Not sure yet. Need to figure it out
        st.close();
        conn.close();
    }

    
    
    
    public void addTone(int toneid, String tonename, String tonepath )
    {
        Connection conn = null;
        Statement st = null;
        
        DB id = new DB();
        //String ext = id.getFileExtension(tonepath);
        
        //if (ext.equals("")) { System.out.println("Empty file Received");}
        
        //else if (ext.equals(".wav")) {
        
        try{
              //lass.forName("com.mysql.jdbc.Driver");
              //STEP: Open a connection
              
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
        } // end of the if loop
        
        
    // end of addTone()
    
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
              
              
              //Match the name 
          /*  
          while (rs.next())
          {
                String name = rs.getString("Name");
                if (name.equals(deleteName)
                {
                    break;
                }
                
                //System.out.format("%s, %s, %s, %s\n", id, checkReturn, toneLink, f);
          } */
              
              
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
        
    }
    
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
        
        //These statements might help closing the communication? Not sure yet. Need to figure it out
        st.close();
        conn.close();
    }
    
    
    
    public  String getFileExtension(String file) {
      
        String fileName = file;
        String ext = fileName.substring(fileName.lastIndexOf('.') + 1);

        
        return ext;
    }
    
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
		
		//These statements might help closing the communication? Not sure yet. Need to figure it out
		st.close();
		conn.close();
		return id;
    }
    
    /*   
    public string getNameoftheTone(String myDatabase) throws SQLException
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
        
        //These statements might help closing the communication? Not sure yet. Need to figure it out
        st.close();
        conn.close();
    }
    */
    

}

