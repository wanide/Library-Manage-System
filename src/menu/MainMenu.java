package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame{
	JPanel panel = new JPanel();
	JButton button;
	public MainMenu() {
		
		
		/*…Ë÷√¥∞ø⁄±≥æ∞Õº∞∏*/
		Icon i = new ImageIcon("picture\\p1.1.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0, 1000, 800);
		
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 1000, 800);
		
		panel.add(label);
	}
}
