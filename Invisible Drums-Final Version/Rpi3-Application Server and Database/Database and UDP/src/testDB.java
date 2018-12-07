/**
 * Project Invisible Drums, SYSC 3010 Monday Group 7
 * JUNIT testing
 * @author Mohammed Tanvir Hossain
 * @Version Final, December 3rd, 2018
 *
 */



import static org.junit.jupiter.api.Assertions.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class testDB
{
	
	DB db = new DB();
	static String myDriver = "com.mysql.cj.jdbc.Driver";
    static String myDatabase = "jdbc:mysql://localhost:3306/idrums";
    static String tonepath = "F:/My CarleTON/Fall 2018/SYSC 3010/InvisibleDrums/sound packs/ bongo.wav";
   
	
    /*
     * Tests if the tone is added successfully
     * It tests 3 cases for this method
     */
    
    @Test 
	void testaddTone() throws SQLException
	{
		
    	System.out.format("\n**Test 1 Add Tone** \n");
		int toneid = 18;
		String tonename = "bongo";
		System.out.format("Current Database Records \n");
		db.viewAllTone(myDatabase);
		
		
		db.addTone(toneid, tonename, tonepath);
		System.out.format("\nAfter Operation \n");
		db.viewAllTone(myDatabase);
		
		
		//This code is for assert statement
		Connection conn = DriverManager.getConnection(myDatabase, "root", "1234"); 
		String query = "SELECT * FROM tones WHERE ID = '"+toneid+"'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		//String toneLink = rs.getString("LinktoTone");
		
		while (rs.next())
	      {
	        int id = rs.getInt("id");
	        String checkReturn = rs.getString("Name");
	        String toneLink = rs.getString("LinktoTone");
	        Blob f = rs.getBlob(4);
	        //System.out.format("%s, %s, %s, %s\n", id, checkReturn, toneLink, f);
	        assertEquals(tonepath, toneLink);
	      }	
		
		
		
	} // end of test 
    
    
 /*
  * Tests to see if it catches the empty tone
  */
  @Test
	void testaddEmptyTone() throws SQLException
	{
	    System.out.format("**Test Add Empty File** \n");
	  	String emptypath = "";
		String result = db.getFileExtension(emptypath);
		String expected = "Empty file Received";
		
		assertEquals(expected, result);

		
	} // end of test 
  
  
  /*
   * Tests to see if it catches invalid file
   */
  
  @Test
	void testaddInvalidFile() throws SQLException
	{
	  System.out.format("\n**Test Add Invalid File** \n");
		String invalidfile = "F:/My CarleTON/Fall 2018/SYSC 3010/InvisibleDrums/sound packs/ blooze.txt";
		String result = db.getFileExtension(invalidfile);
		String expected = "Invalid file received";
		
		assertEquals(expected, result);

		
	} // end of test
  	
  	/*
  	 * Tests if the deleteTone works successfully
  	 */
	
	@Test
	void testdeleteTone() throws SQLException {
		
		int toneid = 4;
		String tonename = "bongo";
		
		db.deleteTone(toneid);
		
		Connection conn = DriverManager.getConnection(myDatabase, "root", "1234"); 
		String query = "SELECT * FROM tones WHERE ID = '"+toneid+"'";	
		Statement st = conn.createStatement();			
		ResultSet rs = st.executeQuery(query);

	
		while (rs.next())
	      {
	        int id = rs.getInt("id");
	        String checkReturn = rs.getString("Name");
	        String toneLink = rs.getString("LinktoTone");
	        Blob f = rs.getBlob(4);
	        System.out.format("%s, %s, %s, %s\n", id, checkReturn, toneLink, f);
	        assertEquals("", toneLink);
	      }
	}
	
}


