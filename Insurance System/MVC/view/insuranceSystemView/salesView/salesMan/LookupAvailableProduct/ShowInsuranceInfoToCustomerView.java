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
		
		this.addComponent(new BasicLabel("������ �����Ͻ� �� �ִ� ���� ���� �Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("���̵�",  Integer.toString(searchedInsuranceData.getID())));
		this.addComponent(new OutputTextArea("�����", searchedInsuranceData.getName()));
		if(searchedInsuranceData instanceof DiseaseInsuranceData) {
			this.addComponent(new OutputTextArea("���� ����", ((DiseaseInsuranceData)searchedInsuranceData).getDisease().name()));
		
		this.addComponent(new OutputTextArea("����",  searchedInsuranceData.getContent()));
		this.addComponent(new OutputTextArea("�������",  searchedInsuranceData.getInsuranceRateInfo()));
		// Ŭ�ٿ� ����, �������(�����, �����, ����� ���� ������, ����� ������)�� ���ִµ� ���� ����.

		this.addComponent(new BasicButton("���� ����", ShowInsuranceInfoToCustomerSystem.EActionCommands.SigninProduct.name(), actionListener));
	
		this.addToLinkPanel(
				new LinkButton("�� ����", ShowInsuranceInfoToCustomerSystem.EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", ShowInsuranceInfoToCustomerSystem.EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", ShowInsuranceInfoToCustomerSystem.EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", ShowInsuranceInfoToCustomerSystem.EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
	}

}
