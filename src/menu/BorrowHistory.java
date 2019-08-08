package menu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.BookData;


public class BorrowHistory extends JFrame{
	private String name;
	public JLayeredPane laypane = new JLayeredPane();
	DefaultTableModel model ;
	JScrollPane jp;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BorrowHistory() {
		//setTable();
	}
	
	public void setPanel() {

		//改变窗口图标
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		this.setIconImage(img);
		
		/*设置窗口背景图案*/
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0,1000, 800);
				
		
		JLabel lab = new JLabel("图书借阅历史");
		Font font = new Font("宋体",Font.BOLD,40);
		lab.setFont(font);
		lab.setBounds(330, 40, 800, 100);

		
		model = new DefaultTableModel();
		model.addColumn("图书编号", new Vector<Integer>());
		model.addColumn("书名", new Vector<String>());
		model.addColumn("日期", new Vector<Date>());
		model.addColumn("借阅状态", new Vector<String>());
		JTable table = new JTable(model);
		
		jp = new JScrollPane(table);
		jp.setBounds(90, 130, 800, 500);
		
		//System.out.println(name);
		BookData bd = new BookData();
		try {
			bd.showHistory(model, name);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		JTableHeader head = table.getTableHeader();//创建表格表头对象
		head.setPreferredSize(new Dimension(head.getWidth(),35));//设置表头框框大小
		head.setFont(new Font("宋体",Font.BOLD,15));//设置表格字体
		table.setRowHeight(30);//设置表格行宽
		table.setFont(new Font("宋体",Font.BOLD,20));//设置表格行中字体大小
		
		
		laypane.add(label, new Integer(0),0);
		laypane.add(lab, new Integer(30),1);
		laypane.add(jp, new Integer(130),2);
		
		label.setOpaque(false);
		laypane.setOpaque(false);
	}
	
}
