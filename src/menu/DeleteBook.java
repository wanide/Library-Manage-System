package menu;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import database.BookData;
import database.ManageBook;


public class DeleteBook {
	public DeleteBook(DefaultTableModel model,int id,String name){
		Object[] options = {"确定" , "取消"};
		int m = JOptionPane.showOptionDialog(null, "确定删除"+name+"?", "删除", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(m==0) {
			ManageBook mb = new ManageBook();
			try {
				mb.delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BookData bd = new BookData();
			try {
				model.setRowCount(0);
				bd.selectAll(model);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
