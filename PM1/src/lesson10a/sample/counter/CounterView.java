package lesson10a.sample.counter;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.Button;
import java.awt.Color;

public class CounterView {
	/**
	 * 表示フレームの幅
	 */
	private static final int FRAME_WIDTH = 200;
	/**
	 * 表示フレームの高さ
	 */
	private static final int FRAME_HEIGHT = 100;

	/**
	 * Viewを生成する
	 */
	public void createView() {
		Frame frame = new Frame("Counter"); // フレームの生成

		Panel panel = new Panel(new GridLayout(2, 1)); // 2行1列のパネルの生成
		panel.setBackground(Color.yellow);

		Button counterButton = new Button("カウント"); // ボタンの生成
		CounterLabel counterLabel = new CounterLabel(); // ラベルの生成

		counterButton.addActionListener(counterLabel); // ボタンにアクションリスナ(countLabel)を追加

		panel.add(counterButton); // パネルにボタンを追加
		panel.add(counterLabel); // パネルにラベルを追加

		frame.add(panel); // 生成パネルをフレームに貼付ける

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); // フレームのサイズを設定
		frame.setVisible(true); // フレームを表示
	}
}
