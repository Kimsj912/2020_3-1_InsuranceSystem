package control.salesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.aConstant.ETargetCustomer;
import model.data.activityPlanData.ActivityPlanData;
import view.insuranceSystemView.salesView.salesManager.SaveActivityPlanView;
import panel.BasicPanel;

public class SaveActivityPlanSystem extends SalesSystem {
	// Static
	public enum EActionCommands {Save, SaveActivityPlan, SaveSalesTrainingPlan}
	// Component
	private SaveActivityPlanView view;

	@Override
	public BasicPanel getPanel() {
		this.view = new SaveActivityPlanView(this.actionListener);
		return this.view;
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
		case SaveActivityPlan: return new SaveActivityPlanSystem();
		case SaveSalesTrainingPlan: return new SaveSalesTrainingPlanSystem();
		}
		return null;
	}
	private boolean save() {
		try {
		ActivityPlanData data = new ActivityPlanData();
		
		if(this.view.getTitleTTA().getContent()!="") {data.setTitle(this.view.getTitleTTA().getContent());}else {throw new NullTitleException();	}
		data.setSalesDuration(LocalDate.parse(this.view.getDateTTA().getContent()));
		if(this.view.getSalesGoalTTA().getContent()!="") {data.setSalesGoal(Integer.parseInt(this.view.getSalesGoalTTA().getContent()));}else {throw new NullSalesGoalException();	}
		if(this.view.getActivityGoalTTA().getContent()!="") {data.setActivityGoal(this.view.getActivityGoalTTA().getContent());}else {throw new NullActivityGoalException();	}
		data.setAdditionalJobOffer(Integer.parseInt(this.view.getAdditionalJobOfferTTA().getContent()));
		data.setSalesTargetCustomer(radioBtnCleaner(this.view.getSalesTargetCustomerTTA().getSelectedOptionNames()));
		this.activityPlanList.add(data);
		} catch(DateTimeParseException e) {JOptionPane.showMessageDialog(this.view, "��¥ �Է¿� ������ �ֽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		} catch (NullTitleException e) {JOptionPane.showMessageDialog(this.view, "������ �Էµ��� �ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		} catch (NullSalesGoalException e) {JOptionPane.showMessageDialog(this.view, "�Ǹ� ��ǥ�� �Էµ����ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		} catch (NullActivityGoalException e) {JOptionPane.showMessageDialog(this.view, "Ȱ����ǥ�� �Էµ����ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		} catch (NullTargetException e) {JOptionPane.showMessageDialog(this.view, "�ַ� ���� ���õ��� �ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		} catch (NumberFormatException e) {JOptionPane.showMessageDialog(this.view, "�ùٸ��� ���� �߰� ���η� ���� �ԷµǾ����ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		} 
		return true;
	}
	public Vector<ETargetCustomer> radioBtnCleaner(Vector<String> s) throws NullTargetException {
		Vector<ETargetCustomer> vect = new Vector<ETargetCustomer>();
		if(s.size()==0)throw new NullTargetException();
		for(int i=0;i<s.size();i++) {vect.add(ETargetCustomer.valueOf(s.get(i)));}
		return vect;
	}

	public class NullTitleException extends Throwable{private static final long serialVersionUID = 1L;}
	public class NullSalesGoalException extends Throwable{private static final long serialVersionUID = 1L;}
	public class NullActivityGoalException extends Throwable{private static final long serialVersionUID = 1L;}
	public class NullTargetException extends Throwable{private static final long serialVersionUID = 1L;}
}
