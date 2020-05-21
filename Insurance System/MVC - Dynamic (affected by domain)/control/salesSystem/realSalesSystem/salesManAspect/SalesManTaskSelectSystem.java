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
		viewInfo.add(new JLabel("���Ͻô� ������ �����ϼ���."));
		viewInfo.add(new BasicButton("�� ���Խ�Ű��", EActionCommands.SigninCustomer.name(), this.actionListener));
		viewInfo.add(new BasicButton("���� ������ ���� ��ȸ", EActionCommands.LookupAvailableProduct.name(), this.actionListener));
		viewInfo.add(new BasicButton("�Ǹ� Ȱ�� ��ȹ ��ȸ�ϱ�", EActionCommands.WatchActivityPlan.name(), this.actionListener));
		viewInfo.add(new BasicButton("���� Ȱ�� ��ȸ�ϱ�", EActionCommands.WatchSalesTrainingPlan.name(), this.actionListener));
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
