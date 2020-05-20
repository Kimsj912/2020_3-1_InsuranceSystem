package control.rewardSystem;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.loginSystem.RealLoginSystem;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class AccidentProcessApplySystem extends RewardSystem{
// 사고접수
	
	// Static
	private enum EActionCommands {SaveAccidentData}
	
	// Component
	//사고 접수 창에 사고 정보(사고 유형, 사고 위치, 사고 시간)
	private TitledTextArea accidentTypeTTA;
	private TitledTextArea accidentLocationTTA = new TitledTextArea("사고 위치", 5, "", true);
	private TitledTextArea accidentDateTTA = new TitledTextArea("사고 시간", 2, "", true);
	
	@Override
	public Vector<JComponent> getViewInfo() {
		this.accidentTypeTTA = new TitledTextArea("사고 유형", 2, "", true);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("사고 정보를 입력해 주세요"));
		viewInfo.add(this.accidentTypeTTA);
		viewInfo.add(this.accidentLocationTTA);
		viewInfo.add(this.accidentDateTTA);
		viewInfo.add(new BasicButton("완료", EActionCommands.SaveAccidentData.name(), this.actionListener));
		return viewInfo;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SaveAccidentData : return new RealLoginSystem();
		}
		return null;
	}

}
