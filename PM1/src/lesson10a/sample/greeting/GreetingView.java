package lesson10a.sample.greeting;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreetingView implements ActionListener {
	/**
	 * 表示フレームの幅
	 */
	private static final int FRAME_WIDTH = 300;
	/**
	 * 表示フレームの高さ
	 */
	private static final int FRAME_HEIGHT = 100;

	private Button nameButton;
	private TextField nameTextField;
	private Label greetLabel;

	/**
	 * 各種パネルを表示する
	 */
	public void createView() {

		Frame frame = new Frame("Greet"); // 表示フレームの生成

		Panel panel = new Panel(new GridLayout(2, 1)); // 2行1列の全パネルを生成
		panel.setBackground(Color.pink);

		Panel topPanel = new Panel(); // 上部パネルを生成
		topPanel.setBackground(Color.yellow);

		nameTextField = new TextField("", 20); // テキストフィールドを生成
		nameButton = new Button("挨拶"); // ボタンを生成
		nameButton.addActionListener(this); // 　ボタンにアクションリスナ(このクラス)を追加

		topPanel.add(nameTextField); // 上部パネルにテキストフィールドを追加
		topPanel.add(nameButton); // 上部パネルにボタンを追加

		greetLabel = new Label("挨拶ボタンを押してください"); // ラベルを生成

		panel.add(topPanel); // 全パネル1行目に上部パネルを追加
		panel.add(greetLabel); // 全パネル2行目にラベルを追加
		frame.add(panel); // 全パネルをフレームに貼付ける

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); // フレームのサイズをセット
		frame.setVisible(true); // フレームを表示する
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == nameButton) { // nameButtonが押されたとき
			String name = nameTextField.getText(); // テキストフィールドの文字を取得
			greetLabel.setText("こんにちは、" + name + "さん"); // ラベルに挨拶を表示
		}
	}
}
