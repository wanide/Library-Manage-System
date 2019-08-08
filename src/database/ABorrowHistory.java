package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ABorrowHistory {
	/*显示所有借书记录*/
	public void allHistory(DefaultTableModel model)throws Exception{
		String sql = "select * from borrowhistory";
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			int BookNo = rs.getInt(1);
			String Borrower = rs.getString(2);
			String Book = rs.getString(3);
			Date Time = rs.getDate(4);
			String Lend = rs.getString(5);
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Borrower,Time,Lend)));
		}
		con.close();
	}
	/*按照书名搜索历史*/
	public void bookSelect(DefaultTableModel model,String book) throws Exception {
		String sql = "select * from borrowhistory where Book like ?";
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
			String Borrower = rs.getString(2);
			String Book = rs.getString(3);
			Date Time = rs.getDate(4);
			String Lend = rs.getString(5);
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Borrower,Time,Lend)));
		}
		con.close();
	}
	/*按照借阅者搜索图书*/
	public void borrowerSelect(DefaultTableModel model,String borrower) throws Exception{
		String sql = "select * from borrowhistory where Borrower like ?";
		Connection con;
		ResultSet rs;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		borrower = "%" + borrower + "%";
		ps.setString(1, borrower);
		rs = ps.executeQuery();
		while(rs.next()) {
			int BookNo = rs.getInt(1);
			String Borrower = rs.getString(2);
			String Book = rs.getString(3);
			Date Time = rs.getDate(4);
			String Lend = rs.getString(5);
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Borrower,Time,Lend)));
		}
		con.close();
	}
	/*按照编号搜索历史*/
	public void idSelect(DefaultTableModel model,int id) throws Exception{
		String sql = "select * from borrowhistory where BookNo = ?";
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
			String Borrower = rs.getString(2);
			String Book = rs.getString(3);
			Date Time = rs.getDate(4);
			String Lend = rs.getString(5);
			model.addRow(new Vector<>(Arrays.asList(BookNo,Book,Borrower,Time,Lend)));
		}
		con.close();
	}
}
