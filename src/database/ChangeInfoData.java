package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChangeInfoData {
	public int checkPass(String name,String password) throws Exception{
		String sql = "select * from user where username = ?";
		Connection con;
		PreparedStatement ps ;
		ResultSet rs;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, name) ;
		rs = ps.executeQuery();
		String s1 = null;
		while(rs.next()) {
			s1 = rs.getString(2);
			if(s1.equals(password)) {
				return 1;
			}else {
				return 0;
			}
		}
		return 0;
	}
	public void savePass(String password,String username) throws Exception{
		String sql = "update user set password = ? where username = ?";
		ResultSet rs ;
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();		
		ps = con.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, username);
		int ok = ps.executeUpdate();
		con.close();
	}
	public void savePass2(String name,String username) throws Exception{
		String sql = "update user set name = ? where username = ?";
		ResultSet rs ;
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();		
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, username);
		int ok = ps.executeUpdate();
		con.close();
	}
}
