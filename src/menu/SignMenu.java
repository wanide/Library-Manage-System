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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.ConnectData;

public class SignMenu {
	private String username;
	private String password1;
	private String text;
	private int flag = 0;
	public JTextField id;
	private String name;
	private String select;
	
	public void init() {
			
		JFrame f = new JFrame("欢迎使用图书管理系统");
		
		//改变窗口图标
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("picture\\sign.jpg");
		f.setIconImage(img);
		
		//设置窗口大小
		f.setSize(600, 600);
		
		//使窗口居中
		f.setLocationRelativeTo(null);
		
		//设置布局为空
		f.setLayout(null);
		
		//设置窗口背景图案
		Icon i = new ImageIcon("picture\\background4.jpg");
		JLabel jLable = new JLabel(i);
		jLable.setBounds(0, 0, 600, 600);
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		
		/*添加大标题：图书管理系统*/
		JLabel lable = new JLabel("图书管理系统");
		Font font = new Font("宋体",Font.BOLD,40);//设置字体
		lable.setFont(font);
		panel1.add(lable);
		panel1.setBounds(140, 60, 300, 300);//设置面板大小
		f.add(panel1);
		
		
		/*用户类型标签*/
		JLabel user = new JLabel("用户类型  ");
		Font font1 = new Font("宋体",Font.BOLD,25);
		user.setFont(font1);
		panel2.add(user);
			
			
		/*用户类型的下拉框*/
		JComboBox<String> j = new JComboBox<String>();
		Dimension dimension = new Dimension(200,30);//框框的大小
		j.setPreferredSize(dimension);
		j.addItem("普通用户");
		j.addItem("管理员用户");
		Font font2 = new Font("宋体",Font.BOLD,15);
		j.setFont(font2);
		j.setBackground(Color.PINK);
		panel2.setBounds(90, 160, 400, 300);
		panel2.add(j);
		f.add(panel2);
		
		
		/*账号标签*/
		JLabel labid = new JLabel("   账号： ");
		Font font3 = new Font("宋体",Font.BOLD,25);	
		labid.setFont(font3);
		panel3.add(labid);
		
		/*输入账户的文本框*/
		id = new JTextField();
		id.setPreferredSize(dimension);
		//id.setBackground(Color.PINK);
		panel3.add(id);
		panel3.setBounds(90, 230, 400, 300);
		f.add(panel3);
		
		
		/*密码标签*/
		JLabel labpassword = new JLabel("   密码： ");
		Font font4 = new Font("宋体",Font.BOLD,25);
		labpassword.setFont(font4);
		panel4.add(labpassword);
		
		/*输入密码文本框*/
		JPasswordField password = new JPasswordField();
		password.setPreferredSize(dimension);
		Font font5 = new Font("宋体",Font.BOLD,25);	
		password.setFont(font5);
		password.setBackground(Color.pink);
		panel4.add(password);
		panel4.setBounds(90, 290, 400, 300);
		f.add(panel4);
		
		
		/*注册登陆按钮*/
		JButton button1 = new JButton("注册");
		JButton button2 = new JButton("登陆");
		button1.setFont(font4);
		button2.setFont(font4);
		Dimension dimension2 = new Dimension(100,50);
		button1.setPreferredSize(dimension2);
		button2.setPreferredSize(dimension2);
		button1.setBackground(Color.PINK);
		button2.setBackground(Color.PINK);
		panel5.add(button1);
		panel6.add(button2);
		panel5.setBounds(150, 370, 150, 400);
		panel6.setBounds(330, 370, 150, 400);
		f.add(panel5);
		f.add(panel6);
		
		id.setOpaque(false);
		password.setOpaque(false);
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		panel6.setOpaque(false);
		
		f.add(jLable);
		
		/*用户类型*/
		select = "普通用户";
		j.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					select = (String) e.getItem();
				}
				
			}
		});
		
		
		
		/*点击注册跳转到注册界面*/
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Regest r = new Regest();
				try {
					r.show();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		/*登陆信息比对*/
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = j.getToolTipText();
				username = id.getText().trim();
				password1 = password.getText().trim();
				
				try {
					flag = select(username,password1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag == 1) {//密码输入正确
					name = id.getText().trim();
					
					if(select == "普通用户") {
						f.dispose();
						new User(name);
					}else if(select == "管理员用户") {
						flag = 0;
						try {
							flag = ensure(name);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(flag == 1) {
							new Admin(name);
							f.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "对不起，您还不是管理员", "警告", JOptionPane.WARNING_MESSAGE);
						}
					}
				}else if(flag == 0) {//密码输入错误
					JOptionPane.showMessageDialog(null, "密码输入有误", "抱歉", JOptionPane.PLAIN_MESSAGE);
				}else if (flag == 2) {
					JOptionPane.showMessageDialog(null, "用户名不存在","注意" , JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		//设置不可改变窗口大小
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public int select(String username1,String password1) throws Exception {
		boolean flag = false;
		String sql = "select * from user where username=?";
		Connection con;
		PreparedStatement ps ;
		ResultSet rs;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, username1) ;
		rs = ps.executeQuery();
		String s1 = null;
		while(rs.next()) {
			flag = true;
			s1 = rs.getString(2);
		}
		if(!flag) {//用户名不存在
			con.close();
			return 2;
		}
		else if(s1.equals(password1)) {
			return 1;
		}else {
			return 0;
		}
	}
	public int ensure(String username) throws Exception{
		String sql = "select * from user where username=?";
		Connection con;
		PreparedStatement ps ;
		ResultSet rs;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, username) ;
		rs = ps.executeQuery();
		int s1=0;
		while(rs.next()) {
			s1 = rs.getInt(4);
		}
		return s1;
	}
}
