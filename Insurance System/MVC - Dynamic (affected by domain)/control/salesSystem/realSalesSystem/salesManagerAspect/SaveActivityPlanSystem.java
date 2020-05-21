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

		this.mainTitleJLB = new JLabel("Ȱ����ȹ���� �ۼ��Ͽ� �ּ���.");
		this.titleTTA = new TitledTextArea("����",2,"",true); //int
		this.dateTTA = new TitledTextArea("Ȱ����ǥ�Ⱓ(yyyy-MM-dd)",1,"",true); 
		this.salesGoalTTA = new TitledTextArea("��ü ���� ��ǥ",1,"",true); 
		this.activityGoalTTA = new TitledTextArea("��ü Ȱ�� ��ǥ",10,"",true);
		this.additionalJobOfferTTA = new TitledTextArea("�߰� ���� �ʿ䷮",1,"",true); //int
		this.salesTargetCustomerTTA = new TitledRadioButtonGroup("�ַ� �� ����",ETargetCustomer.class,false);
		this.saveBTN = new BasicButton("����", EActionCommands.Save.name(), this.actionListener);

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
            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(this.panel, "�Է� ������ �ٽ��ѹ� Ȯ�����ֽʽÿ�.");
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
