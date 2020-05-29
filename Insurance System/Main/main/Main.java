package main;

import java.util.Vector;

import control.StaticSystem;
import control.loginSystem.RealLoginSystem;
import model.data.ISData;
import model.dataList.IntISDataList;
import test.TestModelCreator;
import view.frame.realFrame.MainFrame;

public class Main {

	public static void main(String[] args) {
		// Create Model
		Vector<IntISDataList<? extends ISData>> models = TestModelCreator.createTestModel();
		
		// Create View
		MainFrame view = new MainFrame();
		
		// Create Control
		StaticSystem system = new StaticSystem();
		
		// Associate Model to Control
		for(IntISDataList<? extends ISData> model : models) {system.associateModel(model);}
		
		// Associate View to Control
		system.associateMainFrame(view);
		
		// Start
		system.startNewDynamicSystem(new RealLoginSystem());
		view.setVisible(true);
	}
}
