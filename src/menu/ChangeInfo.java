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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.ChangeInfoData;

public class ChangeInfo extends JFrame{
	JPanel panel = new JPanel();
	private String password1;
	private String password2;
	private String password3;
	private String borrowname;
	private String borrower;
	private int flag = 0;
	
	public void setName(String borrower) {
		this.borrower = borrower;
	}
	
	public ChangeInfo() {
		
		/*
		 * 修改信息
		 */
		
		panel.setLayout(null);
		
		
		/*设置窗口背景图案*/
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0,1000, 800);
		
		/*面板5旧密码标签*/
		JLabel prepassword = new JLabel("旧密码:");
		Font font2 = new Font("宋体",Font.BOLD,25);
		prepassword.setFont(font2);
		prepassword.setBounds(300, 80, 600, 30);
		panel.add(prepassword);
		
		
		/*面板5旧密码文本框*/
		JPasswordField textprepass = new JPasswordField();
		Dimension d = new Dimension(350,45);
		textprepass.setFont(font2);
		textprepass.setSize(d);
		textprepass.setBounds(300, 130, 350, 45);
		panel.add(textprepass);
		
		
		/*密码标签*/
		JLabel password = new JLabel("密码：");
		password.setFont(font2);
		password.setBounds(300,190, 600, 30);
		panel.add(password);
		
		
		/*密码文本框*/
		JPasswordField textpass = new JPasswordField();
		textpass.setFont(font2);
		textpass.setSize(d);
		textpass.setBounds(300, 240, 350, 45);
		panel.add(textpass);
		
		
		/*确认密码标签*/
		JLabel repassword = new JLabel("确认密码：");
		repassword.setFont(font2);
		repassword.setBounds(300, 300, 600, 30);
		panel.add(repassword);
		
		/*确认密码文本框*/
		JPasswordField textrepass = new JPasswordField();
		textrepass.setFont(font2);
		textrepass.setSize(d);
		textrepass.setBounds(300, 350, 350, 45);
		panel.add(textrepass);
		
		
		/*修改姓名标签*/
		JLabel name = new JLabel("姓名：");
		name.setFont(font2);
		name.setBounds(300, 410, 600, 30);
		panel.add(name);
		
		/*修改姓名文本框*/
		JTextField textname = new JTextField();
		textname.setFont(font2);
		textname.setSize(d);
		textname.setBounds(300, 460, 350, 45);
		panel.add(textname);
		
		
		/*确定修改按钮*/
		JButton button = new JButton("确定修改");
		Font font = new Font("宋体",Font.BOLD,16);
		button.setFont(font);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.PINK);
		button.setBounds(300, 550, 350, 50);
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				password1 = textprepass.getText().trim();
				password2 = textpass.getText().trim();
				password3 = textrepass.getText().trim();
				borrowname = textname.getText().trim();
				String regex = "\\p{Alnum}";
				
				ChangeInfoData ci = new ChangeInfoData();
				try {
					flag = ci.checkPass(borrower, password1);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if(flag==1) {
					if((password2.length()<6||password2.length()>12)||password2.matches(regex)) {
						JOptionPane.showMessageDialog(null, "输入密码不符合要求", "警告", JOptionPane.WARNING_MESSAGE);
					}else {
						if(!(password2.equals(password3))){
							JOptionPane.showMessageDialog(null, "您输入的两次密码不相同", "警告",JOptionPane.ERROR_MESSAGE);
						}else {
							
							try {
								ci.savePass(password2, borrower);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							try {
								ci.savePass2(borrowname, borrower);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "信息更改成功", "恭喜",JOptionPane.PLAIN_MESSAGE);
						}
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "对不起，您的旧密码有误", "请重新输入", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		panel.add(label);
		
		panel.setOpaque(false);
		textprepass.setOpaque(false);
		textpass.setOpaque(false);
		textrepass.setOpaque(false);
		textname.setOpaque(false);
		
		
		this.add(panel);
	}
}
