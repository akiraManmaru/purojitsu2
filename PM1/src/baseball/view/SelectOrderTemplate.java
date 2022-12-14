package baseball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 並列処理のおなじない
 */
@SuppressWarnings("serial")
public class SelectOrderTemplate extends JPanel {

	// private final Dimension PANEL_SIZE = new Dimension(140, 270); // パネルの大きさ
	private final Dimension KEYFIELD_BUTTON_SIZE = new Dimension(130, 20);// ボタンの大きさ

	public SelectOrderTemplate(String title, Dimension dimension, List<JRadioButton> buttons,
			Color color) {

		setPreferredSize(dimension);
		setBackground(color);
		createView(title, buttons);
	}

	private void createView(String title, List<JRadioButton> buttons) { // タイトルとボタン群を並べる

		JLabel jLabel = new JLabel(title);
		jLabel.setPreferredSize(KEYFIELD_BUTTON_SIZE);
		add(jLabel);

		for (JRadioButton b : buttons) {
			b.setPreferredSize(KEYFIELD_BUTTON_SIZE);
			add(b);
		}
	}
}
