package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import model.data.ISData;
import model.dataList.IntISDataList;
import view.aConstant.ButtonConstant;
import view.panel.BasicPanel;

public abstract class DynamicSystem {
	
	// Association
	protected ActionListener actionListener;
	
	// Initialize Time Use
	public abstract void associateModel(Vector<IntISDataList<? extends ISData>> datas); 
	public void associateActionListener(ActionListener actionListener) {this.actionListener=actionListener;}
	
	// Any Time Use
	public abstract BasicPanel getPanel();
	public abstract DynamicSystem processEvent(ActionEvent e);
	public void gotoBack() {this.actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ButtonConstant.BackButtonIdentifier));}
}
