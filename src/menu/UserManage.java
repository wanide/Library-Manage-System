package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserManage extends JFrame{
	JPanel panel = new JPanel();	
	public UserManage() {
		
		panel.setLayout(null);
		
		//改变窗口图标
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		this.setIconImage(img);
		
		/*设置窗口背景图案*/
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0,1000, 800);
		
		JLabel lab = new JLabel("管理操作");
		Font font1 = new Font("宋体",Font.BOLD,40);
		lab.setFont(font1);
		lab.setBounds(380, 50, 500, 100);
		panel.add(lab);
		
		Dimension d = new Dimension(200,50);
		Font font2 = new Font("宋体",Font.BOLD,25);
		
		JButton button1 = new JButton("添加用户");
		JButton button2 = new JButton("修改密码");
		JButton button3 = new JButton("修改姓名");
		JButton button4 = new JButton("删除用户");
		
		button1.setBackground(Color.pink);
		button2.setBackground(Color.pink);
		button3.setBackground(Color.pink);
		button4.setBackground(Color.pink);
		
		button1.setPreferredSize(d);
		button2.setPreferredSize(d);
		button3.setPreferredSize(d);
		button4.setPreferredSize(d);
		
		button1.setBounds(320, 170, 300, 50);
		button2.setBounds(320, 270, 300, 50);
		button3.setBounds(320, 370, 300, 50);
		button4.setBounds(320, 470, 300, 50);
		
		button1.setFont(font2);
		button2.setFont(font2);
		button3.setFont(font2);
		button4.setFont(font2);
		
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(label);
		
		/*添加用户*/
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddUser au = new AddUser();
				
			}
		});
		
		/*修改密码*/
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FixPass();
				
			}
		});
		
		
		
		/*修改姓名*/
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FixName();
				
			}
		});
		
		
		
		/*删除用户*/
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteUser();
				
			}
		});
		
		panel.setOpaque(false);
		lab.setOpaque(false);
		
	}
	
}
