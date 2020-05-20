package main;

import control.StaticSystem;
import control.loginSystem.RealLoginSystem;
import model.aConstant.EDataListID;
import model.data.customerData.CustomerData;
import model.data.employeeData.developEmployeeData.DeveloperData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.dataList.realDataList.ISDataList;
import view.frame.realFrame.MainFrame;

public class Main {

	// TODO
	// 요율 검증, 보험 인수 지금 하나의 계정을 고정적으로 사용--- 로그인 만들기....
		// 그에 따른 몇몇 코드 수정
	// 보험 별 페이지 만들기. 현재는 자동차가 전체를 대신하고 있음.
	
	public static void main(String[] args) {
		// Create Data
		DeveloperData developer = new DeveloperData();
		developer.setName("Developer");
		developer.setLoginID("d");
		developer.setLoginPW("123");

		InsuranceRatePermitManData insuranceRatePermitManData = new InsuranceRatePermitManData();
		insuranceRatePermitManData.setName("InsuranceRatePermitManData");
		insuranceRatePermitManData.setLoginID("i");
		insuranceRatePermitManData.setLoginPW("123");

		ProductPermitManData productPermitManData = new ProductPermitManData();
		productPermitManData.setName("ProductPermitManData");
		productPermitManData.setLoginID("p");
		productPermitManData.setLoginPW("123");

		// Create Model
		ISDataList<DeveloperData> developerDataList = new ISDataList<DeveloperData>();
		developerDataList.setID(EDataListID.DeveloperDataListID.ordinal());
		developerDataList.add(developer);

		ISDataList<InsuranceRatePermitManData> insuranceRatePermitManDataList = new ISDataList<InsuranceRatePermitManData>();
		insuranceRatePermitManDataList.setID(EDataListID.InsuranceRatePermitManDataListID.ordinal());
		insuranceRatePermitManDataList.add(insuranceRatePermitManData);

		ISDataList<ProductPermitManData> productPermitManDataList = new ISDataList<ProductPermitManData>();
		productPermitManDataList.setID(EDataListID.ProductPermitManDataListID.ordinal());
		productPermitManDataList.add(productPermitManData);
		
		ISDataList<AbsInsuranceData> insuranceDataList = new ISDataList<AbsInsuranceData>();
		insuranceDataList.setID(EDataListID.InsuranceDataListID.ordinal());
		
		ISDataList<CustomerData> customerDataList = new ISDataList<CustomerData>();
		customerDataList.setID(EDataListID.CustomerDataListID.ordinal());
		
		
		// Create View
		MainFrame view = new MainFrame();
		
		// Create System
		StaticSystem system = new StaticSystem();
		system.associateMainFrame(view);
		system.associateModel(developerDataList);
		system.associateModel(insuranceRatePermitManDataList);
		system.associateModel(productPermitManDataList);
		system.associateModel(insuranceDataList);
		system.associateModel(customerDataList);
		
		// Start
		system.startNewDynamicSystem(new RealLoginSystem());
	}
}
