package sampleproject;
import java.sql.*;

public class connectDB {
	static Connection conect() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleproject","root","");
			System.out.println("Connection Established");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return con;
	}

}
