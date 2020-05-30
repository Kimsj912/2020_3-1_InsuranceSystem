package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManAspect.LookupAvailableProduct.ShowAvailableProductSystem;
import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;
import model.dataList.IntISDataList;
import model.dataList.realDataList.ISDataList;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.DynamicGroup;
import view.insuranceSystemView.InsuranceSystemView;

public class ShowAvailableProductView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;
	private CustomerData customerData;
	
	public ShowAvailableProductView(ActionListener actionListener, IntISDataList<AbsInsuranceData> insuranceDataList, CustomerData customerData) {
		this.customerData = customerData;
		
		this.addComponent(new BasicLabel("보험 선택"));
		this.addComponent(new SeparateLine(Color.black));
		
		// 보험명 (내용 10자리 + ...)
		DynamicGroup g =new DynamicGroup();
		for (AbsInsuranceData insuranceData : searching(insuranceDataList).getList()) {
			String content ="";
			if(insuranceData.getContent().length()>10) {content = insuranceData.getContent().substring(0, 10);}else { content = insuranceData.getContent();};
			String line = insuranceData.getName()+"("+content +")";
			g.addGroupComponent(new ActionButton(line, Integer.toString(insuranceData.getID()), actionListener));
		}
		this.addComponent(g);
		this.addToLinkPanel(
				new LinkButton("고객 가입", ShowAvailableProductSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", ShowAvailableProductSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", ShowAvailableProductSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", ShowAvailableProductSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	public IntISDataList<AbsInsuranceData> searching(IntISDataList<AbsInsuranceData> insuranceDataList) {
		IntISDataList<AbsInsuranceData> availableInsuranceList= new ISDataList<AbsInsuranceData>();
		for (AbsInsuranceData insuranceData : insuranceDataList.getList()) {
			if (!insuranceData.isCustomerSignIn(this.customerData.getID())
					&& insuranceData.getLossPercent() >= insuranceData.insuranceRateCheck(this.customerData)) {
				availableInsuranceList.add(insuranceData);
			}
		}
		return availableInsuranceList;
	}

}
