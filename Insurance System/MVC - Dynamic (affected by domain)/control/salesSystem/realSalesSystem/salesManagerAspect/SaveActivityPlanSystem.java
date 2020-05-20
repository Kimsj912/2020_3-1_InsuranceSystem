package control.salesSystem.realSalesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.data.activityPlanData.ActivityPlanData;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class SaveActivityPlanSystem extends SalesSystem {

	// Static
	private enum EActionCommands {Save}
		
	/*date type�� salesDuration������ 3���� ����.*/
	private TitledTextArea titleTTA = new TitledTextArea("����",2,"",true); //int
	private TitledTextArea salesDuration_yearTTA = new TitledTextArea("Ȱ������(YYYY)",1,"",true); //int
	private TitledTextArea salesDuration_monthTTA = new TitledTextArea("Ȱ����(MM)",1,"",true); //int
	private TitledTextArea salesDuration_dayTTA = new TitledTextArea("Ȱ����(dd)",1,"",true); //int
	private TitledTextArea salesGoalTTA = new TitledTextArea("��ü ���� ��ǥ",1,"",true); //int
	private TitledTextArea activityGoalTTA = new TitledTextArea("��ü Ȱ�� ��ǥ",10,"",true);
	private TitledTextArea additionalJobOfferTTA = new TitledTextArea("�߰� ���� �ʿ䷮",1,"",true); //int
	private TitledTextArea salesTargetCustomerTTA = new TitledTextArea("�ַ� �� ����",3,"",true);
	
	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		
		viewInfo.add(new JLabel("Ȱ����ȹ���� �ۼ��Ͽ� �ּ���."));
		viewInfo.add(this.titleTTA);
		viewInfo.add(this.salesDuration_yearTTA);
		viewInfo.add(this.salesDuration_monthTTA);
		viewInfo.add(this.salesDuration_dayTTA);
		viewInfo.add(this.salesGoalTTA);
		viewInfo.add(this.activityGoalTTA);
		viewInfo.add(this.additionalJobOfferTTA);
		viewInfo.add(this.salesTargetCustomerTTA);
		
		viewInfo.add(new BasicButton("����", EActionCommands.Save.name(), this.actionListener));

		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			this.save(); 
            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
			this.gotoBack(); 
			break;
		}
		return null;
	}
	@SuppressWarnings("deprecation")
	private void save() {
		ActivityPlanData data = new ActivityPlanData();
		data.setTitle(this.titleTTA.getContent());
		Date durationdate = new Date();
		durationdate.setYear(Integer.parseInt(salesDuration_yearTTA.getContent()));
		durationdate.setMonth(Integer.parseInt(salesDuration_monthTTA.getContent()));
		durationdate.setDate(Integer.parseInt(salesDuration_dayTTA.getContent()));
		data.setSalesDuration(durationdate);
		data.setSalesGoal(Integer.parseInt(this.salesGoalTTA.getContent()));
		data.setActivityGoal(this.activityGoalTTA.getContent());
		data.setAdditionalJobOffer(Integer.parseInt(this.additionalJobOfferTTA.getContent()));
		data.setSalesTargetCustomer(this.salesTargetCustomerTTA.getContent());
		
		this.activityPlanList.add(data);
		
	}
}
