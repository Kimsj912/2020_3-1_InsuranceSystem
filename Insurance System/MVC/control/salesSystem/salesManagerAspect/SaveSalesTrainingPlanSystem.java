package control.salesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.aConstant.ETrainingTargetEmployee;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import view.insuranceSystemView.salesView.salesManager.SaveSalesTrainingPlanView;
import view.panel.BasicPanel;

public class SaveSalesTrainingPlanSystem extends SalesSystem {
	// Static
	public enum EActionCommands {Save, SaveActivityPlan, SaveSalesTrainingPlan}
		
	private SaveSalesTrainingPlanView view;
	@Override
	public BasicPanel getPanel() {
		this.view = new SaveSalesTrainingPlanView(this.actionListener);
		return this.view;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save:
			if (this.save()) {
				JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.", "SaveInsuranceData",
						JOptionPane.INFORMATION_MESSAGE);
				this.gotoBack(); 
			}
			break;
		case SaveActivityPlan:
			return new SaveActivityPlanSystem();
		case SaveSalesTrainingPlan:
			return new SaveSalesTrainingPlanSystem();
		}
		return null;
	}

	public boolean save() {
		try {
		SalesTrainingPlanData data=new SalesTrainingPlanData();
		
		if(this.view.getTitleTTA().getContent()!="") {data.setTitle(this.view.getTitleTTA().getContent());}else {throw new NullTitleException();}
		
		data.setDate(LocalDateTime.parse(this.view.getSalesTrainingDateTTA().getContent(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		
		if(this.view.getSalesTrainingPlaceTTA().getContent()!="") {data.setPlace(this.view.getSalesTrainingPlaceTTA().getContent());}
		else {throw new NullPlaceException();}
		
		if(this.view.getSalesTrainingGoalTTA().getContent()!="") {data.setGoal(this.view.getSalesTrainingGoalTTA().getContent());}
		else {throw new NullGoalException();}
		
		if(this.view.getSalesTrainingContentTTA().getContent()!="") {data.setContent(this.view.getSalesTrainingContentTTA().getContent());}
		else {throw new NullContentException();}
		
		data.setTarget(multipleChoice(ETrainingTargetEmployee.class,this.view.getSalesTrainingTargetTTA().getSelectedOptionNames()));
		
		this.salesTrainigPlanList.add(data);
		
		} catch (NullTitleException e) {JOptionPane.showMessageDialog(this.view, "제목이 입력되지 않았습니다. 다시한번 확인해주십시오.");return false;
		} catch (DateTimeParseException e) {JOptionPane.showMessageDialog(this.view, "날짜 입력에 오류가 있습니다. 다시한번 확인해주십시오.");return false;
		} catch (NullPlaceException e) {JOptionPane.showMessageDialog(this.view, "장소가 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
		} catch (NullGoalException e) {JOptionPane.showMessageDialog(this.view, "목표가 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
		} catch (NullContentException e) {JOptionPane.showMessageDialog(this.view, "내용이 입력되지 않았습니다. 다시한번 확인해주십시오.");return false;
		} catch (NullTargetException e) {JOptionPane.showMessageDialog(this.view, "타겟이 선택되지 않았습니다. 다시한번 확인해주십시오.");return false;
		} 
		return true;
	}
	private <E> Vector<E> multipleChoice(Class<E> enumClass, Vector<String> selectedOptionNames) throws NullTargetException {
		Vector<E> returnVect = new Vector<E>();
		if(selectedOptionNames.size()==0) throw new NullTargetException();
		for(String s : selectedOptionNames) {
			for(E e : enumClass.getEnumConstants()) {
				if(e.toString().equals(s)) {
					returnVect.add(e);
				}
			}
		}
		return returnVect;
	}
	public class NullTitleException extends Throwable{private static final long serialVersionUID = 1L;}
	public class NullTargetException extends Throwable{private static final long serialVersionUID = 1L;}
	public class NullPlaceException extends Throwable{private static final long serialVersionUID = 1L;}
	public class NullGoalException extends Throwable{private static final long serialVersionUID = 1L;}
	public class NullContentException extends Throwable{private static final long serialVersionUID = 1L;}
}
