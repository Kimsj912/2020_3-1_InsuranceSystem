package control.salesSystem.realSalesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.aConstant.EAccidentHistory;
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
	
	
	Map<String, JComponent> pocket;

	
	@Override
	public Vector<JComponent> getViewInfo() {
		this.pocket = new LinkedHashMap<String, JComponent>();

		JLabel mainTitleJLB = new JLabel("Ȱ����ȹ���� �ۼ��Ͽ� �ּ���.");
		TitledTextArea titleTTA = new TitledTextArea("����",2,"",true); //int
		TitledTextArea dateTTA = new TitledTextArea("Ȱ����ǥ�Ⱓ(yyyy-MM-dd)",1,"",true); 
		TitledTextArea salesGoalTTA = new TitledTextArea("��ü ���� ��ǥ",1,"",true); 
		TitledTextArea activityGoalTTA = new TitledTextArea("��ü Ȱ�� ��ǥ",10,"",true);
		TitledTextArea additionalJobOfferTTA = new TitledTextArea("�߰� ���� �ʿ䷮",1,"",true); //int
		TitledRadioButtonGroup salesTargetCustomerTTA = new TitledRadioButtonGroup("�ַ� �� ����",ETargetCustomer.class,false);
		BasicButton saveBTN = new BasicButton("����", EActionCommands.Save.name(), this.actionListener);

		
		this.pocket.put(EInitializingCommands.mainTitle.name(),mainTitleJLB);
		this.pocket.put(EInitializingCommands.title.name(),titleTTA);
		this.pocket.put(EInitializingCommands.date.name(),dateTTA);
		this.pocket.put(EInitializingCommands.salesGoal.name(),salesGoalTTA);
		this.pocket.put(EInitializingCommands.activityGoal.name(),activityGoalTTA);
		this.pocket.put(EInitializingCommands.additionalJobOffer.name(),additionalJobOfferTTA);
		this.pocket.put(EInitializingCommands.salesTargetCustomer.name(),salesTargetCustomerTTA);
		this.pocket.put(EInitializingCommands.save.name(),saveBTN);
		
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
            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
			this.pocket.clear();
            this.gotoBack(); 
			}
			break;
		}
		return null;
	}
	private boolean save() {
		try {
		ActivityPlanData data = new ActivityPlanData();
		data.setTitle(((TitledTextArea)this.pocket.get(EInitializingCommands.title.name())).getContent());
		data.setSalesDuration(extractDate(((TitledTextArea)this.pocket.get(EInitializingCommands.date.name())).getContent()));
		data.setSalesGoal(Integer.parseInt(((TitledTextArea)this.pocket.get(EInitializingCommands.salesGoal.name())).getContent()));
		data.setActivityGoal(((TitledTextArea)this.pocket.get(EInitializingCommands.activityGoal.name())).getContent());
		data.setAdditionalJobOffer(Integer.parseInt(((TitledTextArea)this.pocket.get(EInitializingCommands.additionalJobOffer.name())).getContent()));
		data.setSalesTargetCustomer(
				cleaningTargetCustomerRadioBtn(((TitledRadioButtonGroup)this.pocket.get(EInitializingCommands.salesTargetCustomer.name())).getSelectedOptionNames()));
		
		this.activityPlanList.add(data);
		}catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(this.panel, "�Է� ������ �ٽ��ѹ� Ȯ�����ֽʽÿ�.");
			return false;
		}
		return true;
	}
	private LocalDate extractDate(String content) {
		return LocalDate.parse(content);

	}
	public Vector<ETargetCustomer> cleaningTargetCustomerRadioBtn(Vector<String> names) {
		Vector<ETargetCustomer> enumtmp = new Vector<ETargetCustomer>();
		for (String s : names) {
			for (ETargetCustomer aEnum : ETargetCustomer.values()) {
				if (aEnum.toString().equals(s)) enumtmp.add(aEnum);
			}
		}
		return enumtmp;
	}
}
