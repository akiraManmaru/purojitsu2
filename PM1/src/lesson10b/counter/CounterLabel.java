package lesson10b.counter;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CounterLabel extends Label implements ActionListener {

	private int counter = 0;

	@Override
	public void actionPerformed(ActionEvent event) {
		String cl, calc;
		if (event.getActionCommand() == ">>3") {
			int i = Integer.toBinaryString(counter).length();
			calc = Integer.toBinaryString(counter).substring(0, i - 3);
			//long n = Integer.parseInt(calc) / 1000;
			//cl2 = String.valueOf(n);
			counter = Integer.parseInt(calc, 2);

		} else if (event.getActionCommand() == "-1") {
			counter -= 1;
		} else if (event.getActionCommand() == "+1") {
			counter += 1;
		} else if (event.getActionCommand() == "<<3") {
			calc = Integer.toBinaryString(counter) + "000";

			//long n = Integer.parseInt(calc) * 1000;
			//cl2 = String.valueOf(n);
			counter = Integer.parseInt(calc, 2);
		}
		cl = String.valueOf(counter);
		System.out.println("Action command: " + event.getActionCommand() + ", counter: " + cl);
		this.setText(cl);
	}
}
