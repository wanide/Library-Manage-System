 package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class BookData {
	/*显示全部图书*/
	public void selectAll(DefaultTableModel model)throws Exception{
		String sql = "select * from bookmanage";
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			int BookNo = rs.getInt(1);
			String Book = rs.getString(2);
			String Author = rs.getString(3);
			String Lend = rs.getString(4);
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Author,Lend)));
		}
		con.close();
	}
	
	/*按照书名搜索图书*/
	public void bookSelect(DefaultTableModel model,String book) throws Exception {
		String sql = "select * from bookmanage where Book like ?";
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		book= "%"+book+"%";
		ps.setString(1, book);
		rs = ps.executeQuery();
		while(rs.next()) {
			int BookNo = rs.getInt(1);
			String Book = rs.getString(2);
			String Author = rs.getString(3);
			String Lend = rs.getString(4);
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Author,Lend)));
		}
		con.close();
	}
	/*按照作者搜索图书*/
	public void authorSelect(DefaultTableModel model,String author) throws Exception{
		String sql = "select * from bookmanage where Author like ?";
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		author = "%" + author + "%";
		ps.setString(1, author);
		rs = ps.executeQuery();
		while(rs.next()) {
			int BookNo = rs.getInt(1);
			String Book = rs.getString(2);
			String Author = rs.getString(3);
			String Lend = rs.getString(4);
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Author,Lend)));
		}
		con.close();
	}
	/*按照编号搜索图书*/
	public void idSelect(DefaultTableModel model,int id) throws Exception{
		String sql = "select * from bookmanage where BookNo = ?";
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while(rs.next()) {
			int BookNo = rs.getInt(1);
			String Book = rs.getString(2);
			String Author = rs.getString(3);
			String Lend = rs.getString(4);
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Author,Lend)));
		}
		con.close();
	}
	/*更新在馆信息为借出*/
	public void updatelend(DefaultTableModel model,String book) throws Exception{
		String sql = "update bookmanage set Lend = '否' where Book = ?";
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, book);
		int ok = ps.executeUpdate();
		con.close();
		model.setRowCount(0);
		selectAll(model);
		con.close();
	}
	/*更新在馆信息为退还*/
	public void updatereturn(DefaultTableModel model,String book) throws Exception{
		String sql = "update bookmanage set Lend = '是' where Book = ?";
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, book);
		int ok = ps.executeUpdate();
		con.close();
		model.setRowCount(0);
		selectAll(model);
		con.close();
	}
	/*获取借阅时间*/
	public Date booktime() throws Exception{
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
			t = rs.getDate(1);
		}
		con.close();
		return t;
	}
	/*把借阅历史加入数据库*/
	public void addHistory(int id,String borrower,String book,Date time,String lend)throws Exception{
		String sql = "insert into borrowhistory(BookNo,Borrower,Book,Date,Lend) values (?,?,?,?,?)";
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, borrower);
		ps.setString(3, book);
		ps.setDate(4, (java.sql.Date) time);
		ps.setString(5, lend);
		int ok = ps.executeUpdate();
		con.close();
	}
	/*显示借阅历史*/
	public void showHistory(DefaultTableModel model,String username) throws Exception{
		model.setRowCount(0);
		String sql = "select * from borrowhistory where borrower = ?";
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while(rs.next()) {
			int BookNo = rs.getInt(1);
			String Book = rs.getString(3);
			Date Time = rs.getDate(4);
			String Lend = rs.getString(5);
			
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Time,Lend)));
		}
		con.close();
	}
	
}

