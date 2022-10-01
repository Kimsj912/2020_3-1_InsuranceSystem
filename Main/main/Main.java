package main;

import StaticSystem.StaticSystem;
import control.loginSystem.RealLoginSystem;
import data.ISData;
import dataList.IntISDataList;
import frame.realFrame.MainFrame;
import test.TestModelCreator;

import java.util.Vector;

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
