//opening database -> creating tables -> populating data

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class postgre_populate {
	public static void main(String args[]) throws InterruptedException{
		
			
		try{
			
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "divs", "password");	
			System.out.println("opened database successfully");
			
			Statement stmt = c.createStatement();
			String sql_command = null;
//			String sql_command = "CREATE TABLE Planets " +
//                    " (Planet_Name  TEXT    NOT NULL,"   + 
//                    " Planet_ID INT PRIMARY KEY NOT NULL)";
//			stmt.executeUpdate(sql_command);
//			
//			sql_command = "CREATE TABLE Aliens " +
//					"(Planet_ID INT references Planets(Planet_ID), "+
//                    "Alien_ID INT PRIMARY KEY     NOT NULL, " +
//                    "Alien_Name  TEXT    NOT NULL, " +
//                    "Alien_IQ INT NOT NULL)";
//			stmt.executeUpdate(sql_command);
//			
//			int i = 1;
//			while(i<=1000){
//				sql_command = "INSERT INTO Planets(Planet_Name, Planet_ID) "
//			               + "VALUES ( 'p" + i + "', " + i + ")";
//			    stmt.executeUpdate(sql_command);
//			    i = i+1;
//			}
			int i = 10001;
			Random rr = new Random();
			while(i<=30000000){
				sql_command = "INSERT INTO Aliens(Planet_ID, Alien_ID, Alien_Name, Alien_IQ) "
			               + "VALUES ( "+ (rr.nextInt(1000)+1)+ ", " + i + ", '"+ "a" + i + "'," + (rr.nextInt(1000)+1)*100 + ")";
			    stmt.executeUpdate(sql_command);
			    i = i+1;
			}
			System.out.println("entries done");
//			String sql = "DROP TABLE Records ";
			 
		    stmt.executeUpdate(sql_command);
			stmt.close();
			c.close();
		}
		catch(Exception e){
			System.err.println(e.getClass().getName()+": "+e.getMessage());
	        System.exit(0);
		}
		
	}
}
