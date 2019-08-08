package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManageBook {
	
	/*向数据库添加图书*/
	public void addBook(String book,String author,String lend) throws Exception{
		String sql = "insert into bookmanage(Book,Author,Lend) values (?,?,?)";
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, book);
		ps.setString(2, author);
		ps.setString(3, lend);
		int ok = ps.executeUpdate();
		con.close();
	}
	/*修改图书信息*/
	public void changeBook(int id,String book) throws Exception{
		String sql = "update bookmanage set Book = ? where BookNo = ?";
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, book);
		ps.setInt(2, id);
		int ok = ps.executeUpdate();
		con.close();
	}
	public void changeAuthor(int id,String author) throws Exception{
		String sql = "update bookmanage set Author = ? where BookNo = ?";
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, author);
		ps.setInt(2, id);
		int ok = ps.executeUpdate();
		con.close();
	}
	/*删除图书信息*/
	public void delete(int id) throws Exception{
		String sql = "delete from bookmanage where BookNo = ?";
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int ok = ps.executeUpdate();
		con.close();
	}
}
