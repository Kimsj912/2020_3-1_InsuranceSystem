package view.insuranceSystemView.salesView.salesManager;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManagerAspect.SaveActivityPlanSystem;
import model.aConstant.ETargetCustomer;
import component.BasicLabel;
import component.SeparateLine;
import component.TitledRadioButtonGroup;
import component.button.ActionButton;
import component.button.LinkButton;
import component.group.StaticGroup;
import component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class SaveActivityPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	

	// component
	private InputTextArea titleTTA, activityGoalTTA, dateTTA, salesGoalTTA, additionalJobOfferTTA;
	private TitledRadioButtonGroup salesTargetCustomerTTA;

	public SaveActivityPlanView(ActionListener actionListener) {
		// create component
		this.titleTTA = new InputTextArea("����", "", 1, 120); 
		this.dateTTA = new InputTextArea("Ȱ���Ⱓ", "ex) yyyy-mm-dd", 1, 120);
		this.salesGoalTTA = new InputTextArea("���� ��ǥ", "ex) 10000", 2, 120);
		this.activityGoalTTA = new InputTextArea("Ȱ�� ��ǥ", "", 10, 120);
		this.additionalJobOfferTTA = new InputTextArea("�߰� ���η�", "ex) 1", 1, 120);
		this.salesTargetCustomerTTA = new TitledRadioButtonGroup("�ַ� �� ����", ETargetCustomer.class, false, 120);

		// add component
		this.addComponent(new BasicLabel("Ȱ����ȹ�� �ۼ�"));
		this.addComponent(new SeparateLine(Color.black));

		StaticGroup g = new StaticGroup(new int[] { 2,2, 1, 1 });
		g.addGroupComponent(titleTTA, dateTTA, salesGoalTTA,  additionalJobOfferTTA,
				salesTargetCustomerTTA,activityGoalTTA);
		this.addComponent(g);
		this.addComponent(new ActionButton("����", SaveActivityPlanSystem.EActionCommands.Save.name(), actionListener));
		this.addToLinkPanel(
				new LinkButton("�Ǹ� ��ȹ", SaveActivityPlanSystem.EActionCommands.SaveActivityPlan.name(), actionListener),
				new LinkButton("���� ����", SaveActivityPlanSystem.EActionCommands.SaveSalesTrainingPlan.name(), actionListener)
		);

	}
	
	//get & set
	public InputTextArea getTitleTTA() {return titleTTA;}
	public void setTitleTTA(InputTextArea titleTTA) {this.titleTTA = titleTTA;}
	public InputTextArea getActivityGoalTTA() {return activityGoalTTA;}
	public void setActivityGoalTTA(InputTextArea activityGoalTTA) {this.activityGoalTTA = activityGoalTTA;}
	public InputTextArea getDateTTA() {return dateTTA;}
	public void setDateTTA(InputTextArea dateTTA) {this.dateTTA = dateTTA;}
	public InputTextArea getSalesGoalTTA() {return salesGoalTTA;}
	public void setSalesGoalTTA(InputTextArea salesGoalTTA) {this.salesGoalTTA = salesGoalTTA;}
	public InputTextArea getAdditionalJobOfferTTA() {return additionalJobOfferTTA;}
	public void setAdditionalJobOfferTTA(InputTextArea additionalJobOfferTTA) {this.additionalJobOfferTTA = additionalJobOfferTTA;}
	public TitledRadioButtonGroup getSalesTargetCustomerTTA() {return salesTargetCustomerTTA;}
	public void setSalesTargetCustomerTTA(TitledRadioButtonGroup salesTargetCustomerTTA) {this.salesTargetCustomerTTA = salesTargetCustomerTTA;}

}
