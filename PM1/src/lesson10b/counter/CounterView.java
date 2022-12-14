package lesson10b.counter;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class CounterView {
	/**
	 * 表示フレームの幅
	 */
	private static final int FRAME_WIDTH = 400;
	/**
	 * 表示フレームの高さ
	 */
	private static final int FRAME_HEIGHT = 50;

	/**
	 * Viewを生成する
	 */
	public Frame createView() {
		Frame frame = new Frame("Counter"); // フレームの生成

		Panel panel = new Panel(new GridLayout(1, 5)); // 5行1列のパネルの生成
		panel.setBackground(Color.orange);

		Button b1 = new Button(">>3"); // ボタンの生成
		Button b2 = new Button("-1");
		Button b3 = new Button("+1");
		Button b4 = new Button("<<3");

		CounterLabel counterLabel = new CounterLabel(); // ラベルの生成

		b1.addActionListener(counterLabel); // ボタンにアクションリスナ(countLabel)を追加
		b2.addActionListener(counterLabel);
		b3.addActionListener(counterLabel);
		b4.addActionListener(counterLabel);

		panel.add(b1); // パネルにボタンを追加
		panel.add(b2);
		panel.add(counterLabel);
		panel.add(b3);
		panel.add(b4);

		frame.add(panel); // 生成パネルをフレームに貼付ける

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); // フレームのサイズを設定
		frame.setVisible(true); // フレームを表示

		return frame;
	}
}
