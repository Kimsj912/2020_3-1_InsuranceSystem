package StaticSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import control.DynamicSystem;
import data.ISData;
import dataList.IntISDataList;
import aConstant.ButtonConstant;
import frame.IntFrame;
import panel.BasicPanel;

public class StaticSystem {

	// Association
	private IntFrame mainFrame;
	
	// Component
	private ActionHandler actionListener;
	private Vector<DynamicSystem> history;
	private Vector<IntISDataList<? extends ISData>> datas;
	
	// Constructor
	public StaticSystem() {
		// Create Component
		this.actionListener = new ActionHandler();
		this.history = new Vector<DynamicSystem>();
		this.datas = new Vector<IntISDataList<? extends ISData>>(); 
	}
	
	// Initialize Time Use
	public void associateMainFrame(IntFrame mainFrame) {this.mainFrame=mainFrame;}
	public void associateModel(IntISDataList<? extends ISData> data) {this.datas.add(data);}
	
	// Any Time Use
	public void startNewDynamicSystem(DynamicSystem dynamicSystem) {
		if(dynamicSystem == null) {return;}
		this.history.add(dynamicSystem);
		dynamicSystem.associateActionListener(this.actionListener);
		dynamicSystem.associateModel(this.datas);
		this.show(dynamicSystem);
	}
	private void show(DynamicSystem dynamicSystem) {
		BasicPanel panel = dynamicSystem.getPanel();
		if(this.history.size() == 1) {panel.addEmptyToolSpace();}
		else {panel.addBackButton(this.actionListener);}
		this.mainFrame.showPanel(panel);
	}

	// Event Use
	private void gotoBack() {this.history.remove(this.history.lastElement()); this.show(this.history.lastElement());}
	private void gotoFirst() {DynamicSystem first = this.history.firstElement(); this.history.clear(); this.history.add(first); this.show(first);}
	
	// Inner Class
	private class ActionHandler implements ActionListener {
		@Override public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case ButtonConstant.BackButtonIdentifier : gotoBack(); break;
			case ButtonConstant.LogoutButtonIdentifier : gotoFirst(); break;
			default : startNewDynamicSystem(history.lastElement().processEvent(e)); break;
			}
		}
	}
}
