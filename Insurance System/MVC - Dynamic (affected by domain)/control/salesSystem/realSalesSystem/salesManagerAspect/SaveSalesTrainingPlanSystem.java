package control.salesSystem.realSalesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class SaveSalesTrainingPlanSystem extends SalesSystem {

	// Static
	private enum EActionCommands {Save}
		
	/*date type인 salesDuration때문에 3개를 받음.*/
	private TitledTextArea titleTTA = new TitledTextArea("제목",2,"",true); //int
	private TitledTextArea salesTraining_yearTTA = new TitledTextArea("연도(YYYY)",3,"",true); 
	private TitledTextArea salesTraining_monthTTA = new TitledTextArea("월(MM)",3,"",true);
	private TitledTextArea salesTraining_dayTTA = new TitledTextArea("일(dd)",3,"",true);
	private TitledTextArea salesTraining_hourTTA = new TitledTextArea("시(hh)",3,"",true); 
	private TitledTextArea salesTraining_minTTA = new TitledTextArea("분(mm)",3,"",true);
	
	private TitledTextArea salesTrainingTargetTTA = new TitledTextArea("교육대상",3,"",true);
	private TitledTextArea salesTrainingPlanceTTA = new TitledTextArea("장소",1,"",true); //int
	private TitledTextArea salesTrainingGoalTTA = new TitledTextArea("교육 목표",5,"",true);
	private TitledTextArea salesTrainingContentTTA = new TitledTextArea("교육내용",15,"",true); //int
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("활동계획란"));
		viewInfo.add(this.titleTTA);
		viewInfo.add(this.salesTraining_yearTTA);
		viewInfo.add(this.salesTraining_monthTTA);
		viewInfo.add(this.salesTraining_dayTTA);
		viewInfo.add(this.salesTraining_hourTTA);
		viewInfo.add(this.salesTraining_minTTA);
		viewInfo.add(this.salesTrainingTargetTTA);
		viewInfo.add(this.salesTrainingPlanceTTA);
		viewInfo.add(this.salesTrainingGoalTTA);
		viewInfo.add(this.salesTrainingContentTTA);
		
		viewInfo.add(new BasicButton("저장", EActionCommands.Save.name(), this.actionListener));

		return viewInfo;
	}
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			this.save(); 
            JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
			this.gotoBack(); 
			break;
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public void save() {
		SalesTrainingPlanData data=new SalesTrainingPlanData();
		data.setTitle(this.titleTTA.getContent());
		Date salesTrainingdate = new Date();
		salesTrainingdate.setYear(Integer.parseInt(salesTraining_yearTTA.getContent()));
		salesTrainingdate.setMonth(Integer.parseInt(salesTraining_monthTTA.getContent()));
		salesTrainingdate.setDate(Integer.parseInt(salesTraining_dayTTA.getContent()));
		salesTrainingdate.setHours(Integer.parseInt(salesTraining_hourTTA.getContent()));
		salesTrainingdate.setMinutes(Integer.parseInt(salesTraining_minTTA.getContent()));

		// target을 어떻게 처리해야할지 모르겠음.
		data.setDate(salesTrainingdate);
		data.setPlace(this.salesTrainingPlanceTTA.getContent());
		data.setGoal(this.salesTrainingGoalTTA.getContent());
		data.setContent(this.salesTrainingContentTTA.getContent());
		data.setTarget(this.salesTrainingTargetTTA.getContent());
		
		this.salesTrainigPlanList.add(data);
	}
}
