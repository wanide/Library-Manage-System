package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManageUser {
	
	/*添加用户*/
	public void addUser(String username,String password) throws Exception{
		String sql = "insert into user values(?,?,?,0)";
		Connection con;
		PreparedStatement ps;
		String name = "user";
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, name);
		int ok = ps.executeUpdate();
		con.close();
	}
	/*删除用户*/
	public void deleteUser(String username) throws Exception{
		String sql = "delete from user where username = ?";
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, username);
		int ok = ps.executeUpdate();
		con.close();
	}
	/*修改密码*/
	public void changePass(String username,String password) throws Exception{
		String sql = "update user set password = ? where username = ?";
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
	/*修改名字*/
	public void changeName(String username,String name) throws Exception{
		String sql = "update user set name = ? where username = ?";
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
