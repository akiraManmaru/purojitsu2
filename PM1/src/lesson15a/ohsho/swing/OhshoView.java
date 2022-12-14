package lesson15a.ohsho.swing;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OhshoView implements ActionListener {

	private final Dimension DIMENSION = new Dimension(300, 150); // 表示フレームの幅,高さ
	private final String GYOZA = "コーテル"; // 「ギョーザ」を表す
	private final String CHAHAN = "ソーハン"; // 「チャーハン」を表す

	private Panel menuPanel;
	private Panel sizePanel;
	private Panel thirdPanel;
	private Button orderButton;
	private JCheckBox qButton;
	private Label printLabel;

	/**
	 * 各種パネルを表示する
	 */
	public void createView() {
		JFrame frame = new JFrame("ギョーザのオーショー"); // 表示フレームの生成
		JPanel panel = new JPanel(new GridLayout(4, 1)); // 4行1列の全パネルを生成
		panel.setBackground(Color.green);

		menuPanel = new MenuPanel(); // １行目のパネルを生成
		menuPanel.setBackground(Color.red);

		sizePanel = new SizePanel(); // ２行目のパネルを生成
		sizePanel.setBackground(Color.yellow);

		thirdPanel = new Panel(); // ３行目のパネルを生成
		thirdPanel.setBackground(Color.orange);
		qButton = new JCheckBox("お急ぎ"); // ボタンを生成
		qButton.addActionListener(this); // ボタンにアクションリスナ(このクラス)を追加
		thirdPanel.add(qButton);
		orderButton = new Button("注文"); // ボタンを生成
		orderButton.addActionListener(this); // ボタンにアクションリスナ(このクラス)を追加
		thirdPanel.add(orderButton); // ３行目のパネルにボタンを追加

		printLabel = new Label("ご注文をどうぞ");// ４行目のラベルを生成

		// 全体パネルに順に追加
		panel.add(menuPanel);
		panel.add(sizePanel);
		panel.add(thirdPanel);
		panel.add(printLabel);

		frame.add(panel); // 全体パネルをフレームに貼付ける
		frame.setSize(DIMENSION); // フレームのサイズをセット
		frame.setVisible(true); // フレームを表示する
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == orderButton) { // orderButtonが押されたとき
			String menuOrder = new String();

			if (((MenuPanel) menuPanel).getMenu() == null) {
				menuOrder = "メニューを決めてください";
			} else if (((MenuPanel) menuPanel).getMenu().equals("ギョーザ")) {
				menuOrder = sizeOrder(((SizePanel) sizePanel).getNinmae()) + GYOZA;
			} else if (((MenuPanel) menuPanel).getMenu().equals("チャーハン")) {
				menuOrder = CHAHAN + sizeOrder(((SizePanel) sizePanel).getNinmae());
			}
			if (qButton.isSelected()) {
				menuOrder = menuOrder + "かいかい";
			}

			printLabel.setText(menuOrder);
		}
	}

	private String sizeOrder(int i) {
		String ret = new String();
		if (i == 1) {
			ret = "イーガー";
		} else if (i == 2) {
			ret = "リャンガー";
		}

		return ret;
	}
}
