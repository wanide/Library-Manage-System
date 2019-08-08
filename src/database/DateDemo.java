package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) throws Exception{
		Date d = new Date();
		System.out.println(d);
		Date t = null ;
		String sql = "select now()";
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			d = rs.getDate(1);
		}
		System.out.println(d);
		con.close();
	}
}

