package control.salesSystem.realSalesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.aConstant.ETargetCustomer;
import model.data.activityPlanData.ActivityPlanData;
import view.component.BasicButton;
import view.component.TitledRadioButtonGroup;
import view.component.TitledTextArea;

public class SaveActivityPlanSystem extends SalesSystem {

	// Static
	private enum EActionCommands {Save}
		
	private enum EInitializingCommands {
		title, mainTitle, date, activityGoal, salesGoal, additionalJobOffer, salesTargetCustomer, save};
	
	
	private JLabel mainTitleJLB;
	private TitledTextArea titleTTA;
	private TitledTextArea activityGoalTTA;
	private TitledTextArea dateTTA;
	private TitledTextArea salesGoalTTA;
	private TitledTextArea additionalJobOfferTTA;
	private TitledRadioButtonGroup salesTargetCustomerTTA;
	private BasicButton saveBTN;

	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();

		this.mainTitleJLB = new JLabel("활동계획란을 작성하여 주세요.");
		this.titleTTA = new TitledTextArea("제목",2,"",true); //int
		this.dateTTA = new TitledTextArea("활동목표기간(yyyy-MM-dd)",1,"",true); 
		this.salesGoalTTA = new TitledTextArea("전체 매출 목표",1,"",true); 
		this.activityGoalTTA = new TitledTextArea("전체 활동 목표",10,"",true);
		this.additionalJobOfferTTA = new TitledTextArea("추가 구인 필요량",1,"",true); //int
		this.salesTargetCustomerTTA = new TitledRadioButtonGroup("주력 고객 선정",ETargetCustomer.class,false);
		this.saveBTN = new BasicButton("저장", EActionCommands.Save.name(), this.actionListener);

		viewInfo.add(mainTitleJLB);
		viewInfo.add(titleTTA);
		viewInfo.add(dateTTA);
		viewInfo.add(salesGoalTTA);
		viewInfo.add(activityGoalTTA);
		viewInfo.add(additionalJobOfferTTA);
		viewInfo.add(salesTargetCustomerTTA);
		viewInfo.add(saveBTN);

		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			if(this.save()) { 
            JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
            this.gotoBack(); 
			}
			break;
		}
		return null;
	}
	private boolean save() {
		try {
		ActivityPlanData data = new ActivityPlanData();
		data.setTitle(this.titleTTA.getContent());
		data.setSalesDuration(LocalDate.parse(this.dateTTA.getContent()));
		data.setSalesGoal(Integer.parseInt(this.salesGoalTTA.getContent()));
		data.setActivityGoal(this.activityGoalTTA.getContent());
		data.setAdditionalJobOffer(Integer.parseInt(this.additionalJobOfferTTA.getContent()));
		data.setSalesTargetCustomer(radioBtnCleaner(this.salesTargetCustomerTTA.getSelectedOptionNames()));
		
		this.activityPlanList.add(data);
		}catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(this.panel, "입력 내용을 다시한번 확인해주십시오.");
			return false;
		}
		return true;
	}
	public Vector<ETargetCustomer> radioBtnCleaner(Vector<String> s) {
		Vector<ETargetCustomer> vect = new Vector<ETargetCustomer>();
		for(int i=0;i<s.size();i++) {
			vect.add(ETargetCustomer.valueOf(s.get(i)));
		}
		return vect;
	}
}
