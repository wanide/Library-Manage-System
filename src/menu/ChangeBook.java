package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import database.BookData;

public class ChangeBook extends JFrame{
	
	private String book;
	private String author;
	private int id;
	public JLayeredPane laypane1 = new JLayeredPane();
	private DefaultTableModel model;
	private String select ;
	private JCheckBox box;
	private int selectrow;
	private int selectcolumn;
	public int bookid;//书的编号
	public Date borrowtime;//借阅时间
	private String borrower;//借阅人
	public String lend;//是否在馆
	public String bookname;//书名
	private String bookname1;//书名1
	private String bookname2;//书名2
	DefaultTableModel model1;
	private String borroww;
	private String returnn;
	
	public void setName(String name) {
		this.borrower = name;
		
	}
	
	public void setModel(DefaultTableModel model1) {
		this.model1 = model1;
	}
	
	public ChangeBook()  {
		
		/*
		 * 查询图书
		 */
		Font font1 = new Font("宋体",Font.BOLD,13);
		Font font2 = new Font("宋体",Font.BOLD,20);
		
		
		//改变窗口图标
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		this.setIconImage(img);
		
		/*设置窗口背景图案*/
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0, 1000, 800);
		
		
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
		j.addItem("按照作者查询");
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
		
		/*新建表格*/
		model = new DefaultTableModel();
		model.addColumn("书本编号", new Vector<Integer>());
		model.addColumn("书名",new Vector<String>());
		model.addColumn("作者",new Vector<String>());
		model.addColumn("是否在馆",new Vector<String>());
		model.addColumn("选择图书", new Vector<String>());
		JTable table = new JTable(model);
		
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(100, 150, 750, 450);
		
		/*显示出全部图书*/
		BookData bd = new BookData();
		try {
			
			bd.selectAll(model);
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
		
		
		JTableHeader head = table.getTableHeader();//创建表格表头对象
		head.setPreferredSize(new Dimension(head.getWidth(),35));//设置表头框框大小
		head.setFont(new Font("宋体",Font.BOLD,15));//设置表格字体
		table.setRowHeight(30);//设置表格行宽
		table.setFont(new Font("宋体",Font.ROMAN_BASELINE,13));//设置表格行中字体大小
		
		/*使单元格中的内容居中*/
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		
		/*添加复选框*/
		table.getColumnModel().getColumn(4).setCellRenderer(new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, 
					boolean isSelected, boolean hasFocus,int row, int column) {
				/*定义复选框*/
				box = new JCheckBox();
				/*使具有焦点的行对应的复选框被选中*/
				box.setSelected(isSelected);
				
				/*使复选框在表格中居中*/
				box.setHorizontalAlignment((int)0.5f);
				return box;
			}
		});
		
		
		
		JButton button1 = new JButton("添加");
		JButton button2 = new JButton("删除");
		JButton button3 = new JButton("修改");
		button1.setFont(font2);
		button2.setFont(font2);
		button3.setFont(font2);
		button1.setBackground(Color.pink);
		button1.setBounds(160, 630, 170, 40);
		button2.setBackground(Color.pink);
		button2.setBounds(405,630, 170, 40);
		button3.setBackground(Color.pink);
		button3.setBounds(630,630, 170, 40);
		
		/*把组件放在分层窗格里*/
		laypane1.add(label, new Integer(0),0);
		laypane1.add(lab3,new Integer(150),1);
		laypane1.add(j,new Integer(100),2);
		laypane1.add(text3,new Integer(100),3);
		laypane1.add(button, new Integer(100),4);
		laypane1.add(jp, new Integer(200), 5);
		laypane1.add(button1, new Integer(630),6);
		laypane1.add(button2, new Integer(630),7);
		laypane1.add(button3, new Integer(630),8);
		

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
						
						bd.bookSelect(model,book);
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
				}else if(select.equals("按照作者查询")) {
					author = text3.getText().trim();
					try {
						
						bd.authorSelect(model,author);
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
				}else if(select.equals("按照编号查询")) {
					id = Integer.parseInt(text3.getText().trim());
					try {
						
						bd.idSelect(model,id);
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		
		/*选中行监听*/
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectrow = table.getSelectedRow();
				bookid =  (int) table.getValueAt(selectrow, 0);//获取所选书本编号
				bookname = (String) table.getValueAt(selectrow, 1);//获取所选书名
				lend= (String) table.getValueAt(selectrow, 3);//获取所选书本状态
				
			}
		});
		
		borroww = "借出";
		returnn = "退还";
		
		
		/*添加图书*/
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBook(model);
				
			}
		});
		
		/*修改图书*/
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FixBook(model,bookid);
				
			}
		});
		
		/*删除图书*/
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeleteBook(model,bookid,bookname);
			}
		});
		
		
		
//		/*删除图书监听*/
//		button2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(lend.equals("否")) {
//					bookname1 = "《" + bookname + "》";
//					JOptionPane.showMessageDialog(null, bookname1+"退还成功", "谢谢您的使用", JOptionPane.PLAIN_MESSAGE);
//					try {
//						bd.updatereturn(model, bookname);
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					/*借阅历史添加到数据库*/
//					try {
//						bd.addHistory(bookid, borrower, bookname, borrowtime, returnn);
//						
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//					
//					
//					/*更新借阅历史*/
//					try {
//						bd.showHistory(model1, borrower);
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
//		
//		
//		/*修改图书监听*/
//		button3.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(lend.equals("是")) {
//					/*获取借阅时间*/
//					try {
//						borrowtime = (Date) bd.booktime();
//					} catch (Exception e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//					
//					/*更改在馆信息*/
//					bookname2 = "《" + bookname + "》";
//					JOptionPane.showMessageDialog(null, bookname2+"借阅成功", "恭喜您", JOptionPane.PLAIN_MESSAGE);
//					try {
//						bd.updatelend(model, bookname);
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					
//					/*借阅历史添加到数据库*/
//					try {
//						bd.addHistory(bookid, borrower, bookname, borrowtime, borroww);
//						
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//					
//					
//					/*更新借阅历史*/
//					try {
//						bd.showHistory(model1, borrower);
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//				}else {
//					bookname2 = "《" + bookname + "》";
//					JOptionPane.showMessageDialog(null, bookname+"已被借阅", "抱歉", JOptionPane.PLAIN_MESSAGE);
//				}
//				
//			}
//		});
//	
		
		
		label.setOpaque(false);
		laypane1.setOpaque(false);
		
		text3.setOpaque(false);
	} 
	
}
