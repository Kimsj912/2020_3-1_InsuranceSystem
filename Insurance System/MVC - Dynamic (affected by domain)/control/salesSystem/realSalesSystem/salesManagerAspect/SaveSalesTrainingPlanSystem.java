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
	private enum EInitializingCommands {mainTitle, title, salesTrainingTarget,salesTrainingPlace,salesTrainingGoal,salesTrainingContent, save,
		salesTrainingDate}
	
	
	// Association
	Map<String, JComponent> pocket;

	@Override
	public Vector<JComponent> getViewInfo() {
		
		this.pocket = new LinkedHashMap<String, JComponent>();
		
		JLabel mainTitleJLB = new JLabel("영업활동 계획을 입력해주세요");
		TitledTextArea titleTTA = new TitledTextArea("제목",2,"",true); 
		TitledTextArea salesTrainingDateTTA = new TitledTextArea("교육날짜(yyyy-MM-dd HH:mm)",1,"",true); 
		TitledTextArea salesTrainingPlaceTTA = new TitledTextArea("장소",1,"",true); 
		TitledRadioButtonGroup salesTrainingTargetTTA = new TitledRadioButtonGroup("교육대상",ETrainingTargetEmployee.class,true);
		TitledTextArea salesTrainingGoalTTA = new TitledTextArea("교육 목표",5,"",true);
		TitledTextArea salesTrainingContentTTA = new TitledTextArea("교육내용",15,"",true); 
		BasicButton saveBtn = new BasicButton("저장", EActionCommands.Save.name(), this.actionListener);

		this.pocket.put(EInitializingCommands.mainTitle.name(),mainTitleJLB);
		this.pocket.put(EInitializingCommands.title.name(),titleTTA);
		this.pocket.put(EInitializingCommands.salesTrainingDate.name(), salesTrainingDateTTA);
		this.pocket.put(EInitializingCommands.salesTrainingTarget.name(),salesTrainingTargetTTA);
		this.pocket.put(EInitializingCommands.salesTrainingPlace.name(),salesTrainingPlaceTTA);
		this.pocket.put(EInitializingCommands.salesTrainingGoal.name(),salesTrainingGoalTTA);
		this.pocket.put(EInitializingCommands.salesTrainingContent.name(),salesTrainingContentTTA);
		this.pocket.put(EInitializingCommands.save.name(),saveBtn);

		Vector<JComponent> viewInfo = new Vector<JComponent>();
		for(JComponent viewComponent : pocket.values()) {
			viewInfo.add(viewComponent);
		}
		
		return viewInfo;
	}
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			if(this.save()) {
            JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
			this.pocket.clear();
            this.gotoBack(); 
			break;
			}
		}
		return null;
	}
	
	public boolean save() {
		try {
		SalesTrainingPlanData data=new SalesTrainingPlanData();
		data.setTitle(((TitledTextArea)this.pocket.get(EInitializingCommands.title.name())).getContent());
		data.setDate(extractDate(((TitledTextArea)this.pocket.get(EInitializingCommands.salesTrainingDate.name())).getContent()));
		data.setPlace(((TitledTextArea)this.pocket.get(EInitializingCommands.salesTrainingPlace.name())).getContent());
		data.setGoal(((TitledTextArea)this.pocket.get(EInitializingCommands.salesTrainingGoal.name())).getContent());
		data.setContent(((TitledTextArea)this.pocket.get(EInitializingCommands.salesTrainingContent.name())).getContent());
		data.setTarget(cleaningTargetCustomerRadioBtn(((TitledRadioButtonGroup)this.pocket.get(EInitializingCommands.salesTrainingTarget.name())).getSelectedOptionNames()));
		
		this.salesTrainigPlanList.add(data);
		}catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(this.panel, "입력 내용을 다시한번 확인해주십시오.");
			return false;
		}
		return true;
	}
	private LocalDateTime extractDate(String content) {
		return LocalDateTime.parse(content, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

	}
	public Vector<ETrainingTargetEmployee> cleaningTargetCustomerRadioBtn(Vector<String> names) {
		Vector<ETrainingTargetEmployee> enumtmp = new Vector<ETrainingTargetEmployee>();
		for (String s : names) {
			for (ETrainingTargetEmployee aEnum : ETrainingTargetEmployee.values()) {
				if (aEnum.toString().equals(s)) enumtmp.add(aEnum);
			}
		}
		return enumtmp;
	}
}
