package view.insuranceSystemView.developView.developer.showInsurance;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.insuranceData.AbsInsuranceData;
import model.dataList.IntISDataList;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.TitledRadioButtonGroup;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class SelectInsuranceToWatchView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {InsuranceDesign, WatchInsuranceData}
		
	// Component
	private InputTextArea nameTTA, contentTTA, insuranceRateInfoTTA, lossPercentTTA;
	private TitledRadioButtonGroup diseaseTRBG;
		
	// Constructor
	public SelectInsuranceToWatchView(ActionListener actionListener, IntISDataList<AbsInsuranceData> insuranceList) {
		InsuranceSystemView view = new InsuranceSystemView();
		view.addComponent(new BasicLabel("보험 선택"));
		view.addComponent(new SeparateLine(Color.black));
		
		DynamicGroup selectBtnGroup = new DynamicGroup();
		for(AbsInsuranceData insuranceData : insuranceList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), actionListener));
		}
		view.addComponent(selectBtnGroup);
		
		view.addToLinkPanel(
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
	
	// Getter & Setter
	public String getName() {return this.nameTTA.getContent();}
	public String getContent() {return this.contentTTA.getContent();}
	public String getInsuranceRateInfo() {return this.insuranceRateInfoTTA.getContent();}
	public String getLossPercent() {return this.lossPercentTTA.getContent();}
	public String getDisease() {return this.diseaseTRBG.getSelectedOptionNames().get(0);}
}
