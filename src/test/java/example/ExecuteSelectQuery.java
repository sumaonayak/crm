package example;



import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;





/**
 * 
 * @author suma
 *
 */
public class ExecuteSelectQuery {
	
	@Test
	public void createConatct() throws Throwable {
		String expDData = "rahul";
		boolean flag = false;
     
		//step 1 : register the database-Driver  
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		 //step 2 : connect to database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Sumaonayak21@");
		
		//step 3 : create statement
		Statement stat = con.createStatement();
		String query = "select *from student";
		
		//step 4 : execute Query 
		ResultSet result = stat.executeQuery(query);
	
		 //verify
		while(result.next()) {
			String lName = result.getString(2);
			 if(expDData.equals(lName)) {
				 System.out.println(expDData+ "==> rahul is availbale==>PASS");
				 flag = true;
				 break;
			 }
			 
		}
		
		if(flag==false) {
			 System.out.println(expDData+ "==> rahul is not availbale==>Fail");
		}

		 //step 5 : close the connection 
		con.close();
	}

}






