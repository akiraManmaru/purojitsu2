package lesson10a.sample.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AwtComponent implements ActionListener {
	private Label statusLabel;
	private boolean isWorking = false;
	private Scrollbar scrollbar;

	@Override
	public void actionPerformed(ActionEvent event) {
		if (isWorking) {
			isWorking = false;
			statusLabel.setText("停止中");
		} else {
			isWorking = true;
			statusLabel.setText("起動中：出力");
			scrollbar.getValue();

		}

	}

	public void createView() {

		Frame viewFrame = new Frame("View");
		viewFrame.setSize(100, 80);
		viewFrame.setLayout(new GridLayout(3, 1));

		statusLabel = new Label("停止中");
		Scrollbar scrollBar = new Scrollbar(Scrollbar.HORIZONTAL);
		Button button = new Button("起動!");

		viewFrame.add(statusLabel);
		viewFrame.add(scrollBar);
		viewFrame.add(button);
		viewFrame.setVisible(true);
		button.addActionListener(this);
	}

	public static void main(String[] args) {
		AwtComponent view = new AwtComponent();
		view.createView();
	}
}
