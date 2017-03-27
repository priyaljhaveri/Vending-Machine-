package jj;
import java.sql.*;
public class Sqlconn {
	public void adddb(int a,int b)
	{
		Connection con = null;
		PreparedStatement smt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/vending", "root", "manu@07");
			smt = con.prepareStatement("UPDATE t1"+"SET no = ? WHERE id = ?");
			smt.setInt(1, b);
			smt.setInt(2, a);
			int i = smt.executeUpdate();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getno(int a)
	{
		Connection con = null;
		Statement smt = null;
		int j=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/vending", "root", "manu@07");
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT no from t1 WHERE id = "+a);
			j = rs.getInt("no");
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return j;

	}
}
