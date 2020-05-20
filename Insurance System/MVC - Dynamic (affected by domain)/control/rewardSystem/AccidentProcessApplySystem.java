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
// �������
	
	// Static
	private enum EActionCommands {SaveAccidentData}
	
	// Component
	//��� ���� â�� ��� ����(��� ����, ��� ��ġ, ��� �ð�)
	private TitledTextArea accidentTypeTTA;
	private TitledTextArea accidentLocationTTA = new TitledTextArea("��� ��ġ", 5, "", true);
	private TitledTextArea accidentDateTTA = new TitledTextArea("��� �ð�", 2, "", true);
	
	@Override
	public Vector<JComponent> getViewInfo() {
		this.accidentTypeTTA = new TitledTextArea("��� ����", 2, "", true);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("��� ������ �Է��� �ּ���"));
		viewInfo.add(this.accidentTypeTTA);
		viewInfo.add(this.accidentLocationTTA);
		viewInfo.add(this.accidentDateTTA);
		viewInfo.add(new BasicButton("�Ϸ�", EActionCommands.SaveAccidentData.name(), this.actionListener));
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
