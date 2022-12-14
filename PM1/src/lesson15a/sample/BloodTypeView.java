package lesson15a.sample;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BloodTypeView implements ActionListener {
	private final Dimension DIMENSION = new Dimension(500, 75); // 表示フレームの幅，高さ
	private JRadioButton a, b, o, ab; // ラジオボタン

	/**
	 * 各種パネルを表示する
	 */
	public void createView() {
		JFrame frame = new JFrame("血液型選択"); // 表示フレームの生成
		JPanel panel = new JPanel(); // パネルを生成

		a = new JRadioButton("A型", true);
		// 「A型」のラジオボタン．第２引数がtrueなので，初期状態で選択状態
		b = new JRadioButton("B型");
		// 「B型」のラジオボタン．初期状態では選択されていない
		o = new JRadioButton("O型");
		// 「O型」のラジオボタン．初期状態では選択されていない
		ab = new JRadioButton("AB型");
		// 「AB型」のラジオボタン．初期状態では選択されていない

		ButtonGroup bg = new ButtonGroup(); // ButtonGroupのインスタンス
		bg.add(a);
		bg.add(b);
		bg.add(o);
		bg.add(ab);
		/* ラジオボタンをButtonGroupに追加
		   同じButtonGroupのラジオボタンは，１つのみ選択状態になる */

		// パネルにラジオボタンを追加
		JLabel label = new JLabel("右から血液型を選んでください：");
		panel.add(label);
		panel.add(a);
		panel.add(b);
		panel.add(o);
		panel.add(ab);

		// ActionListenerへの追加
		a.addActionListener(this);
		b.addActionListener(this);
		o.addActionListener(this);
		ab.addActionListener(this);

		frame.add(panel); // パネルをフレームに貼付ける
		frame.setSize(DIMENSION); // フレームのサイズをセット
		frame.setVisible(true); // フレームを表示する
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == a) {
			System.out.println("A型");
		} else if (e.getSource() == b) {
			System.out.println("B型");
		} else if (e.getSource() == ab) {
			System.out.println("AB型");
		} else if (e.getSource() == o) {
			System.out.println("O型");
		}

	}

	public static void main(String[] args) {
		BloodTypeView btv = new BloodTypeView();
		btv.createView();
	}
}
