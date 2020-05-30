package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManAspect.LookupAvailableProduct.ShowInsuranceInfoToCustomerSystem;
import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import model.dataList.IntISDataList;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.BasicButton;
import view.component.button.LinkButton;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class ShowInsuranceInfoToCustomerView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Attribute
	private int insuranceID;

	public ShowInsuranceInfoToCustomerView(ActionListener actionListener, IntISDataList<AbsInsuranceData> insuranceDataList, int insuranceID, CustomerData customerData) {
		AbsInsuranceData searchedInsuranceData = insuranceDataList.search(this.insuranceID);
		
		this.addComponent(new BasicLabel("고객님이 가입하실 수 있는 보험 정보 입니다."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("아이디",  Integer.toString(searchedInsuranceData.getID())));
		this.addComponent(new OutputTextArea("보험명", searchedInsuranceData.getName()));
		if(searchedInsuranceData instanceof DiseaseInsuranceData) {
			this.addComponent(new OutputTextArea("보상 질병", ((DiseaseInsuranceData)searchedInsuranceData).getDisease().name()));
		
		this.addComponent(new OutputTextArea("내용",  searchedInsuranceData.getContent()));
		this.addComponent(new OutputTextArea("보험요율",  searchedInsuranceData.getInsuranceRateInfo()));
		// 클다엔 이익, 계약조건(보험금, 보험료, 보험금 지불 만기일, 보험료 지불일)이 더있는데 여긴 없다.

		this.addComponent(new BasicButton("보험 가입", ShowInsuranceInfoToCustomerSystem.EActionCommands.SigninProduct.name(), actionListener));
	
		this.addToLinkPanel(
				new LinkButton("고객 가입", ShowInsuranceInfoToCustomerSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", ShowInsuranceInfoToCustomerSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", ShowInsuranceInfoToCustomerSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", ShowInsuranceInfoToCustomerSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
	}

}
