package control.salesSystem.realSalesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.aConstant.ETargetCustomer;
import model.aConstant.ETrainingTargetEmployee;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import view.component.BasicButton;
import view.component.TitledRadioButtonGroup;
import view.component.TitledTextArea;

public class SaveSalesTrainingPlanSystem extends SalesSystem {

	// Static
	private enum EActionCommands {Save}
	private TitledTextArea titleTTA;
	private TitledTextArea salesTrainingDateTTA;
	private TitledTextArea salesTrainingPlaceTTA;
	private TitledRadioButtonGroup salesTrainingTargetTTA;
	private TitledTextArea salesTrainingGoalTTA;
	private TitledTextArea salesTrainingContentTTA;

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("영업활동 계획을 입력해주세요"));
		this.titleTTA = new TitledTextArea("제목", 2, "", true);
		this.salesTrainingDateTTA = new TitledTextArea("교육날짜(yyyy-MM-dd HH:mm)", 1, "", true);
		this.salesTrainingPlaceTTA = new TitledTextArea("장소", 1, "", true);
		this.salesTrainingTargetTTA = new TitledRadioButtonGroup("교육대상", ETrainingTargetEmployee.class, true);
		this.salesTrainingGoalTTA = new TitledTextArea("교육 목표", 5, "", true);
		this.salesTrainingContentTTA = new TitledTextArea("교육내용", 15, "", true);

		viewInfo.add(this.titleTTA);
		viewInfo.add(this.salesTrainingDateTTA);
		viewInfo.add(this.salesTrainingPlaceTTA);
		viewInfo.add(this.salesTrainingTargetTTA);
		viewInfo.add(this.salesTrainingGoalTTA);
		viewInfo.add(this.salesTrainingContentTTA);

		viewInfo.add(new BasicButton("저장", EActionCommands.Save.name(), this.actionListener));
		return viewInfo;
	}
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			if(this.save()) {
            JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
            this.gotoBack(); 
			break;
			}
		}
		return null;
	}
	
	public boolean save() {
		try {
		SalesTrainingPlanData data=new SalesTrainingPlanData();
		data.setTitle(this.titleTTA.getContent());
		data.setDate(LocalDateTime.parse(this.salesTrainingDateTTA.getContent(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		data.setPlace(this.salesTrainingPlaceTTA.getContent());
		data.setGoal(this.salesTrainingGoalTTA.getContent());
		data.setContent(this.salesTrainingContentTTA.getContent());
		data.setTarget(radioBtnCleaner(this.salesTrainingTargetTTA.getSelectedOptionNames()));
		
		this.salesTrainigPlanList.add(data);
		}catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(this.panel, "입력 내용을 다시한번 확인해주십시오.");
			return false;
		}
		return true;
	}
	public Vector<ETrainingTargetEmployee> radioBtnCleaner(Vector<String> s) {
		Vector<ETrainingTargetEmployee> vect = new Vector<ETrainingTargetEmployee>();
		for(int i=0;i<s.size();i++) {
			vect.add(ETrainingTargetEmployee.valueOf(s.get(i)));
		}
		return vect;
	}
}
