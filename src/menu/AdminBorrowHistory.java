package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.ABorrowHistory;
import database.BookData;

public class AdminBorrowHistory extends JFrame{
	private String book;
	private int id;
	private String select ;
	public int bookid;//书的编号
	public Date borrowtime;//借阅时间
	private String borrower;//借阅人
	public String lend;//是否在馆
	public String bookname;//书名
	
	public JLayeredPane laypane = new JLayeredPane();
		private String name;
		
		DefaultTableModel model ;
		JScrollPane jp;
		
		public void setName(String name) {
			this.name = name;
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
			
			Font font1 = new Font("宋体",Font.BOLD,13);
			Font font2 = new Font("宋体",Font.BOLD,20);
					
			/*面板3中的标签*/
			Font font = new Font("宋体",Font.BOLD,20);
			JLabel lab3 = new JLabel("请选择查询方式：");
			lab3.setFont(font);
			lab3.setBounds(140, 60, 600, 30);
			
			
			/*面板3中的查询下拉框*/
			Dimension dimension = new Dimension(220,30);
			JComboBox<String> j = new JComboBox<>();
			j.setSize(dimension);
			j.addItem("按照书名查询");
			j.addItem("按照借阅人查询");
			j.addItem("按照编号查询");
			j.setBounds(140, 100,220, 30);
			j.setBackground(Color.pink );
			j.setFont(font1);
			
			
			/*面板3中的搜索框*/
			JTextField text3 = new JTextField();
			Dimension dimension1 = new Dimension(270,30);
			text3.setFont(font1);
			text3.setSize(dimension1);
			text3.setBackground(Color.pink);
			text3.setBounds(390,100, 270, 30);
			
			/*按钮*/
			JButton button = new JButton("搜索");
			button.setBackground(Color.pink);
			button.setBounds(670, 100, 120, 30);
			button.setFont(font2);
			
			model = new DefaultTableModel();
			model.addColumn("图书编号", new Vector<Integer>());
			model.addColumn("书名", new Vector<String>());
			model.addColumn("借阅人", new Vector<String>());
			model.addColumn("日期", new Vector<Date>());
			model.addColumn("借阅状态", new Vector<String>());
			JTable table = new JTable(model);
			
			jp = new JScrollPane(table);
			jp.setBounds(90, 160, 800, 500);
			
			/*显示所有结束记录*/
			ABorrowHistory abh = new ABorrowHistory();
			try {
				abh.allHistory(model);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*下拉框添加事件*/
			select = "按照书名查询";
			j.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					if(e.getStateChange()==ItemEvent.SELECTED) {
						select =(String) e.getItem();
						
					}
				}
			});
			
			
			
			/*搜索监听*/
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					model.setRowCount(0);
					if(select.equals("按照书名查询")) {
						book = text3.getText().trim();
						try {
							
							abh.bookSelect(model, book);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
						
					}else if(select.equals("按照借阅人查询")) {
						borrower = text3.getText().trim();
						try {
							
							abh.borrowerSelect(model, borrower);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
						
					}else if(select.equals("按照编号查询")) {
						
						try {
							id = Integer.parseInt(text3.getText().trim());
							abh.idSelect(model, id);
						} catch (Exception e1) {
							
						}
					}
				}
			});
			
			
			
			JTableHeader head = table.getTableHeader();//创建表格表头对象
			head.setPreferredSize(new Dimension(head.getWidth(),35));//设置表头框框大小
			head.setFont(new Font("宋体",Font.BOLD,15));//设置表格字体
			table.setRowHeight(30);//设置表格行宽
			table.setFont(new Font("宋体",Font.BOLD,20));//设置表格行中字体大小
			
			
			laypane.add(label, new Integer(0),0);
			laypane.add(lab3,new Integer(150),1);
			laypane.add(j,new Integer(100),2);
			laypane.add(text3,new Integer(100),3);
			laypane.add(button, new Integer(100),4);
			laypane.add(jp, new Integer(200), 5);
			laypane.add(jp, new Integer(130),6);
			
			label.setOpaque(false);
			laypane.setOpaque(false);
		}
		
}

