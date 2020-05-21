package view.component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BasicTable extends JTable {
	private static final long serialVersionUID = 1L;
	
	public BasicTable(String[][] contents, String[] header) {
		new JTable(new DefaultTableModel());
		
	}
}
