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
		
		viewInfo.add(new JLabel("����Ȱ�� ��ȹ�� �Է����ּ���"));
		this.titleTTA = new TitledTextArea("����", 2, "", true);
		this.salesTrainingDateTTA = new TitledTextArea("������¥(yyyy-MM-dd HH:mm)", 1, "", true);
		this.salesTrainingPlaceTTA = new TitledTextArea("���", 1, "", true);
		this.salesTrainingTargetTTA = new TitledRadioButtonGroup("�������", ETrainingTargetEmployee.class, true);
		this.salesTrainingGoalTTA = new TitledTextArea("���� ��ǥ", 5, "", true);
		this.salesTrainingContentTTA = new TitledTextArea("��������", 15, "", true);

		viewInfo.add(this.titleTTA);
		viewInfo.add(this.salesTrainingDateTTA);
		viewInfo.add(this.salesTrainingPlaceTTA);
		viewInfo.add(this.salesTrainingTargetTTA);
		viewInfo.add(this.salesTrainingGoalTTA);
		viewInfo.add(this.salesTrainingContentTTA);

		viewInfo.add(new BasicButton("����", EActionCommands.Save.name(), this.actionListener));
		return viewInfo;
	}
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			if(this.save()) {
            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
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
			JOptionPane.showMessageDialog(this.panel, "�Է� ������ �ٽ��ѹ� Ȯ�����ֽʽÿ�.");
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
