package control.salesSystem.salesManAspect.SigninCustomer;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.aConstant.EAccidentHistory;
import model.aConstant.EFamilyIllHistory;
import model.aConstant.EGender;
import model.data.customerData.CustomerData;
import view.insuranceSystemView.salesView.salesMan.SigninCustomer.SinginCustomerView;
import view.panel.BasicPanel;

public class SinginCustomerSystem extends SalesSystem {
	// Static
	public enum EActionCommands {Save, SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}

	private SinginCustomerView view;
	
	@Override
	public BasicPanel getPanel() {
		this.view = new SinginCustomerView(actionListener);
		return this.view;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Save : if(!this.save()){ }else {this.gotoBack(); return null;}
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
	
	private boolean save() {
		CustomerData data = new CustomerData();
		try {
			// String no limit
			data.setLoginID(this.view.getLoginIDTTA().getContent());
			data.setLoginPW(this.view.getLoginPWTTA().getContent());
			data.setName(this.view.getNameTTA().getContent());
			data.setResidence(this.view.getResidenceTTA().getContent());
			data.setJob(this.view.getJobTTA().getContent());

			// int no limit
			data.setProperty(Integer.parseInt(this.view.getPropertyTTA().getContent()));
			
			// String and limit
			String email = this.view.getEmailTTA().getContent();
			if(email.contains("@")&&email.contains(".")) {data.setEmail(email);}else {throw new EMailFormatException();}
			
			String socialSecu = this.view.getSocialSecurityNumTTA().getContent();
			if(socialSecu.contains("-")&&socialSecu.length()==14){data.setSocialSecurityNum(socialSecu);}else {throw new SocialSecurityNumException();}
			
			String account = this.view.getAccountNumTTA().getContent();
			if(account.contains("-")&&account.length()>12){data.setAccountNum(account);}else {throw new AccountNumException();}

			String phone = this.view.getPhoneNumTTA().getContent();
			if(phone.contains("-")&&phone.length()==13){data.setPhoneNum(phone);}else {throw new PhoneNumException();}

			// int limit
			int age = Integer.parseInt(this.view.getAgeTTA().getContent());
			if(age<120 && age>=0){data.setAge(age);}else {throw new NumberFormatException();}
			
			// enum
			data.setIllHistory(multipleChoice(EFamilyIllHistory.class, this.view.getFamilyillhistoryRBN().getSelectedOptionNames()));
			data.setAccidentHistory(multipleChoice(EAccidentHistory.class, this.view.getAccidentHistoryRBN().getSelectedOptionNames()));
			data.setGender(cleaningGender(EGender.valueOf(this.view.getGenderRBN().getSelectedOptionNames().get(0))));

		} catch (NumberFormatException e) {JOptionPane.showMessageDialog(this.view, "���� ���� ������ �ʰ��Ͽ��ų� ���ڰ� �����ֽ��ϴ�. ������ �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		} catch (EMailFormatException e) {JOptionPane.showMessageDialog(this.view, "�̸��� ������ �����ʽ��ϴ�. @�� .�� �����Ͽ����� �ٽ� Ȯ�����ֽʽÿ�.");return false;
		} catch (SocialSecurityNumException e) {JOptionPane.showMessageDialog(this.view, "�ֹι�ȣ ������ �����ʽ��ϴ�. -�� �����Ͽ� 14�ڸ����� �ٽ� Ȯ�����ֽʽÿ�."); return false;
		} catch (AccountNumException e) {JOptionPane.showMessageDialog(this.view, "���¹�ȣ ������ �����ʽ��ϴ�. 12�ڸ� �̻� -�� �����Ͽ����� Ȯ�����ֽʽÿ�.");return false;
		} catch (PhoneNumException e) {JOptionPane.showMessageDialog(this.view, "��ȭ��ȣ ������ �����ʽ��ϴ�. -�� �����Ͽ� 13�ڸ����� Ȯ�����ֽʽÿ�.");return false;
		}
		this.customerDataList.add(data);
		return true;
	}
	private <E> Vector<E> multipleChoice(Class<E> enumClass, Vector<String> selectedOptionNames) {
		Vector<E> returnVect = new Vector<E>();
		for(String s : selectedOptionNames) {
			for(E e : enumClass.getEnumConstants()) {if(e.toString().equals(s)) {returnVect.add(e);}}
		} return returnVect;
	}
	public boolean cleaningGender(EGender eGender) {if(EGender.male.equals(eGender)) {return true;}return false;}
	private class EMailFormatException extends Throwable{private static final long serialVersionUID = 1L;}
	private class SocialSecurityNumException extends Throwable{private static final long serialVersionUID = 1L;}
	private class AccountNumException extends Throwable{private static final long serialVersionUID = 1L;}
	private class PhoneNumException extends Throwable{private static final long serialVersionUID = 1L;}
}
