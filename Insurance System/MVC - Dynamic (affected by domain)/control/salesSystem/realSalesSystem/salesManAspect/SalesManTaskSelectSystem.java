package control.salesSystem.realSalesSystem.salesManAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.realSalesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.realSalesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.realSalesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.realSalesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import view.component.BasicButton;

public class SalesManTaskSelectSystem extends SalesSystem {

	// Static
	private enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}

	@Override
	public Vector<JComponent> getViewInfo() {
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("원하시는 업무를 선택하세요."));
		viewInfo.add(new BasicButton("고객 가입시키기", EActionCommands.SigninCustomer.name(), this.actionListener));
		viewInfo.add(new BasicButton("가입 가능한 보험 조회", EActionCommands.LookupAvailableProduct.name(), this.actionListener));
		viewInfo.add(new BasicButton("판매 활동 계획 조회하기", EActionCommands.WatchActivityPlan.name(), this.actionListener));
		viewInfo.add(new BasicButton("영업 활동 조회하기", EActionCommands.WatchSalesTrainingPlan.name(), this.actionListener));
		return viewInfo;
	}
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
}
