package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.ConnectData;

public class Regest {
	private String username;
	private String password;
	private String repassword;
	private String name;
	
	public void show() throws Exception {
		JFrame f = new JFrame("注册"); 
		
		
		//改变窗口图标
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		f.setIconImage(img);
		
		
		f.setSize(400, 500);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		
		
		/*设置窗口背景图案*/
		Icon i = new ImageIcon("picture\\regist.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0, 400, 500);
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		
		//界面文字的字体，字形，字号
		Font font = new Font("宋体",Font.BOLD,15);
		//界面框框的字体，字形，字号
		Font font2 = new Font("宋体",Font.BOLD,25);
		Dimension dimension = new Dimension(200,30);
		
		panel1.setLayout(null);
		/*返回按钮*/
		JButton rebutton = new JButton("返回");
		Font font4 = new Font("宋体",Font.BOLD,12);
		rebutton.setFont(font4);
		Dimension dimension1 = new Dimension(60,40);
		rebutton.setPreferredSize(dimension1);
		rebutton.setBackground(Color.white);
		rebutton.setBounds(0, 0, 60, 40);
		panel1.add(rebutton);
		f.add(panel1);
		
		
		//添加注册大标题
		JLabel regist = new JLabel("注册");
		Font font1 = new Font("宋体",Font.BOLD,36);
		regist.setFont(font1);
		regist.setBounds(150, 10, 400, 70);
		panel1.add(regist);
		panel1.setBounds(0, 0, 400, 70);		
		
		
		//添加用户名标签
		JLabel labname = new JLabel(" 用户名：");
		labname.setFont(font);
		panel2.add(labname);
		
		//添加用户名文本框
		JTextField textname = new JTextField();
		textname.setPreferredSize(dimension);
		panel2.add(textname);
		panel2.setBounds(10, 90, 300, 70);
		f.add(panel2);
		
		
		/*添加设置密码标签*/
		JLabel labpassword = new JLabel("设置密码：");
		labpassword.setFont(font);
		panel3.add(labpassword);
		
		/*添加设置密码的文本框*/
		JPasswordField textpassword = new JPasswordField();
		textpassword.setPreferredSize(dimension);
		textpassword.setFont(font2);
		panel3.add(textpassword);
		JLabel labrequest = new JLabel("         *密码由6-12位数字、字符组成*");
		Font font3 = new Font("宋体",Font.BOLD,12);
		labrequest.setFont(font3);
		labrequest.setForeground(Color.red);
		panel3.add(labrequest);
		panel3.setBounds(10, 150, 300, 70);
		f.add(panel3);
		
		
		/*重新输入密码标签*/
		JLabel labpassword1 = new JLabel("确认密码：");
		labpassword1.setFont(font);
		panel4.add(labpassword1);
		
		/*重新输入密码文本框*/
		JPasswordField textpassword1 = new JPasswordField();
		textpassword1.setPreferredSize(dimension);
		textpassword1.setFont(font2);
		panel4.add(textpassword1);
		panel4.setBounds(10, 210, 300, 70);
		f.add(panel4);
		
		
		/*设置姓名标签*/
		JLabel labelname = new JLabel("    姓名：");
		labelname.setFont(font);
		panel5.add(labelname);
		
		/*输入姓名文本框*/
		JTextField textname1 = new JTextField();
		textname1.setPreferredSize(dimension);
		panel5.add(textname1);
		panel5.setBounds(10, 270, 300, 70);
		f.add(panel5);
		
		
		/*添加注册按钮*/
		JButton button = new JButton("注册");
		Font font5 = new Font("宋体",Font.BOLD,25);
		button.setFont(font5);
		Dimension dimension2 = new Dimension(200,40);
		button.setPreferredSize(dimension2);
		button.setBackground(Color.pink);
		panel6.add(button);
		panel6.setBounds(100, 340, 200, 50);
		f.add(panel6);
		
		//把组件设置为透明
		textname.setOpaque(false);
		textpassword.setOpaque(false);
		textpassword1.setOpaque(false);
		textname1.setOpaque(false);
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		panel6.setOpaque(false);
		

		/*返回登陆界面*/
		rebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				SignMenu sm = new SignMenu();
				sm.init();
			}
		});
		
		/*注册信息存入数据库*/
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					username = textname.getText().trim();
					password = textpassword.getText().trim();
					repassword = textpassword1.getText().trim();
					name = textname1.getText().trim();
					String regex = "\\p{Alnum}";
					
					int t = 0;
					try {
						t = compare(username);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					/*用户名不能为空*/
					if(username.length() == 0) {
						JOptionPane.showMessageDialog(null, "用户名不能为空", "警告", JOptionPane.WARNING_MESSAGE);
					
					}else if(t == 1) {
						/*用户已存在*/
						JOptionPane.showMessageDialog(null, "用户名已存在", "警告", JOptionPane.WARNING_MESSAGE);
					}else if((password.length()<6||password.length()>12)||password.matches(regex)) {
						/*输入密码由6-12位数字，字符组成*/
						JOptionPane.showMessageDialog(null, "输入密码不符合要求", "警告", JOptionPane.WARNING_MESSAGE);
			
					}else if(!(password.equals(repassword))) {
						//两次输入密码不一样时弹出警告对话框
						JOptionPane.showMessageDialog(null, "您输入的两次密码不相同", "警告",JOptionPane.ERROR_MESSAGE);
				
					}else if(name.length() == 0) {
						/*姓名不能为空*/
						JOptionPane.showMessageDialog(null, "姓名不能为空", "警告", JOptionPane.WARNING_MESSAGE);
			
					}else {
						/*把注册信息添加到数据库*/
						try {
							insert(username,password,name);
							JOptionPane.showMessageDialog(null, "注册成功!", "注册", JOptionPane.PLAIN_MESSAGE);	
							f.dispose();
							SignMenu sm = new SignMenu();
							sm.init();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				
					
				
			}
		});
				
		f.add(label);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void insert(String username,String password,String name) throws SQLException {
			ResultSet rs ;
			Connection con;
			PreparedStatement ps;
			
			ConnectData cd = new ConnectData();
			con = cd.connect();		
			String sql = "insert into user values(?,?,?,0)";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			int ok = ps.executeUpdate();
			con.close();
		}
	public int compare(String username) throws Exception{
		ResultSet rs ;
		Connection con;
		PreparedStatement ps;
		ConnectData cd = new ConnectData();
		con = cd.connect();		
		String sql = "select * from user where username = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while(rs.next()) {
			return 1;
		}
		con.close();
		return 0;
		
	}
}
