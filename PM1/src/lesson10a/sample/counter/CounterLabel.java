package lesson10a.sample.counter;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CounterLabel extends Label implements ActionListener {

	private int counter = 0;

	@Override
	public void actionPerformed(ActionEvent event) {
		counter += 1;
		this.setText("ボタンを" + counter + "回押しました");
	}
}
