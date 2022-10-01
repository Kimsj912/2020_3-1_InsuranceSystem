package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import control.salesSystem.salesManAspect.LookupAvailableProduct.ShowCustomerInfoSystem;
import model.data.customerData.CustomerData;
import dataList.IntISDataList;
import component.BasicLabel;
import component.SeparateLine;
import component.button.LinkButton;
import component.button.SelectButton;
import component.group.DynamicGroup;
import component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class ShowCustomerInfoView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;
	
	public ShowCustomerInfoView(ActionListener actionListener, IntISDataList<CustomerData> searchedCustomerList, InputTextArea searchedNameTTA) {
		this.addComponent(new BasicLabel("고객 조회 결과"));
		this.addComponent(new SeparateLine(Color.black));

		if (searchedCustomerList.getList().isEmpty()) {
			this.addComponent(new JLabel("요청하신 "+searchedNameTTA.getContent() + " 님은 시스템에 존재하지 않습니다. 다시한번 확인해주십시오"));
		} else {
			this.addComponent(new JLabel("요청하신 "+ searchedNameTTA.getContent() + "님 명단입니다."));
			// 홍길동 님 (남, 22세, 990618-1)로 출력하도록 변경
			DynamicGroup g = new DynamicGroup();
			for (CustomerData customerData : searchedCustomerList.getList()) {
				g.addGroupComponent(new SelectButton(printline(customerData),Integer.toString(customerData.getID()), actionListener));
			}
			this.addComponent(g);
		}
		this.addToLinkPanel(
				new LinkButton("고객 가입", ShowCustomerInfoSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", ShowCustomerInfoSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", ShowCustomerInfoSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", ShowCustomerInfoSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	private String printline(CustomerData customerData) {
		String returnVal ="";
		String name =customerData.getName();
		String gender = customerData.isMale() ? "남": "여";
		String age = Integer.toString(customerData.getAge());
		String socialSecNum = customerData.getSocialSecurityNum().substring(0, 8);
		returnVal = name+" 님 ("+gender+", "+age+"세, "+socialSecNum+")";
		return returnVal;
		
	}


}
