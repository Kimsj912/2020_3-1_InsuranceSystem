package main;

import control.StaticSystem;
import control.loginSystem.RealLoginSystem;
import model.aConstant.EDataListID;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import model.data.activityPlanData.ActivityPlanData;
import model.data.customerData.CustomerData;
import model.data.employeeData.developEmployeeData.DeveloperData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.employeeData.salesEmployeeData.SalesManData;
import model.data.employeeData.salesEmployeeData.SalesManagerData;
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

		CustomerData customerData = new CustomerData();
		customerData.setName("customer");
		customerData.setLoginID("c");
		customerData.setLoginPW("123");

		// Create Data - sales line
		SalesManData salesManData = new SalesManData();
		salesManData.setName("SalesMan");
		salesManData.setLoginID("s");
		salesManData.setLoginPW("123");

		
		SalesManagerData salesManagerData = new SalesManagerData();
		salesManagerData.setName("SalesManager");
		salesManagerData.setLoginID("ss");
		salesManagerData.setLoginPW("123");
		
		ActivityPlanData activityPlanData = new ActivityPlanData();
		activityPlanData.setTitle("activityPlan");
		
		SalesTrainingPlanData salesTrainingPlanData = new SalesTrainingPlanData();
		salesTrainingPlanData.setTitle("salesTrainingPlan");
		
		
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
		
		// create System - sales line
		ISDataList<SalesManData> salesManDataList = new ISDataList<SalesManData>(); //영업사원 리스트 만들기
		salesManDataList.setID(EDataListID.SalesManDataListID.ordinal());
		salesManDataList.add(salesManData); //영업사원 추가하기

		ISDataList<SalesManagerData> salesManagerDataList = new ISDataList<SalesManagerData>(); //영업사원 리스트 만들기
		salesManagerDataList.setID(EDataListID.SalesManagerDataListID.ordinal());
		salesManagerDataList.add(salesManagerData); //영업사원 추가하기
		
		ISDataList<ActivityPlanData> activityPlanDataList = new ISDataList<ActivityPlanData>(); //고객 리스트 만들기
		activityPlanDataList.setID(EDataListID.ActivityPlanDataListID.ordinal());
		
		ISDataList<SalesTrainingPlanData> salesTrainigPlanDataList = new ISDataList<SalesTrainingPlanData>(); //고객 리스트 만들기
		salesTrainigPlanDataList.setID(EDataListID.SalesTrainigPlanDataListID.ordinal());
		
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
		system.associateModel(salesManDataList);
		system.associateModel(salesManagerDataList);
		system.associateModel(activityPlanDataList);
		system.associateModel(salesTrainigPlanDataList);
		// Start
		system.startNewDynamicSystem(new RealLoginSystem());
	}
}
