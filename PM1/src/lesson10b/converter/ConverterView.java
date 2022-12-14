package lesson10b.converter;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterView implements ActionListener {

	private Label msgLabel;
	private Label base2Label;
	private Label base8Label;
	private Label base10Label;
	private Label base16Label;

	private TextField numTextField;

	private CheckboxGroup baseGroup;
	/**
	 * 表示フレームの幅
	 */
	private static final int FRAME_WIDTH = 500;
	/**
	 * 表示フレームの高さ
	 */
	private static final int FRAME_HEIGHT = 300;

	/**
	 * Viewを生成する
	 */
	public Frame createView() {
		Frame frame = new Frame("Converter"); // フレームの生成
		//frame.setLayout(new GridLayout(1, 1));

		Panel p1 = new Panel(new GridLayout(7, 1));
		p1.setBackground(Color.pink);
		Panel p2 = new Panel();
		p2.setBackground(Color.cyan);
		p2.setLayout(new GridLayout(1, 4));
		Panel p3 = new Panel(/*new GridLayout(1, 2)*/);
		p3.setBackground(Color.cyan);

		baseGroup = new CheckboxGroup();
		Checkbox c1 = new Checkbox("2進数", baseGroup, false);
		Checkbox c2 = new Checkbox("8進数", baseGroup, false);
		Checkbox c3 = new Checkbox("10進数", baseGroup, false);
		Checkbox c4 = new Checkbox("16進数", baseGroup, false);

		p2.add(c1);
		p2.add(c2);
		p2.add(c3);
		p2.add(c4);

		msgLabel = new Label("メッセージ");
		base2Label = new Label("2進数は?");
		base8Label = new Label("8進数は?");
		base10Label = new Label("10進数は?");
		base16Label = new Label("16進数は?");

		numTextField = new TextField("", 20);
		p3.add(numTextField);
		Button b1 = new Button("変換");
		b1.addActionListener(this);
		p3.add(b1);

		p1.add(p2);
		p1.add(p3);
		p1.add(msgLabel);
		p1.add(base2Label);
		p1.add(base8Label);
		p1.add(base10Label);
		p1.add(base16Label);

		frame.add(p1);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); // フレームのサイズをセット
		frame.setVisible(true); // 

		return frame;
	}

	public void actionPerformed(ActionEvent event) {
		String num = numTextField.getText();
		if (num.isEmpty()) {
			return;
		}
		msgLabel.setText(baseGroup.getSelectedCheckbox().getLabel() + "の" + num + "を変換します");
		String a = null, b = null, c = null, d = null;
		if (baseGroup.getSelectedCheckbox().getLabel() == "2進数") {
			int n = Integer.parseInt(num, 2);
			a = num;
			b = Integer.toOctalString(n);
			c = String.valueOf(n);
			d = Integer.toHexString(n);

			base2Label.setText("2進数は" + num);
			base8Label.setText("8進数は" + Integer.toOctalString(n));
			base10Label.setText("10進数は" + String.valueOf(n));
			base16Label.setText("16進数は" + Integer.toHexString(n));

		} else if (baseGroup.getSelectedCheckbox().getLabel() == "8進数") {
			int n = Integer.parseInt(num, 8);
			a = Integer.toBinaryString(n);
			b = num;
			c = String.valueOf(n);
			d = Integer.toHexString(n);

			base2Label.setText("2進数は" + Integer.toBinaryString(n));
			base8Label.setText("8進数は" + num);
			base10Label.setText("10進数は" + String.valueOf(n));
			base16Label.setText("16進数は" + Integer.toHexString(n));

		} else if (baseGroup.getSelectedCheckbox().getLabel() == "10進数") {
			int n = Integer.parseInt(num);
			a = Integer.toBinaryString(n);
			b = Integer.toOctalString(n);
			c = num;
			d = Integer.toHexString(n);

			base2Label.setText("2進数は" + Integer.toBinaryString(n));
			base8Label.setText("8進数は" + Integer.toOctalString(n));
			base10Label.setText("10進数は" + num);
			base16Label.setText("16進数は" + Integer.toHexString(n));

		} else if (baseGroup.getSelectedCheckbox().getLabel() == "16進数") {
			int n = Integer.parseInt(num, 16);
			a = Integer.toBinaryString(n);
			b = Integer.toOctalString(n);
			c = String.valueOf(n);
			d = num;

			base2Label.setText("2進数は" + Integer.toBinaryString(n));
			base8Label.setText("8進数は" + Integer.toOctalString(n));
			base10Label.setText("10進数は" + String.valueOf(n));
			base16Label.setText("16進数は" + num);

		} else {
			msgLabel.setText("error");
		}

		System.out.println("==> " + baseGroup.getSelectedCheckbox().getLabel() + "を選択");
		System.out.println("==> メッセージは" + msgLabel.getText());
		System.out.println("==> 2進数: " + a + " 8進数: " + b + " 10進数: " + c + " 16進数: " + d);

	}

}
