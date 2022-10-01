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
            JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.", "SaveInsuranceData", JOptionPane.INFORMATION_MESSAGE);
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
		} catch(DateTimeParseException e) {JOptionPane.showMessageDialog(this.view, "날짜 입력에 오류가 있습니다. 다시한번 확인해주십시오.");return false;
		} catch (NullTitleException e) {JOptionPane.showMessageDialog(this.view, "제목이 입력되지 않았습니다. 다시한번 확인해주십시오.");return false;
		} catch (NullSalesGoalException e) {JOptionPane.showMessageDialog(this.view, "판매 목표가 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
		} catch (NullActivityGoalException e) {JOptionPane.showMessageDialog(this.view, "활동목표가 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
		} catch (NullTargetException e) {JOptionPane.showMessageDialog(this.view, "주력 고객이 선택되지 않았습니다. 다시한번 확인해주십시오.");return false;
		} catch (NumberFormatException e) {JOptionPane.showMessageDialog(this.view, "올바르지 않은 추가 구인량 값이 입력되었습니다. 다시한번 확인해주십시오.");return false;
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
