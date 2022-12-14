package lesson10a.calc;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView implements ActionListener {
	private TextField valueField;
	private Label resultLabel;

	public void createView() {
		Frame viewFrame = new Frame("Calculator");
		viewFrame.setSize(300, 200);
		viewFrame.setLayout(new GridLayout(3, 1));
		/* viewFrameのサイズを300x200に設定、また縦3横1のGridLayoutを設定 */

		Panel typePanel = new Panel(new GridLayout(1, 3));
		/* typePanelに縦1横3のGridLayoutを設定 */
		Button button1 = new Button("二乗");
		Button button2 = new Button("平方根");
		Button button3 = new Button("サイン");
		/* 3つのButtonオブジェクトにActionListenerを設定*/
		typePanel.add(button1);
		typePanel.add(button2);
		typePanel.add(button3);
		/* typePanelに3つのButtonオブジェクトを追加*/

		valueField = new TextField();
		resultLabel = new Label("");
		viewFrame.add(typePanel);
		viewFrame.add(valueField);
		viewFrame.add(resultLabel);
		/* viewFrameに、typePanel・valueField・resultLabelを追加 */
		viewFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		double val;
		double resultVal = 0;

		String str = valueField.getText();/* valueFieldに入力された文字列を得る */
		if (str.isEmpty()) {
			return;
		} else {
			val = Double.parseDouble(valueField.getText()); // 文字列をdoubleの値に変換
		}

		switch (event.getActionCommand()/* 押されたButtonの名前を得る */) {
		case "二乗":
			resultVal = val * val;

			break;
		case "平方根":
			resultVal = Math.sqrt(val);
			break;
		case "サイン":
			resultVal = Math.sin(val);
			break;
		}
		String rv = Double.valueOf(resultVal).toString();
		resultLabel.setText(rv);
		/* resultLabelに計算結果を表す文字列をセットする */
	}
}
