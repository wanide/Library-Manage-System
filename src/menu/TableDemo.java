package menu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import javafx.scene.control.TableColumn;

public class TableDemo extends JFrame{
	static JTable table;
	public TableDemo() {
		
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		/*创建表格*/
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("编号",new Vector<Integer>());
		model.addColumn("书名", new Vector<String>());
		model.addColumn("作者", new Vector<String>());
		model.addColumn("是否选中", new Vector<String>());
		
		table = new JTable(model);
		JScrollPane jp = new JScrollPane(table);
		for(int i = 0;i < 20 ;i ++) {
			model.addRow(new Vector<String>());
		}
		

		JTableHeader head = table.getTableHeader();
		//设置表头的大小
		head.setPreferredSize(new Dimension(head.getWidth(),30));
		//设置表头字体大小
		head.setFont(new Font("宋体",Font.BOLD,16));
		//设置表格的行宽
		table.setRowHeight(30);
		//设置表格行中字体大小
		table.setFont(new Font("宋体",Font.ROMAN_BASELINE,13));
		/*设置表格中的内容居中*/
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		
		/*定义复选框*/
		JCheckBox box = new JCheckBox();
		
		/*getColumn()中数字填对应的第几行添加复选框*/
		table.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value,
					boolean isSelected, boolean hasFocus,int row, int column) {
				
				
				/*设置当复选框被选中整行被渲染*/
				box.setSelected(isSelected);
				/*设置复选框在单元格中居中*/
				box.setHorizontalAlignment((int) 0.5f);
				
				return box;
			}
			
		});
		
		
		this.add(jp);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		TableDemo t = new TableDemo();
	}
}
