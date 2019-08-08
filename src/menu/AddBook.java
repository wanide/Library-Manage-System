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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.BookData;
import database.ManageBook;

public class AddBook {
	
	public AddBook(DefaultTableModel model) {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setTitle("添加图书");
		
		//改变窗口图标
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		f.setIconImage(img);
		
		/*设置窗口背景图案*/
		Icon i = new ImageIcon("picture\\admin_background.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0, 500, 500);
		
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		Font font = new Font("宋体",Font.BOLD,30);
		Font font1 = new Font("宋体",Font.PLAIN,20);
		Dimension dimension = new Dimension(300,40);
		Dimension dimension1 = new Dimension(200,40);
		
		/*书名标签*/
		JLabel labbook = new JLabel("书名：");
		labbook.setFont(font);
		panel1.add(labbook);
		panel1.setBounds(50, 30, 200, 60);
		
		/*书名输入文本框*/
		JTextField textbook = new JTextField(12);
		panel2.setLayout(null);
		textbook.setSize(dimension);
		textbook.setFont(font1);
		panel2.add(textbook);
		panel2.setBounds(100, 90, 500, 50);
		
		/*作者标签*/
		JLabel labauthor = new JLabel("作者：");
		labauthor.setFont(font);
		panel3.add(labauthor);
		panel3.setBounds(50, 160, 200, 60);
		
		/*作者输入文本框*/
		JTextField textauthor = new JTextField(12);
		panel4.setLayout(null);
		textauthor.setSize(dimension);
		textauthor.setFont(font1);
		panel4.add(textauthor);
		panel4.setBounds(100, 220, 500, 50);
		
		
		/*添加按钮*/
		JButton button = new JButton("确定添加");
		button.setPreferredSize(dimension1);
		button.setBackground(Color.PINK);
		button.setFont(new Font("宋体",Font.BOLD,25));
		panel5.add(button);
		panel5.setBounds(150, 300, 200, 100);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String book = textbook.getText().trim();
				String author = textauthor.getText().trim();
				String lend = "是";
				ManageBook mb = new ManageBook();
				try {
					mb.addBook(book, author,lend);
					JOptionPane.showMessageDialog(null, "添加成功", "添加", JOptionPane.PLAIN_MESSAGE);
					
					BookData bd = new BookData();
					try {
						model.setRowCount(0);
						bd.selectAll(model);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		f.add(panel1);
		f.add(panel2);
		f.add(panel3);
		f.add(panel4);
		f.add(panel5);
		f.add(label);
		
		textbook.setOpaque(false);
		textauthor.setOpaque(false);
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		
		f.setVisible(true);
	}
}
