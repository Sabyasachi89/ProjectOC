package GuruBank.GuruBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseWriting {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "iapbpm", "bpm@123");
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Statement stmnt = con.createStatement();
		
		ResultSet rs = stmnt.executeQuery("select * from IOXDB_TEST.IAP.REF_DEPT");

		while (rs.next()) {
			
			System.out.println(rs.getString(2));
		}
		
		
		
	}
}
