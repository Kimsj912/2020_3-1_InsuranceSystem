package view.insuranceSystemView.salesView.salesManager;

import java.awt.Color;
import java.awt.event.ActionListener;

import control.salesSystem.salesManagerAspect.SaveSalesTrainingPlanSystem;
import model.aConstant.ETrainingTargetEmployee;
import component.BasicLabel;
import component.SeparateLine;
import component.TitledRadioButtonGroup;
import component.button.ActionButton;
import component.button.LinkButton;
import component.group.StaticGroup;
import component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class SaveSalesTrainingPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;
	//component
	private InputTextArea titleTTA, salesTrainingDateTTA, salesTrainingPlaceTTA, salesTrainingGoalTTA, salesTrainingContentTTA;
	private TitledRadioButtonGroup salesTrainingTargetTTA;

	public SaveSalesTrainingPlanView(ActionListener actionListener) {
		// create component
		this.titleTTA = new InputTextArea("����", "", 1, 120);
		this.salesTrainingDateTTA = new InputTextArea("������¥", "yyyy-MM-dd HH:mm", 1, 120);
		this.salesTrainingPlaceTTA = new InputTextArea("���", "", 1, 120);
		this.salesTrainingTargetTTA = new TitledRadioButtonGroup("�������", ETrainingTargetEmployee.class, true, 120);
		this.salesTrainingGoalTTA = new InputTextArea("���� ��ǥ", "", 5, 120);
		this.salesTrainingContentTTA = new InputTextArea("��������", "", 15, 120);

		// add component
		this.addComponent(new BasicLabel("����Ȱ�� ��ȹ �Է�"));
		this.addComponent(new SeparateLine(Color.black));

		StaticGroup g = new StaticGroup(new int[] {2,2,1,1});
		g.addGroupComponent(titleTTA, this.salesTrainingDateTTA,
				this.salesTrainingPlaceTTA,this.salesTrainingTargetTTA,
				this.salesTrainingGoalTTA,
				this.salesTrainingContentTTA
			);
		this.addComponent(g);
		this.addComponent(new ActionButton("����", SaveSalesTrainingPlanSystem.EActionCommands.Save.name(), actionListener));

		this.addToLinkPanel(
				new LinkButton("�Ǹ� ��ȹ", SaveSalesTrainingPlanSystem.EActionCommands.SaveActivityPlan.name(), actionListener),
				new LinkButton("���� ����", SaveSalesTrainingPlanSystem.EActionCommands.SaveSalesTrainingPlan.name(), actionListener)
		);
	}

	//get & set
	public InputTextArea getTitleTTA() {return titleTTA;}
	public void setTitleTTA(InputTextArea titleTTA) {this.titleTTA = titleTTA;}
	public InputTextArea getSalesTrainingDateTTA() {return salesTrainingDateTTA;}
	public void setSalesTrainingDateTTA(InputTextArea salesTrainingDateTTA) {this.salesTrainingDateTTA = salesTrainingDateTTA;}
	public InputTextArea getSalesTrainingPlaceTTA() {return salesTrainingPlaceTTA;}
	public void setSalesTrainingPlaceTTA(InputTextArea salesTrainingPlaceTTA) {this.salesTrainingPlaceTTA = salesTrainingPlaceTTA;}
	public InputTextArea getSalesTrainingGoalTTA() {return salesTrainingGoalTTA;}
	public void setSalesTrainingGoalTTA(InputTextArea salesTrainingGoalTTA) {this.salesTrainingGoalTTA = salesTrainingGoalTTA;}
	public InputTextArea getSalesTrainingContentTTA() {return salesTrainingContentTTA;}
	public void setSalesTrainingContentTTA(InputTextArea salesTrainingContentTTA) {this.salesTrainingContentTTA = salesTrainingContentTTA;}
	public TitledRadioButtonGroup getSalesTrainingTargetTTA() {return salesTrainingTargetTTA;}
	public void setSalesTrainingTargetTTA(TitledRadioButtonGroup salesTrainingTargetTTA) {this.salesTrainingTargetTTA = salesTrainingTargetTTA;}

}
