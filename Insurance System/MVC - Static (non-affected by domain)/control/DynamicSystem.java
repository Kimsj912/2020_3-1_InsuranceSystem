package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JPanel;

import model.data.ISData;
import model.dataList.IntISDataList;
import view.aConstant.ViewConstant;

public abstract class DynamicSystem {
	
	// Association
	protected ActionListener actionListener;
	protected JPanel panel;
	
	// Initialize Time Use
	public abstract void associateModel(Vector<IntISDataList<? extends ISData>> datas); 
	public void associateActionListener(ActionListener actionListener) {this.actionListener=actionListener;}
	public void associatePanel(JPanel panel) {this.panel=panel;}
	
	// Any Time Use
	public abstract Vector<JComponent> getViewInfo();
	public abstract DynamicSystem processEvent(ActionEvent e);
	public void gotoBack() {this.actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ViewConstant.BackButtonIdentifier));}
}
